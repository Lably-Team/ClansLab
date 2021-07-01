package org.bryangaming.clanslab.manager;

import org.bryangaming.clanslab.cache.Cache;
import org.bryangaming.clanslab.cache.ClanCacheImpl;
import org.bryangaming.clanslab.data.ClanData;
import org.bryangaming.clanslab.data.PlayerData;
import org.bryangaming.clanslab.data.clan.ChatType;
import org.bryangaming.clanslab.data.clan.ClanType;
import org.bryangaming.clanslab.services.MainService;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.graalvm.compiler.asm.aarch64.AArch64MacroAssembler;

import java.util.HashSet;
import java.util.Set;

public class RecipientManager {

    private MainService mainService;

    public RecipientManager(MainService mainService) {
        this.mainService = mainService;
    }

    public Set<Player> getRecipients(Player player){

        Set<Player> recipients = new HashSet<>();

        PlayerData playerData = mainService.getManagerService().getPlayerManager().getData(player.getUniqueId());

        Cache<String, ClanData> clanCache = mainService.getManagerService().getClanManager().getClanCache();
        ClanData clanData = clanCache.getClanData(mainService.getManagerService().getPlayerManager().getData(player.getUniqueId()).getClanName());

        if (playerData.getChatType() == ChatType.NORMAL){
            recipients.addAll(Bukkit.getServer().getOnlinePlayers());
            return recipients;
        }

        if (playerData.getChatType() == ChatType.CLAN){
            recipients.addAll(clanData.getPlayers());
            return recipients;
        }

        for (String clanDataPath : clanData.getClanTypeList(ClanType.valueOf(playerData.getChatType().name()))){

            ClanData clanTypedData = mainService.getManagerService().getClanManager().getClanCache().getClanData(clanDataPath);
            recipients.addAll(clanTypedData.getPlayers());

        }

        return recipients;
    }
}
