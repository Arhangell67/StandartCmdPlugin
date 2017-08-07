package ru.arhangel.StandartCMDCommands;

import ru.arhangel.StandartCMDCommands.helloMassage.HelloMessage;
import ru.arhangel.StandartCMDCommands.helloMassage.HelloMessageCMD;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import ru.arhangel.StandartCMDCommands.homeSet.HomeSetCMD;
import ru.arhangel.StandartCMDCommands.kitStarter.KitStartCMD;
import ru.arhangel.StandartCMDCommands.setGameMode.GameModeCMD;
import ru.arhangel.StandartCMDCommands.spawnSet.SpawnSetCMD;

import java.util.logging.Logger;

public class Main extends JavaPlugin implements Listener {

    Logger log = getLogger();



    public static Main plugin;

    public FileConfiguration config = getConfig();

    public void onEnable(){


        log.info("Your plugin has been enabled!");

        Bukkit.getPluginManager().registerEvents(this, this);

        plugin = this;

        this.getCommand("starterkit").setExecutor(new KitStartCMD());
        this.getCommand("gm").setExecutor(new GameModeCMD());
        this.getCommand("home").setExecutor(new HomeSetCMD());
        this.getCommand("spawn").setExecutor(new SpawnSetCMD());
        this.getCommand("setspawn").setExecutor(new SpawnSetCMD());
        this.getCommand("setmessage").setExecutor(new HelloMessageCMD());

    }

    public void onDisable(){
        log.info("Your plugin has been disabled.");
    }

    @EventHandler(priority= EventPriority.MONITOR)
    public void onJoin(PlayerJoinEvent event){
        HelloMessage HM = new HelloMessage();
        HM.helloMessage(event);
    }
}
