package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resources/prize.json");
        Gson gson = new Gson();
        Prizes prizes = gson.fromJson(new FileReader(file), Prizes.class);

        /**
         * Filtering function calls on the whole dataset.
         */
        // Filtering by category (first filter function) and prints only peace prizes.
        System.out.println(prizes.filterByCategory("peace"));

        // Filtering by year (second filter function) and prints only prizes with a year of 2002.
        System.out.println(prizes.filterByYear("2002"));

        // Filtering based laureate's first and last name (third filter function) and prints which prize Martin Luther King Jr. received.
        System.out.println(prizes.filterByLaureate("Martin Luther", "King Jr."));

        // Filtering based on laureate's ID (fourth filter function) and prints the prize the laureate with id 524 received.
        System.out.println(prizes.filterByID("524"));


        /**
         * Analysis function calls on the whole dataset.
         */

        // Retrieving first and last name of laureate based on ID.
        System.out.println(prizes.getNameBasedOnID("81"));

        // Retrieving number of occurrences of the laureate based on their name.
        System.out.println(prizes.getFrequencyOfLaureate("Martin Luther", "King Jr."));

        // Getting a count of the number of laureates within the category of literature.
        System.out.println(prizes.getNumLaureatesWithCategory("literature"));

        // Getting a count of the number of laureates awarded in 2012.
        System.out.println(prizes.getNumLaureatesWithYear("2012"));

    }
}

