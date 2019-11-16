package com.examples.challenges.webscraper;

import org.jsoup.Jsoup;

public class WebScraper {

    public static String scrapeHtml(String webPage) {

        String content = null;

        try {
            content = Jsoup.connect(webPage).get().html();
            //System.out.println(content);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return content;
    }

    public static boolean isEdible(String html) {

        // _edible_, cultivation
        // cooking, taste, vitamin, microwaving, steaming
        // Food portal
        // carbohydrates, vitamins, protein
        // sprouting

        if (html.contains("Food portal")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isAnimal(String html) {

        // _animal_
        //

        if (html.contains(" animal ")) {
            return true;
        } else {
            return false;
        }
    }
}
