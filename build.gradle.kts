import java.net.URI

plugins {
    id("java")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

group = "me.playbosswar.worldguardconditions"
version = "1.0.0"

repositories {
    mavenCentral()
    mavenLocal()

    maven {
        url = URI("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    }

    maven {
        url = URI("https://maven.enginehub.org/repo/")
    }
}

dependencies {
    compileOnly("me.playbosswar.com:commandtimer:8.0.0")
    compileOnly("org.jeasy:easy-rules-core:4.1.0")
    compileOnly("org.jetbrains:annotations:23.1.0")
    compileOnly("com.sk89q.worldguard:worldguard-bukkit:7.0.9")
    implementation("net.kyori:event-api:3.0.0")
    implementation("org.spigotmc:spigot-api:1.17.1-R0.1-SNAPSHOT")
}
