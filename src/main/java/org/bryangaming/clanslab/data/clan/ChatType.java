package org.bryangaming.clanslab.data.clan;

public enum ChatType {
    NORMAL("normal"), CLAN("clan"), ALLY("ally"), ENEMY("enemy");

    private final String clanFormat;

    ChatType(String clanFormat){
        this.clanFormat = clanFormat;
    }

    public String getClanFormat(){
        return clanFormat;
    }
}
