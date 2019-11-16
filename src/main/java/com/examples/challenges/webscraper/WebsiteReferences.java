package com.examples.challenges.webscraper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

class WebsiteReferences {

    private WebsiteReferences() {
    }

    private static Logger logger;

    static {
        logger = Logger.getLogger(WebsiteReferences.class.getName());
        InputStream stream =
            WebsiteReferences.class.getClassLoader().
                getResourceAsStream("logging.properties");
        try {
            LogManager.getLogManager().readConfiguration(stream);
        } catch (IOException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    static List<String> loadWebsiteReferences(String filepath) {
        logger.info(String.format("Reading file: %s...", filepath));
        List<String> websiteReferences = FileReader.readWithScanner(filepath);

        for (Object website : websiteReferences) {
            logger.info(website.toString());
        }
        return websiteReferences;
    }
}
