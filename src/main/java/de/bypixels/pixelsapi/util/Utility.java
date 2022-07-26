package de.bypixels.pixelsapi.util;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Utility {

    private final List<UUID> showenPlayers = new ArrayList<>();
    private final List<UUID> hiddenPlayers = new ArrayList<>();
    private final JavaPlugin plugin;

    public Utility(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public List<UUID> getShowenPlayers() {
        return showenPlayers;
    }

    public List<UUID> getHiddenPlayers() {
        return hiddenPlayers;
    }

    public void syncDataFiles(List<UUID> list_a, List<UUID> list_b) {
        for (UUID object_a : list_a) {
            if (!list_b.contains(object_a)) {
                list_b.add(object_a);
            }
        }

        for (UUID object_b : list_b) {
            if (!list_a.contains(object_b)) {
                list_a.add(object_b);
            }
        }

    }

    public void addShowenPlayer(Player player) {
        getShowenPlayers().add(player.getUniqueId());
    }

    public void removeShowenPlayer(Player player) {
        getShowenPlayers().remove(player.getUniqueId());
    }

    public void removeHiddenPlayer(Player player) {
        getHiddenPlayers().remove(player.getUniqueId());
    }

    public void addHiddenPlayer(Player player) {
        getHiddenPlayers().add(player.getUniqueId());
    }

    public void BroadcastGlobalMessage(String prefix, String message) {
        Bukkit.getServer().broadcastMessage(prefix + "§f" + message);
    }

    public void hideHiddenPlayersFromShowen() {
        for (UUID player : hiddenPlayers) {
            for (Player players : Bukkit.getOnlinePlayers()) {
                if (!players.getUniqueId().equals(player)) {
                    players.hidePlayer(plugin, Objects.requireNonNull(Bukkit.getPlayer(player)));
                }
            }
        }
    }
}
