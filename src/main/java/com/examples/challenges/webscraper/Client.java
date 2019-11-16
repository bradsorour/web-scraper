package com.examples.challenges.webscraper;

import org.w3c.dom.ls.LSOutput;

import java.util.logging.Logger;

public class Client {

    private static final Logger LOGGER = Logger.getLogger(Client.class.getName());

    public static void main(String[] args) {

        //LOGGER.info("Analysing " + args[0] + "...");

        String content = WebScraper.scrapeHtml("https://en.wikipedia.org/wiki/" + args[0].toLowerCase());

        //LOGGER.info("isEdible: " + WebScraper.isEdible(content));
        System.out.println("isEdible: " + WebScraper.isEdible(content));


        //LOGGER.info("isAnimal: " + WebScraper.isAnimal(content));
        System.out.println("isAnimal: " + WebScraper.isAnimal(content));

    }

}
