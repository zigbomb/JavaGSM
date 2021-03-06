package com.gameservermanagers.JavaGSM.util;

import com.gameservermanagers.JavaGSM.JavaGSM;
import org.jsoup.Jsoup;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;

public class UpdateManager {

    // TODO: make this shit work fam

    public static void checkForUpdates() {
        System.out.print("Checking for updates...");
        String latest = ""; try { latest = Jsoup.connect("https://raw.githubusercontent.com/GameServerManagers/JavaGSM/master/latest").get().html().split("  ")[1].split("\\n")[0].replace(" ", ""); } catch (IOException e) { System.out.println("An unknown error occurred while getting the latest version"); e.printStackTrace(); }
        System.out.print(" latest: " + latest);

        List<Integer> currentNumbers = new LinkedList<>();
        for (String s : JavaGSM.version.split("\\.")) currentNumbers.add(Integer.valueOf(s));
        List<Integer> latestNumbers = new LinkedList<>();
        for (String s : latest.split("\\.")) latestNumbers.add(Integer.valueOf(s));

        boolean updateAvailable = false;
        for (int i = 0; i < 3; i++) if (currentNumbers.get(i) < latestNumbers.get(i)) updateAvailable = true;

        if (!updateAvailable) {
            System.out.println(" | no update available");
            return;
        }

        System.out.println(" | update available");

        try {
            String latestUrl = "http://scarsz.tech:8080/job/JavaGSM/lastSuccessfulBuild/artifact/target/JavaGSM.jar";
            File destination = new File(JavaGSM.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());
            DownloadUtil.download("http://scarsz.tech:8080/job/UpdateManager/lastSuccessfulBuild/artifact/target/UpdateManager.jar");
            RuntimeUtil.runProcess("java -jar JavaGSM.jar \"" + latestUrl + "\" \"" + destination.getAbsolutePath() + "\"");
            System.exit(0);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            System.out.println("You're one lucky little shit cause this error is never suppose to happen");
        }
    }

}
