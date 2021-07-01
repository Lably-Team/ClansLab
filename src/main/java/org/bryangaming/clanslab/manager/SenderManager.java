package org.bryangaming.clanslab.manager;

import org.bryangaming.clanslab.services.MainService;
import org.bryangaming.clanslab.utils.TextUtils;
import org.bukkit.entity.Player;

import java.util.List;


public class SenderManager {

    private final MainService mainService;

    public SenderManager(MainService mainService){
        this.mainService = mainService;

    }


    public void sendMessage(Player player, String text){
        text = TextUtils.replaceVariables(text);
        player.sendMessage(text);
    }

    public void sendMessage(Player player, List<String> textList){
        textList.replaceAll(TextUtils::replaceVariables);
        textList.forEach(player::sendMessage);
    }

}
