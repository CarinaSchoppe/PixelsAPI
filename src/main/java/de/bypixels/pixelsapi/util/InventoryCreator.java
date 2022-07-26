package de.bypixels.pixelsapi.util;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryCreator {

    private final Inventory inventory;
    private final int Size;
    private String InventoryName;


    public InventoryCreator(String inventoryName, int size) {
        this.inventory = Bukkit.createInventory(null, size, inventoryName);

        InventoryName = inventoryName;
        Size = size;

    }

    public InventoryCreator(Inventory inventory) {
        this.inventory = inventory;
        Size = inventory.getSize();
    }

    public String getInventoryName() {
        return InventoryName;
    }

    public int getSize() {
        return Size;
    }

    private Inventory getInventory() {
        return inventory;
    }

    public InventoryCreator addItemToInventory(ItemStack item, int slot) {
        inventory.setItem(slot, item);

        return this;
    }

    public void createInventory() {
    }

    public void buildInventory() {
        createInventory();
    }

    public void playerOpenInventory(Player player) {
        player.openInventory(inventory);
    }

    public Inventory fillInventory(Material material) {
        ItemStack item = new ItemCreator(material).addItemName("  ").createItemStack();
        for (int slot = 0; slot < inventory.getSize(); slot++) {
            if (inventory.getItem(slot) == null) {
                inventory.setItem(slot, item);

            }
        }
        return inventory;
    }

    public Inventory fillInventory(ItemStack item) {
        for (int slot = 0; slot < inventory.getSize(); slot++) {
            if (inventory.getItem(slot) == null) {
                inventory.setItem(slot, item);

            }
        }
        return inventory;
    }
}
