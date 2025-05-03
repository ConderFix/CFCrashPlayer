package ru.quizie.cfcrashplayer;

import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;

public class Config {

    public static void load(FileConfiguration config) {
        whitelist = config.getStringList("white-list");
    }

    public static List<String> whitelist;
}
