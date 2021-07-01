package org.bryangaming.clanslab.loader;

import me.fixeddev.commandflow.CommandManager;
import me.fixeddev.commandflow.annotated.AnnotatedCommandTreeBuilder;
import me.fixeddev.commandflow.annotated.AnnotatedCommandTreeBuilderImpl;
import me.fixeddev.commandflow.annotated.part.PartInjector;
import me.fixeddev.commandflow.annotated.part.defaults.DefaultsModule;
import me.fixeddev.commandflow.bukkit.BukkitCommandManager;
import me.fixeddev.commandflow.bukkit.factory.BukkitModule;
import org.bryangaming.clanslab.commands.ClanCommand;
import org.bryangaming.clanslab.services.MainService;
import org.bukkit.command.CommandMap;

public class CommandsLoader implements Loader{

    private MainService mainService;

    private CommandManager commandManager;
    private AnnotatedCommandTreeBuilder builder;

    public CommandsLoader(MainService mainService) {
        this.mainService = mainService;
        load();
    }

    @Override
    public void load(){
        createCommandManager();
        commandManager.registerCommands(builder.fromClass(new ClanCommand(mainService)));
    }


    public void createCommandManager(){
        commandManager = new BukkitCommandManager("ClansLab");

        PartInjector injector = PartInjector.create();

        injector.install(new DefaultsModule());
        injector.install(new BukkitModule());

        builder = new AnnotatedCommandTreeBuilderImpl(injector);

    }
}
