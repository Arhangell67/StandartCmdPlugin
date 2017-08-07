package ru.arhangel.StandartCMDCommands.kitStarter;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.Collection;

public class KitStart {
    public static void giveStarterKit (String playerName){
        Collection<? extends Player> players = Bukkit.getOnlinePlayers();
        for(Player player : players){
            if (player.getName().equals(playerName)) {
                PlayerInventory _inv = player.getInventory();

                _inv.addItem(new ItemStack(Material.STONE_SWORD, 1));
                _inv.addItem(new ItemStack(Material.APPLE, 5));
                _inv.addItem(new ItemStack(Material.WOOD, 32));
                _inv.addItem(new ItemStack(Material.SAPLING, 4));
                _inv.addItem(new ItemStack(Material.COAL, 5));
                _inv.addItem(new ItemStack(Material.FEATHER, 1));
                _inv.addItem(new ItemStack(Material.STICK, 1));
            }
        }
    }
}
