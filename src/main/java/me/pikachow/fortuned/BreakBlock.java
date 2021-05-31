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
import org.bukkit.inventory.meta.ItemMeta;

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

public final class BreakBlock implements Listener {
    // TODO better name
    private static final Set<Material> VALID_TYPES_FOR_IRON = new HashSet<Material>()
    {{
        add(Material.IRON_PICKAXE);
        add(Material.GOLDEN_PICKAXE);
        add(Material.DIAMOND_PICKAXE);
        add(Material.NETHERITE_PICKAXE);
        add(Material.STONE_PICKAXE);
    }};

    // TODO better name
    private static final Set<Material> VALID_TYPES_FOR_GOLD = new HashSet<Material>()
    {{
        add(Material.IRON_PICKAXE);
        add(Material.DIAMOND_PICKAXE);
        add(Material.NETHERITE_PICKAXE);
    }};

    @EventHandler
    public void onPlayerBreakBlock(BlockBreakEvent event) {
        Block    blockBroken = event.getBlock();
        Material brokenType  = blockBroken.getType();
        if(!(brokenType == Material.IRON_ORE || brokenType == Material.GOLD_ORE))
            return;

        Player  player = event.getPlayer();
        boolean isMiningIron = blockBroken.getType() == Material.IRON_ORE;

        if(!player.hasPermission(isMiningIron ? "fortuned.mine.iron" : "fortuned.mine.gold"))
            return;

        ItemStack heldItem = player.getInventory().getItemInMainHand();
        if (!heldItem.getItemMeta().hasEnchant(Enchantment.LOOT_BONUS_BLOCKS))
            return;

        if((isMiningIron ? VALID_TYPES_FOR_IRON : VALID_TYPES_FOR_GOLD).contains(heldItem.getType()))
        {
            event.setDropItems(false);
            blockBroken.setType(Material.AIR);
            ItemStack iron = new ItemStack(isMiningIron ? Material.IRON_INGOT : Material.GOLD_INGOT, (int) (Math.random() * 4) + 1);
            blockBroken.getWorld().dropItemNaturally(blockBroken.getLocation(), iron);
        }
        else
        {
            blockBroken.setType(Material.AIR);
            ItemStack rubble = new ItemStack(Material.COBBLESTONE, 1);
            blockBroken.getWorld().dropItemNaturally(blockBroken.getLocation(), rubble);
        }
    }
}
