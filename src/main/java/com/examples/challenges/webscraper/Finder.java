package com.examples.challenges.webscraper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import static com.examples.challenges.webscraper.ThreadColour.*;

public class Finder {

    private static final Logger logger;
    private static final ClassLoader classLoader;
    private static final InputStream stream;
    private static final String VEGETABLE = "vegetable";
    private static final String ANIMAL = "animal";
    private static final String MINERAL = "mineral";

    static {
        logger = Logger.getLogger(Finder.class.getName());
        classLoader = Finder.class.getClassLoader();
        stream = classLoader.getResourceAsStream("logging.properties");

        try {
            LogManager.getLogManager().readConfiguration(stream);
        } catch (IOException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    String returnInputOutputType(String[] input) {
        final StringBuilder bld = new StringBuilder();
        final String output;

        for (int i = 0; i <= input.length - 1; ++i) {
            bld.append(input[i]);
            if (i != input.length - 1)
                bld.append(" ");
        }
        final String word = bld.toString();

        if (input.length > 1) {
            if (isPersonsFirstName(input[0])) {
                output = ANIMAL;
            } else if (isInanimateWord(input)) {
                output = MINERAL;
            } else {
                output = scanAllWebsiteTypes(input);
            }
        } else {
            output = scanAllWebsiteTypes(input);
        }
        return "\nInput: " + word + ", output: " + output;
    }

    private boolean isPersonsFirstName(String input) {
        final WebScraper webScraper = new WebScraper();
        return webScraper.scanWebsites(ANSI_RED, input,
            WebsiteReferences
                .loadWebsiteReferences(
                    Objects.requireNonNull(
                        classLoader.getResource("websites_actors.txt")).getFile()));
    }

    /*
    scan words that denote an object is inanimate
    (i.e. toy, plastic, metal, silver, brass, etc)
    */
    private boolean isInanimateWord(String[] input) {
        final List<String> inanimateWords =
            WebsiteReferences
                .loadWebsiteReferences(
                    Objects.requireNonNull(
                        classLoader.getResource("words_inanimate.txt")).getFile());

        for (String s : input) {
            if (inanimateWords.contains(s)) {
                return true;
            }
        }
        return false;
    }

    private String scanAllWebsiteTypes(String[] input) {
        final ExecutorService service = Executors.newFixedThreadPool(3);
        final Future<Boolean> isAnimal = service.submit(new WebsiteScanner(input, "websites_animals.txt", ANSI_CYAN));
        final Future<Boolean> isVegetable = service.submit(new WebsiteScanner(input, "websites_vegetables.txt", ANSI_GREEN));
        final Future<Boolean> isMineral = service.submit(new WebsiteScanner(input, "websites_minerals.txt", ANSI_BLUE));

        try {
            if (Boolean.TRUE.equals(isVegetable.get())) {
                service.shutdownNow();
                return VEGETABLE;
            }
            if (Boolean.TRUE.equals(isMineral.get())) {
                service.shutdownNow();
                return MINERAL;
            }
            if (Boolean.TRUE.equals(isAnimal.get())) {
                service.shutdownNow();
                return ANIMAL;
            } else {
                service.shutdownNow();
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
        return MINERAL;
    }
}
