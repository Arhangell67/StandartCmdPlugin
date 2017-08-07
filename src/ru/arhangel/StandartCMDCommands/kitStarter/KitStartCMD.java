package ru.arhangel.StandartCMDCommands.kitStarter;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collection;

public class KitStartCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
        str = args[0];
        if (sender.hasPermission("loginmanager.givekit")) {
            KitStart.giveStarterKit(str);
            Collection<? extends Player> players = Bukkit.getOnlinePlayers();
            for (Player player : players) {
                if (player.getName().equals(str)) {
                    player.sendMessage(ChatColor.DARK_AQUA + sender.getName() + ChatColor.YELLOW + " выдал Вам стартовый набор!");
                }
            }

            sender.sendMessage(ChatColor.GREEN + "Набор игроку " + ChatColor.DARK_AQUA + str + ChatColor.GREEN + "выдан успешно!");
        } else {
            sender.sendMessage(ChatColor.DARK_RED + "У Вас нет прав!");
        }
        return true;
    }
}
