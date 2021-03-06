package com.gameservermanagers.JavaGSM.servers;

import com.gameservermanagers.JavaGSM.util.SteamcmdUtil;

import java.io.File;

@SuppressWarnings("unused")
public class HalfLife2Deathmatch {

    public static void install(File destination) {
        boolean installedSuccessfully = SteamcmdUtil.installApp("anonymous", destination, "232370");
        System.out.println(installedSuccessfully
                ? "Finished installing Half-Life 2: Deathmatch server. Start it with the -s flag."
                : "Failed installing Half-Life 2: Deathmatch server. See above for errors generated by SteamCMD.")
        ;
        System.out.println();
    }

}
