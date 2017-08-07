package ru.arhangel.StandartCMDCommands.helloMassage;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import ru.arhangel.StandartCMDCommands.Main;

public class HelloMessageCMD extends HelloMessage implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args){

        if(args.length==2){
            if(args[0].equals("site")||args[0].equals("servername")||args[0].equals("project")){
                config.set("hellomessage."+args[0],args[1]);
                Main.plugin.saveConfig();
                sender.sendMessage(ChatColor.GREEN + "Конфиг успешно изменен");
                return true;
            }
        }

        sender.sendMessage(ChatColor.RED + "Ошибка");
        return true;
    }
}
