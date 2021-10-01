package com.example;
import java.util.*;

public class Prize {
    private String year;
    private String category;
    private List<Laureate> laureates;

    /**
     * Complete constructor with each member variable in Prize class.
     * Initializes details about a completely filled-in prize from the dataset.
     * @param yr
     * @param cat
     * @param list
     */
    public Prize(String yr, String cat, List<Laureate> list) {
        year = yr;
        category = cat;
        laureates = list;
    }

    /**
     * Second constructor to use when only filtering category.
     *
     * @param cat category of the prize.
     * @param yr year the prize was awarded.
     */
    public Prize(String yr, String cat) {
        year = yr;
        category = cat;

    }

    /**
     * Third constructor to use when only filtering laureates and their details.
     *
     * @param list of laureates
     */
    public Prize(List<Laureate> list) {
        laureates = list;
    }


    public String getYear() {
        return year;
    }

    public String getCategory() {
        return category;
    }

    public List<Laureate> getLaureates() {
        return laureates;
    }

    /**
     * Displaying data about each Prize object with year and category and semicolon separated list of laureates.
     * @return a String representation of each Prize object with the prize category, year, and names of laureates.
     */
    public String toString() {
        String laureatesString = "";
        if (this.getLaureates() != null) {
            for (Laureate l: laureates) {
                laureatesString += "; " + l.getFirstName() + " " + l.getSurname();
            }
        }
        return year + " " + category + " prize" + " with laureates" + laureatesString;
    }
}
