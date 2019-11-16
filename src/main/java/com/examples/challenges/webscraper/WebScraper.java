package com.examples.challenges.webscraper;

import org.jsoup.Jsoup;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class WebsiteScanner implements Callable<Boolean> {

    private static final ClassLoader classLoader;
    private final String[] input;
    private final String filename;
    private final String ansiColour;

    WebsiteScanner(String[] input, String filename, String ansiColour) {
        this.input = input;
        this.filename = filename;
        this.ansiColour = ansiColour;
    }

    static {
        final Logger logger = Logger.getLogger(WebsiteScanner.class.getName());
        classLoader = WebsiteScanner.class.getClassLoader();
        final InputStream stream = classLoader.getResourceAsStream("logging.properties");
        try {
            LogManager.getLogManager().readConfiguration(stream);
        } catch (IOException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    @Override
    public Boolean call() {
        System.out.println(ansiColour + "Scanning " + filename + " websites...");
        WebScraper scanWebsites = new WebScraper();

        return scanWebsites.scanWebsites(ansiColour, input[input.length - 1],
            WebsiteReferences
                .loadWebsiteReferences(
                    Objects.requireNonNull(
                        classLoader.getResource(filename)).getFile()));
    }
}

class WebScraper {

    private static final Logger logger;
    private static final ClassLoader classLoader;

    static {
        logger = Logger.getLogger(WebScraper.class.getName());
        classLoader = WebScraper.class.getClassLoader();
        final InputStream stream = classLoader.getResourceAsStream("logging.properties");
        try {
            LogManager.getLogManager().readConfiguration(stream);
        } catch (IOException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    boolean scanWebsites(String threadColour, String word, List<String> websiteReferences) {
        List<String> ignoredWords =
            WebsiteReferences
                .loadWebsiteReferences(
                    Objects.requireNonNull(
                        classLoader.getResource("websites_ignore.txt")).getFile());

        /*
        ignore common website words (and tags) that interfere with the search results
        (i.e. tv, radio, book, table)
        */
        for (String ignoredWord : ignoredWords) {
            if (word.equalsIgnoreCase(ignoredWord)) {
                return false;
            }
        }

        for (String website : websiteReferences) {
            logger.info(String.format("%sChecking: %s for word: %s", threadColour, website, word));
            String content;

            try {
                content = scrapeHtml(website);
                String regex = "\\b" + word + "\\b";
                Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(content);

                if (matcher.find()) {
                    logger.info(String.format("Start index: %d", matcher.start()));
                    logger.info(String.format(" End index: %d ", matcher.end()));
                    logger.info(String.format("==>> FOUND: %s", website));
                    logger.info(matcher.group());
                    return true;
                }
            } catch (Exception e) {
                logger.log(Level.WARNING, "Scraping next website...");
            }
        }
        return false;
    }

    private static String scrapeHtml(String webPage) {
        String content = null;

        try {
            content = Jsoup.connect(webPage)
                .timeout(2000)
                .get()
                .html();
            logger.log(Level.FINE, content);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage() + " | " + webPage);
        }
        return content;
    }
}
