package com.gameservermanagers.JavaGSM.util;

import org.apache.commons.lang.StringUtils;

import java.util.List;

@SuppressWarnings("unused")
public class UserInput {

    public static boolean questionYesNo(String message) {
        String response = "";
        while (!response.toLowerCase().startsWith("y") && !response.toLowerCase().startsWith("n")) {
            System.out.print(message + "? (y/n) ");
            response = System.console().readLine();
        }

        return response.toLowerCase().startsWith("y");
    }

    public static int questionInt(String message) {
        while (true) {
            System.out.print(message + "? (num) ");
            String response = System.console().readLine();

            try {
                return Integer.parseInt(response);
            } catch (Exception ignored) {}
        }
    }

    public static String questionString(String message, boolean nothingIsOkay) {
        while (true) {
            System.out.print(message + "? (string) ");
            String response = System.console().readLine();

            if (nothingIsOkay) {
                return response;
            } else {
                if (!response.replace(" ", "").isEmpty()) return response;
            }
        }
    }

    public static int questionList(String message, List<String> options) {
        String response = "";
        while ("".equals(response) || !StringUtils.isNumeric(response) || Integer.parseInt(response) < 1 || Integer.parseInt(response) > options.size()) {
            System.out.println(message + "?");
            for (String option : options) {
                System.out.println((options.indexOf(option) + 1) + ": " + option);
            }
            System.out.print("# selection: ");
            response = System.console().readLine();
        }

        return Integer.parseInt(response) - 1;
    }

}
