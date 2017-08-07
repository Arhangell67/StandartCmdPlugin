package ru.arhangel.StandartCMDCommands.helloMassage;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import ru.arhangel.StandartCMDCommands.Main;
import ru.arhangel.StandartCMDCommands.kitStarter.KitStart;

import java.util.Collection;

public class HelloMessage {

    protected FileConfiguration config = Main.plugin.getConfig();

    protected String site = config.getString("hellomessage.site");
    protected String serverName = config.getString("hellomessage.servername");
    protected String projectName = config.getString("hellomessage.project");

    public void helloMessage(PlayerJoinEvent event){
        Player player = event.getPlayer();

        if(!player.hasPlayedBefore()){

            KitStart.giveStarterKit(player.getName());
            player.sendMessage(ChatColor.GREEN + "Добро пожаловать на сервер " + serverName + "проекта " + projectName + ". Наш сайт: " + site);

            Collection<? extends Player> players= Bukkit.getOnlinePlayers();

            for(Player p:players){
                p.sendMessage(ChatColor.GREEN + "Игрок " + player.getName() + "первый раз зашел на сервер.");
                p.sendMessage( ChatColor.GREEN + "Пожелаем ему удачи!");
            }
        }
        else player.sendMessage(ChatColor.GREEN + "Добро пожаловать на сервер " + serverName + " проекта " + projectName + ". Наш сайт: " + site);
    }
}
