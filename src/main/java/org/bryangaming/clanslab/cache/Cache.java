package org.bryangaming.clanslab.cache;

import java.util.HashMap;
import java.util.List;

public interface Cache<K,V>{

    HashMap<K,V> get();

    void createClan(K clanName);

    void disbandClan(K clanName);

    void replaceClan(K clanName, String beforeClan);

    void eraseData();

    V getClanData(K clanName);

    /**
     * test
     */
    boolean clanExists(K clanName);

    List<V> getClanList();
}
