package org.bryangaming.clanslab.services;

import org.bryangaming.clanslab.manager.PlayerManager;
import org.bryangaming.clanslab.manager.RecipientManager;
import org.bryangaming.clanslab.manager.SenderManager;
import org.bryangaming.clanslab.manager.clan.ClanManager;

public class ManagerService implements Service{

    private final MainService mainService;

    private PlayerManager playerManager;
    private SenderManager senderManager;
    private ClanManager clanManager;

    private RecipientManager recipientManager;

    public ManagerService(MainService mainService){
        this.mainService = mainService;
    }

    @Override
    public void setup() {
        playerManager = new PlayerManager(mainService);
        senderManager = new SenderManager(mainService);

        clanManager = new ClanManager(mainService);

        recipientManager = new RecipientManager(mainService);

    }

    public PlayerManager getPlayerManager() {
        return playerManager;
    }

    public SenderManager getSender(){
        return senderManager;
    }

    public ClanManager getClanManager() {
        return clanManager;
    }

    public RecipientManager getRecipientManager() {
        return recipientManager;
    }
}
