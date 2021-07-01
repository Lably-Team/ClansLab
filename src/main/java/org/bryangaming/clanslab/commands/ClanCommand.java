package org.bryangaming.clanslab.commands;

import me.fixeddev.commandflow.annotated.CommandClass;
import me.fixeddev.commandflow.annotated.annotation.Command;
import me.fixeddev.commandflow.annotated.annotation.SubCommandClasses;
import me.fixeddev.commandflow.bukkit.annotation.Sender;
import org.bryangaming.clanslab.commands.args.MainSubCommand;
import org.bryangaming.clanslab.utils.ConfigManager;
import org.bryangaming.clanslab.manager.SenderManager;
import org.bryangaming.clanslab.services.MainService;
import org.bukkit.entity.Player;

@Command(names = {"clan", "clanslab"})
@SubCommandClasses({MainSubCommand.class, Cha})
public class ClanCommand implements CommandClass {

    private MainService mainService;

    private SenderManager senderManager;
    private ConfigManager messagesFile;

    public ClanCommand(MainService mainService){
        this.mainService = mainService;

        this.messagesFile = mainService.getFiles().getMessages();
        this.senderManager = mainService.getManagerService().getSender();
    }

    @Command(names = "")
    public boolean executeMainSubCommand(@Sender Player sender){
        senderManager.sendMessage(sender, messagesFile.getStringList("clan.help"));
        return true;
    }

}
