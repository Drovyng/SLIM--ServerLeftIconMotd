package com.drovyng.slim;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class SLIM extends JavaPlugin {
    public static List<String> Texts;
    @Override
    public void onEnable() {
        // What should this plugin do on startup?

        saveDefaultConfig();

        FileConfiguration config = getConfig();
        Texts = config.getStringList("texts");
        if (Texts.isEmpty()){
            Texts.add("Админ лентяй!");
            config.set("texts", Texts);
            saveConfig();
        }
        getServer().getPluginManager().registerEvents(new ServerPingEvent(), this);
        getLogger().info("Loaded SLIM Successfully!");
    }

    @Override
    public void onDisable() {
        // What should this plugin after disabling?
    }
}
