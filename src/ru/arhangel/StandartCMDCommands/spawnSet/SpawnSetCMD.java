package ru.arhangel.StandartCMDCommands.spawnSet;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import ru.arhangel.StandartCMDCommands.Main;

public class SpawnSetCMD implements CommandExecutor {
    FileConfiguration config = Main.plugin.getConfig();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args){
        Player player = (Player) sender;

        if(cmd.getName().equals("setspawn")){
            config.set("spawnPoint.x",player.getLocation().getX());
            config.set("spawnPoint.y",player.getLocation().getY());
            config.set("spawnPoint.z",player.getLocation().getZ());
            config.set("spawnPoint.world",player.getLocation().getWorld().getName());
            Main.plugin.saveConfig();

            player.sendMessage(ChatColor.GREEN + "Спаун установлен");

            return true;
        }

        if(cmd.getName().equals("spawn")){

            Location loc = new Location(Bukkit.getWorld(config.getString("spawnPoint.world")),
                    config.getDouble("spawnPoint.x"),
                    config.getDouble("spawnPoint.y"),
                    config.getDouble("spawnPoint.z"));

            player.sendMessage(ChatColor.YELLOW + "Телепортация...");


            player.teleport(loc);

            return true;
        }

        player.sendMessage(ChatColor.RED + "Произошла непредвиденная ошибка");
        return true;
    }
}
