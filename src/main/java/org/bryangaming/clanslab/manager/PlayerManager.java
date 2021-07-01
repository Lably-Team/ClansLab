package org.bryangaming.clanslab.manager;

import org.bryangaming.clanslab.data.PlayerData;
import org.bryangaming.clanslab.services.MainService;

import java.util.HashMap;
import java.util.UUID;

public class PlayerManager {

    private final HashMap<UUID, PlayerData> playerDataHashMap = new HashMap<>();
    private MainService mainService;

    public PlayerManager(MainService mainService) {
        this.mainService = mainService;
    }

    public void createData(UUID uuid){
        playerDataHashMap.put(uuid, new PlayerData(uuid));
    }

    public PlayerData getData(UUID uuid){
        return playerDataHashMap.get(uuid);
    }


}
