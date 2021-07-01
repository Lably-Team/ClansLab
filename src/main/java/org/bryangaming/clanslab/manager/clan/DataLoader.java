package org.bryangaming.clanslab.manager.clan;

import org.bryangaming.clanslab.cache.Cache;
import org.bryangaming.clanslab.data.ClanData;

public class DataLoader {

    private Cache<String, ClanData> clanData;

    public DataLoader(Cache<String, ClanData> clanData){
        this.clanData = clanData;
        recoverData();
    }

    public void recoverData(){

    }

    public Cache<String, ClanData> getData(){
        return clanData;
    }
}
