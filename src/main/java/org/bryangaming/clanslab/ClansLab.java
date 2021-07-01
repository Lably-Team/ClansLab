package org.bryangaming.clanslab;

import org.bryangaming.clanslab.services.MainService;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


public class ClansLab extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("ClansLab by BryanGaming");
        MainService mainService = new MainService(this);
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("Thanks for using my plugin <3");
    }
}
