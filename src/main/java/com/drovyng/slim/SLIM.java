package com.drovyng.slim;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class SLIM extends JavaPlugin {
    public static SLIM Instance;
    public static List<String> Texts;
    public static boolean DefaultArrow;
    public void loadConfigTexts(){
        reloadConfig();
        FileConfiguration config = getConfig();
        Texts = config.getStringList("texts");
        DefaultArrow = config.getBoolean("default-arrow", true);
        if (Texts.isEmpty() || config.get("default-arrow", null) == null){
            Texts = List.of("Admin is lazy", "SLIM is the best!");
            config.set("texts", Texts);
            config.set("default-arrow", DefaultArrow);
            saveConfig();
        }
    }
    @Override
    public void onEnable() {
        Instance = this;

        saveDefaultConfig();

        loadConfigTexts();

        getCommand("reload-slim").setExecutor(new ReloadCommand());

        getServer().getPluginManager().registerEvents(new ServerPingEvent(), this);
        getLogger().info("Loaded SLIM Successfully!");
    }
}
