package com.examples.challenges.webscraper;

public class Client {

    public static void main(String[] args) {
        Finder finder = new Finder();

        if (args.length == 0) {
            System.out.println("Please supply input word(s)");
            System.exit(0);
        }
        System.out.println(finder.returnInputOutputType(args));
    }
}
