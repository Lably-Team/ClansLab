package org.bryangaming.clanslab.utils;

import org.bryangaming.clanslab.services.MainService;
import org.bukkit.ChatColor;

public class TextUtils {

    private MainService mainService;
    private static ConfigManager configFile;

    public TextUtils(MainService mainService){
        this.mainService = mainService;
        configFile = mainService.getFiles().getConfig();
    }

    public static String replaceVariables(String string){

        string = string
                .replace("%p", configFile.getString("config.prefix"))
                .replace("%e", configFile.getString("config.error"));

        string = ChatColor.translateAlternateColorCodes('&', string);

        return string;
    }
}
