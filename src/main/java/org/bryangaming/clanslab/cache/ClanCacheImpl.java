package org.bryangaming.clanslab.cache;

import org.bryangaming.clanslab.data.ClanData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ClanCacheImpl implements Cache<String, ClanData> {

    private final HashMap<String, ClanData> clanData = new HashMap<>();

    @Override
    public HashMap<String, ClanData> get() {
        return clanData;
    }

    @Override
    public void createClan(String clanName) {
        clanData.put(clanName, new ClanData(clanName));
    }

    @Override
    public void disbandClan(String clanName) {
        clanData.remove(clanName);
    }

    @Override
    public void eraseData(){
        clanData.clear();
    }

    public boolean clanExists(String clanName){
        return clanData.get(clanName) != null;
    }

    @Override
    public void replaceClan(String clanName, String beforeClan){
        clanData.replace(clanName, clanData.get(beforeClan));
    }

    @Override
    public ClanData getClanData(String clanName) {
        return clanData.get(clanName);
    }
    @Override
    public List<ClanData> getClanList(){
        return new ArrayList<>(clanData.values());
    }

}
