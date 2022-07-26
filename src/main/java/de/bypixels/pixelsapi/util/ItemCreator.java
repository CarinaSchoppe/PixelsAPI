package de.bypixels.pixelsapi.util;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemCreator {

    private final ItemStack item;
    private final ItemMeta itemMeta;
    private final Map<Enchantment, Integer> enchantments = new HashMap<>();
    private final List<String> lores = new ArrayList<>();
    private final Material material;
    private String name = null;
    private Integer amount = 1;
    private short id;

    public ItemCreator(Material material) {
        this.material = material;
        this.item = new ItemStack(material, 1);
        this.itemMeta = item.getItemMeta();
    }

    public ItemCreator(Material material, int amount) {
        this.material = material;
        this.amount = amount;
        this.item = new ItemStack(material, amount);
        itemMeta = item.getItemMeta();

    }

    public ItemCreator(String material, int amount) {
        this.material = Material.valueOf(material);
        this.amount = amount;
        this.item = new ItemStack(Material.valueOf(material), amount);
        itemMeta = item.getItemMeta();

    }


    @SuppressWarnings("deprecation")
    public ItemCreator(Material material, int amount, short id) {
        this.material = material;
        this.amount = amount;
        this.item = new ItemStack(material, amount);
        itemMeta = item.getItemMeta();
        item.setDurability(id);
        this.id = id;
    }

    @SuppressWarnings("deprecation")
    public ItemCreator(String material, int amount, short id) {
        this.material = Material.valueOf(material);
        this.amount = amount;
        this.item = new ItemStack(Material.valueOf(material), amount);
        itemMeta = item.getItemMeta();
        item.setDurability(id);
        this.id = id;

    }

    public ItemMeta getItemMeta() {
        return itemMeta;
    }

    public short getId() {
        return id;
    }

    public Material getMaterial() {
        return material;
    }

    public ItemCreator addItemName(String name) {
        this.itemMeta.setDisplayName(name);
        this.name = name;
        return this;
    }

    public Integer getAmount() {
        return amount;
    }


    public ItemCreator addEnchantment(Enchantment enchantment, int strength) {

        enchantments.put(enchantment, strength);

        itemMeta.addEnchant(enchantment, strength, true);

        return this;
    }


    public ItemStack createItemStack() {
        this.item.setItemMeta(itemMeta);
        return item;
    }

    public ItemStack buildItemStack() {
        return createItemStack();
    }

    public void create() {
        this.getItem().setItemMeta(itemMeta);
    }

    public void build() {
        create();
    }

    public ItemStack getItem() {
        return this.item;
    }


    public String getName() {
        name = itemMeta.getDisplayName();
        return this.name;
    }

    public Map<Enchantment, Integer> getEnchantments() {
        return this.enchantments;
    }

    public List<String> getLores() {
        return this.lores;
    }
}
