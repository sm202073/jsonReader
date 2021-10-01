package com.example;
import java.util.*;

public class Prizes {
    private List<Prize> prizes;

    public List<Prize> getPrizes() {
        return prizes;
    }

    /**
     * Filters the list of Prize objects based on category of the award.
     * @param category passed in that the Prize objects are filtered by.
     * @return list of Prize objects with only the specific category.
     */
    public List<Prize> filterByCategory(String category) {
        if (category == null || category.equals("")) {
            throw new IllegalArgumentException();
        }
        List<Prize> filteredPrizes = new ArrayList<>(); // list to be returned
        for (Prize prize: prizes) {
            if (prize.getCategory().equals(category)) {
                filteredPrizes.add(prize);
            }
        }
        return filteredPrizes;
    }

    /**
     * Filters the list of Prize objects based on year of the award.
     * @param year to filter the prizes by.
     * @return list of Prize objects with only the specific year.
     */
    public List<Prize> filterByYear(String year) {
        if (year == null || year.equals("")) {
            throw new IllegalArgumentException();
        }

        int yearAsInt = Integer.parseInt(year); // holds the passed year as an integer to check if it's in range of years
        // in the nobel prize dataset

        if (yearAsInt < 1901 || yearAsInt > 2020) {
            throw new IllegalArgumentException();
        }

        List<Prize> filteredPrizes = new ArrayList<>(); // filtered list of prizes to be returned
        for (Prize prize: prizes) {
            if (prize.getYear().equals(year)) {
                filteredPrizes.add(prize);
            }
        }
        return filteredPrizes;
    }

    /**
     * Filters the list of Prize objects based on the first and surname of the laureate awarded.
     * @param firstname first name of the laureate to filter by.
     * @param surname last name of the laureate to filter by.
     * @return list of Prize objects that the passed laureate won.
     */
    public List<Prize> filterByLaureate(String firstname, String surname) {
        if (firstname == null || firstname.equals("")) {
            throw new IllegalArgumentException();
        }
        if (surname == null || surname.equals("")) {
            throw new IllegalArgumentException();
        }

        List<Prize> filteredPrizes = new ArrayList<>();
        for (Prize prize: prizes) {
            if (prize.getLaureates() != null) {
                for (Laureate l: prize.getLaureates()) {
                    if (l != null && l.getFirstName() != null && l.getSurname() != null) {
                        if (l.getFirstName().equals(firstname) && l.getSurname().equals(surname)) {
                            filteredPrizes.add(prize);
                    }
                  }
                }
            }
        }
        return filteredPrizes;
    }


    /**
     * Filters the list of Prize objects based on the ID of the laureate awarded.
     * @param id that corresponds to a unique laureate.
     * @return list of Prize objects that only the laureate with the passed ID won.
     */
    public List<Prize> filterByID(String id) {
        if (id == null || id.equals("")) {
            throw new IllegalArgumentException();
        }
        List<Prize> filteredPrizes = new ArrayList<>();
        for (Prize prize: prizes) {
            if (prize.getLaureates() != null) {
                for (Laureate laureate: prize.getLaureates()) {
                    if (laureate.getId().equals(id)) {
                        filteredPrizes.add(prize);
                    }
                }
            }
        }
        return filteredPrizes;
    }


    /**
     * Filters the list of Prize objects based on the motivation of the laureate awarded.
     * @param motivation that corresponds to a unique laureate (can be passed keywords or the whole motivation)
     * @return list of Prize objects that contain laureates that share the passed motivation, if more than one.
     */
    public List<Prize> filterByMotivation(String motivation) {
        if (motivation == null || motivation.equals("")) {
            throw new IllegalArgumentException();
        }
        List<Prize> filteredPrizes = new ArrayList<>();
        for (Prize prize: prizes) {
            if (prize.getLaureates() != null) {
                for (Laureate l: prize.getLaureates()) {
                    if (l.getMotivation().contains(motivation)) {
                        filteredPrizes.add(prize);
                    }
                }
            }
        }
        return filteredPrizes;
    }


    /**
     * First analysis method to get the amount of times a laureate is in the list of Prizes based on their full name.
     * @param firstName of the laureate being checked for frequency.
     * @param surname (last name) of the laureate being checked for frequency.
     * @return an integer value indicating the number of times a laureate is present.
     */
    public int getFrequencyOfLaureate(String firstName, String surname) {
        if (firstName == null || firstName.equals("")) {
            throw new IllegalArgumentException();
        }
        if (surname == null || surname.equals("")) {
            throw new IllegalArgumentException();
        }

        int count = 0;
        Map<Laureate, Integer> countMap = new HashMap<>();
        for (Prize prize: prizes) {
            if (prize.getLaureates() != null) {
                for (Laureate l: prize.getLaureates()) {
                    if (l.getFirstName().equals(firstName) && l.getSurname().equals(surname)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }


    /**
     * Second analysis method to get the name of the laureate based on their ID.
     * @param id corresponding with the laureate to be returned.
     * @return the full name of the laureate that corresponds to the ID.
     */
    public String getNameBasedOnID(String id) {
        if (id == null || id.equals("")) {
            throw new IllegalArgumentException();
        }
        String fullName = "";
        for (Prize prize: prizes) {
            if (prize != null) {
                if (prize.getLaureates() != null) { // checking if there's a valid list of laureates
                    for (Laureate l: prize.getLaureates()) {
                        if (l.getId().equals(id)) {
                            fullName = l.getFirstName() + " " + l.getSurname();
                        }
                    }
                }
            }
        }
        return fullName;
    }


    /**
     * Third analysis method to get the number of laureates in a category.
     * @param category of the prize that one or more laureates have won.
     * @return an integer representing the number of laureates that corresponds to a prize category.
     */
    public int getNumLaureatesWithCategory(String category) {
        if (category == null || category.equals("")) {
            throw new IllegalArgumentException();
        }
        int laureateCount = 0;
        for (Prize prize: prizes) {
            if (prize != null) {
                if (prize.getCategory().equals(category)) {
                    if (prize.getLaureates() != null) {
                        for (Laureate l: prize.getLaureates()) {
                            laureateCount++;
                        }
                    }
                }
            }

        }
        return laureateCount;
    }


    /**
     * Fourth analysis method to get the number of laureates based on the year the prize was awarded.
     * @param year of the prize that one or more laureates have won.
     * @return an integer representing the number of laureates that correspond a prize awarded in a specific year.
     */
    public int getNumLaureatesWithYear(String year) {
        if (year == null || year.equals("")) {
            throw new IllegalArgumentException();
        }
        int yearAsInt = Integer.parseInt(year); // holds the passed year as an integer to check if it's in range of years
        // in the nobel prize dataset

        if (yearAsInt < 1901 || yearAsInt > 2020) {
            throw new IllegalArgumentException();
        }

        int yearCount = 0;
        for (Prize prize: prizes) {
            if (prize.getYear().equals(year)) {
                for (Laureate l: prize.getLaureates()) {
                    yearCount++;
                }
            }
        }
        return yearCount;
    }

}


