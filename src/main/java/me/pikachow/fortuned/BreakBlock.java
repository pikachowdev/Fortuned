package me.pikachow.fortuned;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import java.util.Random;


public class BreakBlock implements Listener {
    @EventHandler
    public void onPlayerBreakBlock(BlockBreakEvent e) {
        Block blockBroken = e.getBlock();
        if (blockBroken.getType() == Material.IRON_ORE) {
            Player playerMining = e.getPlayer();
            if (playerMining.hasPermission("fortuned.mine.iron")) {
                ItemStack heldItem = playerMining.getInventory().getItemInMainHand();
                System.out.println(heldItem);
                if (heldItem.getType().equals(Material.IRON_PICKAXE)) {
                    if (heldItem.getItemMeta().hasEnchant(Enchantment.LOOT_BONUS_BLOCKS)) {
                        e.setDropItems(false);
                        blockBroken.setType(Material.AIR);
                        ItemStack iron = new ItemStack(Material.IRON_INGOT, (int) (Math.random() * 4) + 1);
                        blockBroken.getWorld().dropItemNaturally(blockBroken.getLocation(), iron);
                    }
                } else if (heldItem.getType().equals(Material.GOLDEN_PICKAXE)) {
                    if (heldItem.getItemMeta().hasEnchant(Enchantment.LOOT_BONUS_BLOCKS)) {
                        e.setDropItems(false);
                        blockBroken.setType(Material.AIR);
                        ItemStack iron = new ItemStack(Material.IRON_INGOT, (int) (Math.random() * 4) + 1);
                        blockBroken.getWorld().dropItemNaturally(blockBroken.getLocation(), iron);
                    }
                } else if (heldItem.getType().equals(Material.DIAMOND_PICKAXE)) {
                    if (heldItem.getItemMeta().hasEnchant(Enchantment.LOOT_BONUS_BLOCKS)) {
                        e.setDropItems(false);
                        blockBroken.setType(Material.AIR);
                        ItemStack iron = new ItemStack(Material.IRON_INGOT, (int) (Math.random() * 4) + 1);
                        blockBroken.getWorld().dropItemNaturally(blockBroken.getLocation(), iron);
                    }
                } else if (heldItem.getType().equals(Material.NETHERITE_PICKAXE)) {
                    if (heldItem.getItemMeta().hasEnchant(Enchantment.LOOT_BONUS_BLOCKS)) {
                        e.setDropItems(false);
                        blockBroken.setType(Material.AIR);
                        ItemStack iron = new ItemStack(Material.IRON_INGOT, (int) (Math.random() * 4) + 1);
                        blockBroken.getWorld().dropItemNaturally(blockBroken.getLocation(), iron);
                    }
                } else if (heldItem.getType().equals(Material.STONE_PICKAXE)) {
                    if (heldItem.getItemMeta().hasEnchant(Enchantment.LOOT_BONUS_BLOCKS)) {
                        e.setDropItems(false);
                        blockBroken.setType(Material.AIR);
                        ItemStack iron = new ItemStack(Material.IRON_INGOT, (int) (Math.random() * 4) + 1);
                        blockBroken.getWorld().dropItemNaturally(blockBroken.getLocation(), iron);
                    }
                } else {
                    blockBroken.setType(Material.AIR);
                    ItemStack rubble = new ItemStack(Material.COBBLESTONE, 1);
                    blockBroken.getWorld().dropItemNaturally(blockBroken.getLocation(), rubble);
                }
            } else {
                return;
            }
        } else if (blockBroken.getType() == Material.GOLD_ORE) {
            Player playerMining = e.getPlayer();
            if (playerMining.hasPermission("fortuned.mine.gold")) {
                ItemStack heldItem = playerMining.getInventory().getItemInMainHand();
                if (heldItem.getType().equals(Material.IRON_PICKAXE)) {
                    if (heldItem.getItemMeta().hasEnchant(Enchantment.LOOT_BONUS_BLOCKS)) {
                        e.setDropItems(false);
                        blockBroken.setType(Material.AIR);
                        ItemStack gold = new ItemStack(Material.GOLD_INGOT, (int) (Math.random() * 4) + 1);
                        blockBroken.getWorld().dropItemNaturally(blockBroken.getLocation(), gold);
                    }
                } else if (heldItem.getType().equals(Material.DIAMOND_PICKAXE)) {
                    if (heldItem.getItemMeta().hasEnchant(Enchantment.LOOT_BONUS_BLOCKS)) {
                        e.setDropItems(false);
                        blockBroken.setType(Material.AIR);
                        ItemStack gold = new ItemStack(Material.GOLD_INGOT, (int) (Math.random() * 4) + 1);
                        blockBroken.getWorld().dropItemNaturally(blockBroken.getLocation(), gold);
                    }
                } else if (heldItem.getType().equals(Material.NETHERITE_PICKAXE)) {
                    if (heldItem.getItemMeta().hasEnchant(Enchantment.LOOT_BONUS_BLOCKS)) {
                        e.setDropItems(false);
                        blockBroken.setType(Material.AIR);
                        ItemStack gold = new ItemStack(Material.GOLD_INGOT, (int) (Math.random() * 4) + 1);
                        blockBroken.getWorld().dropItemNaturally(blockBroken.getLocation(), gold);
                    }
                } else {
                    blockBroken.setType(Material.AIR);
                    ItemStack rubble = new ItemStack(Material.COBBLESTONE, 1);
                    blockBroken.getWorld().dropItemNaturally(blockBroken.getLocation(), rubble);
                }
            } else {
                return;
            }
        }
    }
}
