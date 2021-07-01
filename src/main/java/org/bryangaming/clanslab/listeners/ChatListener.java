package org.bryangaming.clanslab.listeners;

import org.bryangaming.clanslab.data.ClanData;
import org.bryangaming.clanslab.data.PlayerData;
import org.bryangaming.clanslab.data.clan.ChatType;
import org.bryangaming.clanslab.manager.SenderManager;
import org.bryangaming.clanslab.services.MainService;
import org.bryangaming.clanslab.utils.ConfigManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.Set;

public class ChatListener implements Listener{

    private final MainService mainService;

    private final SenderManager senderManager;
    private final ConfigManager configFile;

    public ChatListener(MainService mainService) {
        this.mainService = mainService;

        this.senderManager = mainService.getManagerService().getSender();
        this.configFile = mainService.getFiles().getConfig();
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event){

        if (mainService.getManagerService().getPlayerManager().getData(event.getPlayer().getUniqueId()).getChatType() == ChatType.NORMAL){
            return;
        }
        event.setCancelled(true);

        PlayerData playerData = mainService.getManagerService().getPlayerManager().getData(event.getPlayer().getUniqueId());
        ClanData clanData = mainService.getManagerService().getClanManager().getClanCache().getClanData(playerData.getClanName());

        Set<Player> playerRecipients = event.getRecipients();

        playerRecipients.clear();
        playerRecipients.addAll(mainService.getManagerService().getRecipientManager().getRecipients(event.getPlayer()));

        String message = configFile.getString("clan.chat-format." + playerData.getChatType().getClanFormat())
                .replace("%clan%", clanData.getClanNick())
                .replace("%player%", event.getPlayer().getName())
                .replace("%message%", event.getMessage());

        for (Player player : playerRecipients){
            senderManager.sendMessage(player, message);
        }
    }
}
