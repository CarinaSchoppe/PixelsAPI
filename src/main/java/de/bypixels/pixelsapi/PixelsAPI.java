package de.bypixels.pixelsapi;

import de.bypixels.pixelsapi.util.Utility;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class PixelsAPI {


    private static JavaPlugin plugin;
    Utility Utility = new Utility(plugin);

    public PixelsAPI(JavaPlugin plugin) {
        PixelsAPI.plugin = plugin;
        start(Bukkit.getPluginManager());
    }

    public static JavaPlugin getPlugin() {
        return plugin;
    }

}
