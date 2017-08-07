package ru.arhangel.StandartCMDCommands.homeSet;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import ru.arhangel.StandartCMDCommands.Main;

/**
 * Created by aapan on 24.07.2017.
 */
public class HomeSetCMD implements CommandExecutor {

    FileConfiguration config = Main.plugin.getConfig();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args){ //cmd = "tphome", "homeset"

        Player p = (Player) sender;
        String name = sender.getName();

        if(args[0].equals("set")){
            config.set("locations." + name + ".x" ,p.getLocation().getX());
            config.set("locations." + name + ".y" ,p.getLocation().getY());
            config.set("locations." + name + ".z" ,p.getLocation().getZ());
            config.set("locations." + name + ".world" ,p.getLocation().getWorld().getName());
            Main.plugin.saveConfig();

            p.sendMessage("Точка дома успешно создана!");

            return true;
        }

        else if(args[0].equals("tp")){
            Location loc = new Location(Bukkit.getWorld(config.getString("locations."+name+".world")),
                    config.getDouble("locations."+name+".x"),
                    config.getDouble("locations."+name+".y"),
                    config.getDouble("locations."+name+".z"));

            p.teleport(loc);

            p.sendMessage("Вы успешно телепортировались в свой дом!");

            return true;
        }

        return true;
    }
}