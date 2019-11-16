package com.examples.challenges.webscraper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

class FileReader {

    private static Logger logger;

    private FileReader() {
    }

    static {
        logger = Logger.getLogger(FileReader.class.getName());
        InputStream stream =
            FileReader.class.getClassLoader().
                getResourceAsStream("logging.properties");
        try {
            LogManager.getLogManager().readConfiguration(stream);
        } catch (IOException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    static List<String> readWithScanner(String filePath) {
        List<String> websites = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                websites.add(scanner.nextLine());
            }
            return websites;
        } catch (IOException e) {
            logger.log(Level.SEVERE, "File: " + filePath + " not found.");
            return Collections.emptyList();
        }
    }
}
