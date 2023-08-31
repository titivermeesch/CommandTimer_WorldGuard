package me.playbosswar.worldguardconditions;

import me.playbosswar.com.api.ConditionExtension;
import me.playbosswar.com.api.ConditionRules;
import me.playbosswar.com.api.events.EventExtension;
import me.playbosswar.worldguardconditions.conditions.IsInRegion;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class CommandTimerWorldGuardConditions extends ConditionExtension {
    ConditionRules rules = new ConditionRules();

    public CommandTimerWorldGuardConditions() {
        rules.register(new IsInRegion());
    }

    @Override
    @NotNull
    public String getConditionGroupName() {
        return "WORLDGUARD";
    }

    @Override
    @NotNull
    public String[] getDescription() {
        return new String[]{"§7Look up WorldGuard data for certain conditions"};
    }

    @Override
    public String getRequiredPlugin() {
        return "WorldGuard";
    }

    @Override
    public @NotNull String getAuthor() {
        return "PlayBossWar";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0";
    }

    public @NotNull ConditionRules getRules() {
        return rules;
    }

    public ArrayList<EventExtension> getEvents() {
        ArrayList<EventExtension> events = new ArrayList<>();

        return events;
    }
}
