package ru.arhangel.StandartCMDCommands.setGameMode;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collection;

public class GameModeCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {

        if (sender.hasPermission("loginmanager.givegm")) {
            if (args.length == 2) {

                String arg1 = args[0];
                String arg2 = args[1];

                Collection<? extends Player> players = Bukkit.getOnlinePlayers();

                for (Player p : players) {

                    if (p.getName().equals(arg1)) {
                        switch (arg2) {
                            case "1":
                                p.setGameMode(GameMode.CREATIVE);
                                p.sendMessage(ChatColor.YELLOW + "Игрок " + ChatColor.BLUE + sender.getName() + ChatColor.YELLOW + "Изменил ваш игровой режим!");
                                sender.sendMessage(ChatColor.GREEN + "Вы изменили игровой режим игрока " + ChatColor.BLUE + p.getName());
                                break;

                            case "0":
                                p.setGameMode(GameMode.SURVIVAL);
                                p.sendMessage(ChatColor.YELLOW + "Игрок " + ChatColor.BLUE + sender.getName() + ChatColor.YELLOW + "Изменил ваш игровой режим!");
                                sender.sendMessage(ChatColor.GREEN + "Вы изменили игровой режим игрока " + ChatColor.BLUE + p.getName());
                                break;

                            default:
                                p.sendMessage(ChatColor.RED + "Режим не найден!");
                        }
                        return true;
                    } else sender.sendMessage(ChatColor.RED + "Игрок не найден!");
                    return true;
                }
            }
        }
        return false;
    }
}
