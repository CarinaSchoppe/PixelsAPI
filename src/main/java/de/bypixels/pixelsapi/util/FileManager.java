package de.bypixels.pixelsapi.util;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class FileManager extends FileManagement {


    private List<UUID> uuidList = new ArrayList<>();

    public FileManager(String path, String filename) {
        super(path, filename);
    }

    public String getStringWithColor(String Path) {
        return ChatColor.translateAlternateColorCodes('&', (String) getValue(Path));
    }

    public void addDefaultValue(String path, Object value) {
        getConfiguration().addDefault(path, value);
        getConfiguration().options().copyDefaults(true);

        this.saveFile();
    }

    public String getString(String path) {
        return this.getConfiguration().getString(path);
    }

    public Integer getInt(String path) {
        return this.getConfiguration().getInt(path);
    }

    public List<?> getList(String path) {
        return this.getConfiguration().getList(path);
    }

    public void removePlayerFromFile(String path, Player player) {
        List<UUID> currentList = (List<UUID>) getList(path);
        currentList.add(player.getUniqueId());
        uuidList = currentList;
        uuidList.remove(player.getUniqueId());
        setValue(path, uuidList);
        saveFile();
    }

    public void savePlayerToFile(String path, Player player) {
        List<UUID> currentList = (List<UUID>) getList(path);
        currentList.add(player.getUniqueId());
        uuidList = currentList;
        setValue(path, uuidList);
        saveFile();

    }

    public boolean PlayerIsInList(String path, Player player) {
        uuidList = (List<UUID>) getList(path);
        return uuidList.contains(player.getUniqueId());
    }
}
