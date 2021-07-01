package org.bryangaming.clanslab.manager.clan;

import org.bryangaming.clanslab.cache.Cache;
import org.bryangaming.clanslab.cache.ClanCacheImpl;
import org.bryangaming.clanslab.data.ClanData;
import org.bryangaming.clanslab.services.MainService;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class ClanManager {

    private Cache<String, ClanData> clanCache = new ClanCacheImpl();

    public ClanManager(MainService mainService) {
        setup();
    }

    public void setup() {
        clanCache = new DataLoader(clanCache).getData();
    }

    public Cache<String, ClanData> getClanCache(){
        return clanCache;
    }


}
