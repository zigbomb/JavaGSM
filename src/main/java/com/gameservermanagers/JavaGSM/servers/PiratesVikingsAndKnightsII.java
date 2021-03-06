package com.gameservermanagers.JavaGSM.servers;

import com.gameservermanagers.JavaGSM.util.SteamcmdUtil;

import java.io.File;

@SuppressWarnings("unused")
public class PiratesVikingsAndKnightsII {

    public static void install(File destination) {
        boolean installedSuccessfully = SteamcmdUtil.installApp("anonymous", destination, "17575");
        System.out.println(installedSuccessfully
                ? "Finished installing Pirates, Vikings, and Knights II server. Start it with the -s flag."
                : "Failed installing Pirates, Vikings, and Knights II server. See above for errors generated by SteamCMD.")
        ;
        System.out.println();
    }

}