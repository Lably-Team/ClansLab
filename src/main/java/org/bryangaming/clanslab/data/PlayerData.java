package org.bryangaming.clanslab.data;

import me.fixeddev.commandflow.annotated.part.defaults.factory.StringPartFactory;
import org.bryangaming.clanslab.data.clan.ChatType;

import java.util.UUID;

public class PlayerData {

    private UUID uuid;

    private ChatType chatType;
    private String clanName;

    private boolean isLeader = false;

    public PlayerData(UUID uuid){
        this.uuid = uuid;
    }

    public ChatType getChatType() {
        return chatType;
    }

    public void setChatType(ChatType chatType) {
        this.chatType = chatType;
    }

    public String getClanName() {
        return clanName;
    }

    public void setClanName(String clanName) {
        this.clanName = clanName;
    }

    public boolean isLeader() {
        return isLeader;
    }

    public void setLeader(boolean leader) {
        isLeader = leader;
    }
}
