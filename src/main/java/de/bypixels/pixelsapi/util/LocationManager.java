package de.bypixels.pixelsapi.util;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class LocationManager extends FileManagement {

    public LocationManager(String path, String filename) {
        super(path, filename);
    }

    public void createLocation(Location location, String path) {

        getConfiguration().set(path + ".World", location.getWorld().getName());

        getConfiguration().set(path + ".X", location.getX());

        getConfiguration().set(path + ".Y", location.getY());

        getConfiguration().set(path + ".Z", location.getZ());

        getConfiguration().set(path + ".Yaw", location.getYaw());

        getConfiguration().set(path + ".Pitch", location.getPitch());
        saveFile();


    }


    public void createLocationWithPlayer(Player player, String path) {
        getConfiguration().set(path + ".World", player.getLocation().getWorld().getName());

        getConfiguration().set(path + ".X", player.getLocation().getX());

        getConfiguration().set(path + ".Y", player.getLocation().getY());

        getConfiguration().set(path + ".Z", player.getLocation().getZ());

        getConfiguration().set(path + ".Yaw", player.getLocation().getYaw());

        getConfiguration().set(path + ".Pitch", player.getLocation().getPitch());
        saveFile();
    }


}
