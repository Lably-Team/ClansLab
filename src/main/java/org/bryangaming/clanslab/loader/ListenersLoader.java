package org.bryangaming.clanslab.loader;

import org.bryangaming.clanslab.listeners.ChatListener;
import org.bryangaming.clanslab.services.MainService;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

public class ListenersLoader implements Loader{

    private final MainService mainService;

    public ListenersLoader(MainService mainService) {
        this.mainService = mainService;
    }

    @Override
    public void load() {
        PluginManager pluginManager = Bukkit.getServer().getPluginManager();
        pluginManager.registerEvents(new ChatListener(mainService), mainService.getPlugin());
    }
}
