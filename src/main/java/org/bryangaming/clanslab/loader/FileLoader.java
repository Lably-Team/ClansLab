package org.bryangaming.clanslab.loader;

import org.bryangaming.clanslab.utils.ConfigManager;
import org.bryangaming.clanslab.services.MainService;

public class FileLoader implements Loader{

    private MainService mainService;

    private ConfigManager config;
    private ConfigManager messages;

    public FileLoader(MainService mainService){
        this.mainService = mainService;
        load();
    }

    @Override
    public void load(){
        config = new ConfigManager(mainService.getPlugin(), "config.yml");
        messages = new ConfigManager(mainService.getPlugin(), "messages.yml");
    }

    public ConfigManager getConfig() {
        return config;
    }

    public ConfigManager getMessages() {
        return messages;
    }
}
