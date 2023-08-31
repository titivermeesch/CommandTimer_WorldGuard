package me.playbosswar.worldguardconditions.conditions;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.util.Location;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import com.sk89q.worldguard.protection.regions.RegionContainer;
import com.sk89q.worldguard.protection.regions.RegionQuery;
import me.playbosswar.com.api.ConditionRule;
import me.playbosswar.com.api.NeededValue;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class IsInRegion implements ConditionRule {
    @Override
    public String getName() {
        return "IS_IN_REGION";
    }

    @Override
    public String getDescription() {
        return "Check if player is in a specific region";
    }

    @Override
    public ArrayList<NeededValue<?>> getNeededValues() {
        ArrayList<NeededValue<?>> values = new ArrayList<>();
        values.add(new NeededValue<>("region", "Region", String.class, ""));
        return values;
    }

    @Override
    public boolean evaluate(Facts facts) {
        Player p = facts.get("player");
        String regionName = facts.get("region");

        if (p == null) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                Location loc = BukkitAdapter.adapt(player.getLocation());
                RegionContainer container = WorldGuard.getInstance().getPlatform().getRegionContainer();
                RegionQuery query = container.createQuery();
                ApplicableRegionSet set = query.getApplicableRegions(loc);

                for (ProtectedRegion region : set) {
                    if (region.getId().equals(regionName)) {
                        return true;
                    }
                }
            }

            return false;
        }

        Location loc = BukkitAdapter.adapt(p.getLocation());
        RegionContainer container = WorldGuard.getInstance().getPlatform().getRegionContainer();
        RegionQuery query = container.createQuery();
        ApplicableRegionSet set = query.getApplicableRegions(loc);

        for (ProtectedRegion region : set) {
            if (region.getId().equals(regionName)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void execute(Facts facts) {

    }

    @Override
    public int compareTo(@NotNull Rule o) {
        return 0;
    }
}
