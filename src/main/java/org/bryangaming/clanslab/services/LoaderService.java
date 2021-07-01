package org.bryangaming.clanslab.services;

import org.bryangaming.clanslab.loader.CommandsLoader;
import org.bryangaming.clanslab.manager.clan.DataLoader;
import org.bryangaming.clanslab.loader.ListenersLoader;

public class LoaderService implements Service{

    private MainService mainService;

    private CommandsLoader commandsLoader;
    private ListenersLoader listenersLoader;

    public LoaderService(MainService mainService){
        this.mainService = mainService;
        setup();
    }

    public void setup(){
        commandsLoader = new CommandsLoader(mainService);
        listenersLoader = new ListenersLoader(mainService);
    }

    public ListenersLoader getListenersLoader() {
        return listenersLoader;
    }

    public CommandsLoader getCommandsLoader() {
        return commandsLoader;
    }

}
