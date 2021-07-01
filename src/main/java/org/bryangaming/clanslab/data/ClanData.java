package org.bryangaming.clanslab.data;


import org.bryangaming.clanslab.data.clan.ClanType;
import org.bukkit.entity.Player;
import org.graalvm.compiler.nodes.calc.IntegerTestNode;

import java.util.*;

public class ClanData {

    private String clanName;

    private String clanNick;

    private final List<Player> playerList = new ArrayList<>();

    private final NavigableMap<Integer, String> roleList = new HashMap<>();

    private final Map<ClanType, List<String>> clanTypeMap = new HashMap<>();
    private final Map<Player, Integer> playerRankData = new HashMap<>();

    public ClanData(String clanName){
        this.clanName = clanName;
        this.clanNick = clanName;
    }

    public String getClanNick(){
        return clanNick;
    }

    public void setClanNick(String name){
        this.clanNick = name;
    }

    public List<Player> getPlayers(){
        return playerList;
    }

    public Map<Integer,String> getRoles(){
        return roleList;
    }

    public void createRole(String role){
        roleList.put(roleList.size() + 1, role);
        roleList.get
    }

    public void removeRole(int rankID){
        roleList.remove(rankID);
    }

    public Map<Player, Integer> getPlayerRanks(){
        return playerRankData;
    }

    public void setDefaultRank(Player player){
        playerRankData.put(player, 1);
    }

    public void promoteRank(Player player){
        playerRankData.replace(player, playerRankData.get(player) + 1);
        playerRankData.
    }

    public int getRankID(Player player){
        return playerRankData.get(player);
    }

    public void demoteRank(Player player){
        playerRankData.replace(player, playerRankData.get(player) + 1);
    }

    public void addClanType(String clanName, ClanType clanType){
        clanTypeMap.get(clanType).add(clanName);
    }

    public void removeClanType(ClanType clanType, String clanName){
        clanTypeMap.get(clanType).remove(clanName);
    }

    public Map<ClanType, List<String>> getClansType(){
        return clanTypeMap;
    }

    public List<String> getClanTypeList(ClanType clanType){
        return clanTypeMap.get(clanType);
    }
}
