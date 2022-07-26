package de.bypixels.pixelsapi.util;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        Bukkit.getConsoleSender().sendMessage("§7[§1PixelsAPI§7] §aPlugin Enabled");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown log
        Bukkit.getConsoleSender().sendMessage("§7[§1PixelsAPI§7] §4Plugin Disabled");

    }
}
