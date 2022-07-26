package de.bypixels.pixelsapi.util;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public abstract class FileManagement {

    private final File file;
    private final YamlConfiguration configuration;

    public FileManagement(String path, String filename) {

        this.file = new File("plugins/" + path + "/" + filename + ".yml");
        this.configuration = YamlConfiguration.loadConfiguration(file);

    }

    public void saveFile() {
        try {
            this.configuration.save(file);
        } catch (IOException e) {
            Bukkit.getServer().getConsoleSender().sendMessage("§7[§1PixelsAPI§7] §cError with File-Savings");
        }
    }

    public File getFile() {
        return file;
    }

    public void setValue(String path, Object value) {
        getConfiguration().set(path, value);
        this.saveFile();
    }

    public Object getValue(String path) {
        return getConfiguration().get(path);

    }

    public void removeValueFromFile(String path) {
        configuration.set(path, null);
        saveFile();
    }

    public YamlConfiguration getConfiguration() {
        return configuration;
    }

}
