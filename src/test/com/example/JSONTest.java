package com.example;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import com.example.Prizes;
import com.example.Prize;
import com.example.Laureate;

import com.google.gson.Gson;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


//testing small parts of data filtering
public class JSONTest {
    Gson gson;
    List<Prize> expectedPrizeList;
    private Object NullPointerException;

    @Before
    public void setUp() {
        // This is run before every test.
        //generic outline for getting data
        gson = new Gson();
        expectedPrizeList = new ArrayList<>();
    }

    @Test (expected = IllegalArgumentException.class)
    public void testNullCategoryForFilterByCategory() {
        Prizes prizes = new Prizes();
        try {
            File file = new File("src/main/resources/prizes.json");
            prizes = gson.fromJson(new FileReader(file), Prizes.class);
        } catch (Exception e) {
            e.getStackTrace();
        }
        assertEquals(IllegalArgumentException.class, prizes.filterByCategory(null));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testEmptyCategoryForFilterByCategory() {
        Prizes prizes = new Prizes();
        try {
            File file = new File("src/main/resources/prizes.json");
            prizes = gson.fromJson(new FileReader(file), Prizes.class);
        } catch (Exception e) {
            e.getStackTrace();
        }
        assertEquals(IllegalArgumentException.class, prizes.filterByCategory(""));
    }


    @Test (expected = java.lang.NullPointerException.class)
    public void testInvalidCategoryFilterByCategory() {
        Prizes prizes = new Prizes();
        try {
            File file = new File("src/main/resources/prizes.json");
            prizes = gson.fromJson(new FileReader(file), Prizes.class);
        } catch (Exception e) {
            e.getStackTrace();
        }
        assertEquals(NullPointerException.class, prizes.filterByCategory("cooking"));
    }


    @Test (expected = IllegalArgumentException.class)
    public void testNullYearForFilterByYear() {
        Prizes prizes = new Prizes();
        try {
            File file = new File("src/main/resources/prizes.json");
            prizes = gson.fromJson(new FileReader(file), Prizes.class);
        } catch (Exception e) {
            e.getStackTrace();
        }
        assertEquals(IllegalArgumentException.class, prizes.filterByYear(null));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testEmptyYearForFilterByYear() {
        Prizes prizes = new Prizes();
        try {
            File file = new File("src/main/resources/prizes.json");
            prizes = gson.fromJson(new FileReader(file), Prizes.class);
        } catch (Exception e) {
            e.getStackTrace();
        }
        assertEquals(IllegalArgumentException.class, prizes.filterByYear(""));
    }


    @Test (expected = java.lang.IllegalArgumentException.class)
    public void testInvalidYearForFilterByYear() {
        Prizes prizes = new Prizes();
        try {
            File file = new File("src/main/resources/prizes.json");
            prizes = gson.fromJson(new FileReader(file), Prizes.class);
        } catch (Exception e) {
            e.getStackTrace();
        }
        assertEquals(IllegalArgumentException.class, prizes.filterByYear("2050"));
    }


    @Test (expected = NumberFormatException.class)
    public void testInvalidStringForFilterByYear() {
        Prizes prizes = new Prizes();
        try {
            File file = new File("src/main/resources/prizes.json");
            prizes = gson.fromJson(new FileReader(file), Prizes.class);
        } catch (Exception e) {
            e.getStackTrace();
        }
        assertEquals(NumberFormatException.class, prizes.filterByYear("not a numbered year"));
    }



    @Test (expected = IllegalArgumentException.class)
    public void testBothNullNamesForFilterByLaureate() {
        Prizes prizes = new Prizes();
        try {
            File file = new File("src/main/resources/prizes.json");
            prizes = gson.fromJson(new FileReader(file), Prizes.class);
        } catch (Exception e) {
            e.getStackTrace();
        }
        assertEquals(IllegalArgumentException.class, prizes.filterByLaureate(null, null));
    }


    @Test (expected = IllegalArgumentException.class)
    public void testBothEmptyNamesForFilterByLaureate() {
        Prizes prizes = new Prizes();
        try {
            File file = new File("src/main/resources/prizes.json");
            prizes = gson.fromJson(new FileReader(file), Prizes.class);
        } catch (Exception e) {
            e.getStackTrace();
        }
        assertEquals(IllegalArgumentException.class, prizes.filterByLaureate("", ""));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testEmptyFirstNameForFilterByLaureate() {
        Prizes prizes = new Prizes();
        try {
            File file = new File("src/main/resources/prizes.json");
            prizes = gson.fromJson(new FileReader(file), Prizes.class);
        } catch (Exception e) {
            e.getStackTrace();
        }
        assertEquals(IllegalArgumentException.class, prizes.filterByLaureate("", "Earhart"));
    }


    @Test (expected = IllegalArgumentException.class)
    public void testEmptySurnameForFilterByLaureate() {
        Prizes prizes = new Prizes();
        try {
            File file = new File("src/main/resources/prizes.json");
            prizes = gson.fromJson(new FileReader(file), Prizes.class);
        } catch (Exception e) {
            e.getStackTrace();
        }
        assertEquals(IllegalArgumentException.class, prizes.filterByLaureate("Angela", ""));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testNullFirstNameForFilterByLaureate() {
        Prizes prizes = new Prizes();
        try {
            File file = new File("src/main/resources/prizes.json");
            prizes = gson.fromJson(new FileReader(file), Prizes.class);
        } catch (Exception e) {
            e.getStackTrace();
        }
        assertEquals(IllegalArgumentException.class, prizes.filterByLaureate(null, "Rowling"));
    }


    @Test (expected = IllegalArgumentException.class)
    public void testNullSurnameForFilterByLaureate() {
        Prizes prizes = new Prizes();
        try {
            File file = new File("src/main/resources/prizes.json");
            prizes = gson.fromJson(new FileReader(file), Prizes.class);
        } catch (Exception e) {
            e.getStackTrace();
        }
        assertEquals(IllegalArgumentException.class, prizes.filterByLaureate("Patricia", null));
    }




    @Test (expected = NullPointerException.class)
    public void testLaureateNotInDatasetForFilterByLaureate() {
        Prizes prizes = new Prizes();
        try {
            File file = new File("src/main/resources/prizes.json");
            prizes = gson.fromJson(new FileReader(file), Prizes.class);
        } catch (Exception e) {
            e.getStackTrace();
        }
        assertEquals(NullPointerException.class, prizes.filterByLaureate("Pumpkin", "Pie"));
    }


    @Test (expected = IllegalArgumentException.class)
    public void testNullIDForFilterByID() {
        Prizes prizes = new Prizes();
        try {
            File file = new File("src/main/resources/prizes.json");
            prizes = gson.fromJson(new FileReader(file), Prizes.class);
        } catch (Exception e) {
            e.getStackTrace();
        }
        assertEquals(IllegalArgumentException.class, prizes.filterByID(null));
    }


    @Test (expected = IllegalArgumentException.class)
    public void testEmptyIDForFilterByID() {
        Prizes prizes = new Prizes();
        try {
            File file = new File("src/main/resources/prizes.json");
            prizes = gson.fromJson(new FileReader(file), Prizes.class);
        } catch (Exception e) {
            e.getStackTrace();
        }
        assertEquals(IllegalArgumentException.class, prizes.filterByID(""));
    }

    @Test (expected = NullPointerException.class)
    public void testInvalidIDForFilterByID() {
        Prizes prizes = new Prizes();
        try {
            File file = new File("src/main/resources/prizes.json");
            prizes = gson.fromJson(new FileReader(file), Prizes.class);
        } catch (Exception e) {
            e.getStackTrace();
        }
        assertEquals(NullPointerException.class, prizes.filterByID("0001"));
    }



    @Test (expected = IllegalArgumentException.class)
    public void testNullMotivationForFilterByMotivation() {
        Prizes prizes = new Prizes();
        try {
            File file = new File("src/main/resources/prizes.json");
            prizes = gson.fromJson(new FileReader(file), Prizes.class);
        } catch (Exception e) {
            e.getStackTrace();
        }
        assertEquals(IllegalArgumentException.class, prizes.filterByMotivation(null));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testEmptyMotivationForFilterByMotivation() {
        Prizes prizes = new Prizes();
        try {
            File file = new File("src/main/resources/prizes.json");
            prizes = gson.fromJson(new FileReader(file), Prizes.class);
        } catch (Exception e) {
            e.getStackTrace();
        }
        assertEquals(IllegalArgumentException.class, prizes.filterByMotivation(""));
    }


    @Test (expected = NullPointerException.class)
    public void testInvalidMotivationForFilterByMotivation() {
        Prizes prizes = new Prizes();
        try {
            File file = new File("src/main/resources/prizes.json");
            prizes = gson.fromJson(new FileReader(file), Prizes.class);
        } catch (Exception e) {
            e.getStackTrace();
        }
        assertEquals(NullPointerException.class, prizes.filterByMotivation("I wanted to gain power and fame"));
    }


    @Test (expected = IllegalArgumentException.class)
    public void testBothNullNamesForGetFrequencyOfLaureate() {
        Prizes prizes = new Prizes();
        try {
            File file = new File("src/main/resources/prizes.json");
            prizes = gson.fromJson(new FileReader(file), Prizes.class);
        } catch (Exception e) {
            e.getStackTrace();
        }
        assertEquals(IllegalArgumentException.class, prizes.getFrequencyOfLaureate(null, null));
    }


    @Test (expected = IllegalArgumentException.class)
    public void testBothEmptyNamesForGetFrequencyOfLaureate() {
        Prizes prizes = new Prizes();
        try {
            File file = new File("src/main/resources/prizes.json");
            prizes = gson.fromJson(new FileReader(file), Prizes.class);
        } catch (Exception e) {
            e.getStackTrace();
        }
        assertEquals(IllegalArgumentException.class, prizes.getFrequencyOfLaureate("", ""));
    }


    @Test (expected = IllegalArgumentException.class)
    public void testEmptyFirstNameForGetFrequencyOfLaureate() {
        Prizes prizes = new Prizes();
        try {
            File file = new File("src/main/resources/prizes.json");
            prizes = gson.fromJson(new FileReader(file), Prizes.class);
        } catch (Exception e) {
            e.getStackTrace();
        }
        assertEquals(IllegalArgumentException.class, prizes.getFrequencyOfLaureate("", "Potter"));
    }


    @Test (expected = IllegalArgumentException.class)
    public void testEmptySurnameForGetFrequencyOfLaureate() {
        Prizes prizes = new Prizes();
        try {
            File file = new File("src/main/resources/prizes.json");
            prizes = gson.fromJson(new FileReader(file), Prizes.class);
        } catch (Exception e) {
            e.getStackTrace();
        }
        assertEquals(IllegalArgumentException.class, prizes.filterByLaureate("Sana", ""));
    }


    @Test (expected = IllegalArgumentException.class)
    public void testNullFirstNameForGetFrequencyOfLaureate() {
        Prizes prizes = new Prizes();
        try {
            File file = new File("src/main/resources/prizes.json");
            prizes = gson.fromJson(new FileReader(file), Prizes.class);
        } catch (Exception e) {
            e.getStackTrace();
        }
        assertEquals(IllegalArgumentException.class, prizes.getFrequencyOfLaureate(null, "Mendes"));
    }


    @Test (expected = IllegalArgumentException.class)
    public void testNullSurnameForGetFrequencyOfLaureate() {
        Prizes prizes = new Prizes();
        try {
            File file = new File("src/main/resources/prizes.json");
            prizes = gson.fromJson(new FileReader(file), Prizes.class);
        } catch (Exception e) {
            e.getStackTrace();
        }
        assertEquals(IllegalArgumentException.class, prizes.getFrequencyOfLaureate("Belle", null));
    }



    @Test (expected = IllegalArgumentException.class)
    public void testNullIDForGetNameBasedOnID() {
        Prizes prizes = new Prizes();
        try {
            File file = new File("src/main/resources/prizes.json");
            prizes = gson.fromJson(new FileReader(file), Prizes.class);
        } catch (Exception e) {
            e.getStackTrace();
        }
        assertEquals(IllegalArgumentException.class, prizes.getNameBasedOnID(null));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testEmptyIDForGetNameBasedOnID() {
        Prizes prizes = new Prizes();
        try {
            File file = new File("src/main/resources/prizes.json");
            prizes = gson.fromJson(new FileReader(file), Prizes.class);
        } catch (Exception e) {
            e.getStackTrace();
        }
        assertEquals(IllegalArgumentException.class, prizes.getNameBasedOnID(""));
    }


    @Test (expected = NullPointerException.class)
    public void testInvalidIDForGetNameBasedOnID() {
        Prizes prizes = new Prizes();
        try {
            File file = new File("src/main/resources/prizes.json");
            prizes = gson.fromJson(new FileReader(file), Prizes.class);
        } catch (Exception e) {
            e.getStackTrace();
        }
        assertEquals(NullPointerException.class, prizes.getNameBasedOnID("8000"));
    }


    @Test (expected = IllegalArgumentException.class)
    public void testNullCategoryForGetNumLaureatesWithCategory() {
        Prizes prizes = new Prizes();
        try {
            File file = new File("src/main/resources/prizes.json");
            prizes = gson.fromJson(new FileReader(file), Prizes.class);
        } catch (Exception e) {
            e.getStackTrace();
        }
        assertEquals(IllegalArgumentException.class, prizes.getNumLaureatesWithCategory(null));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testEmptyCategoryForGetNumLaureatesWithCategory() {
        Prizes prizes = new Prizes();
        try {
            File file = new File("src/main/resources/prizes.json");
            prizes = gson.fromJson(new FileReader(file), Prizes.class);
        } catch (Exception e) {
            e.getStackTrace();
        }
        assertEquals(IllegalArgumentException.class, prizes.getNumLaureatesWithCategory(""));
    }


    @Test (expected = NullPointerException.class)
    public void testInvalidCategoryForGetNumLaureatesWithCategory() {
        Prizes prizes = new Prizes();
        try {
            File file = new File("src/main/resources/prizes.json");
            prizes = gson.fromJson(new FileReader(file), Prizes.class);
        } catch (Exception e) {
            e.getStackTrace();
        }
        assertEquals(NullPointerException.class, prizes.getNumLaureatesWithCategory("cleaning"));
    }


    @Test (expected = IllegalArgumentException.class)
    public void testNullYearForGetNumLaureatesWithYear() {
        Prizes prizes = new Prizes();
        try {
            File file = new File("src/main/resources/prizes.json");
            prizes = gson.fromJson(new FileReader(file), Prizes.class);
        } catch (Exception e) {
            e.getStackTrace();
        }
        assertEquals(IllegalArgumentException.class, prizes.getNumLaureatesWithYear(null));
    }


    @Test (expected = IllegalArgumentException.class)
    public void testEmptyYearForGetNumLaureatesWithYear() {
        Prizes prizes = new Prizes();
        try {
            File file = new File("src/main/resources/prizes.json");
            prizes = gson.fromJson(new FileReader(file), Prizes.class);
        } catch (Exception e) {
            e.getStackTrace();
        }
        assertEquals(IllegalArgumentException.class, prizes.getNumLaureatesWithYear(""));
    }


    @Test (expected = IllegalArgumentException.class)
    public void testInvalidYearForGetNumLaureatesWithYear() {
        Prizes prizes = new Prizes();
        try {
            File file = new File("src/main/resources/prizes.json");
            prizes = gson.fromJson(new FileReader(file), Prizes.class);
        } catch (Exception e) {
            e.getStackTrace();
        }
        assertEquals(IllegalArgumentException.class, prizes.getNumLaureatesWithYear("3000"));
    }


    @Test (expected = NumberFormatException.class)
    public void testInvalidStringForGetNumLaureatesWithYear() {
        Prizes prizes = new Prizes();
        try {
            File file = new File("src/main/resources/prizes.json");
            prizes = gson.fromJson(new FileReader(file), Prizes.class);
        } catch (Exception e) {
            e.getStackTrace();
        }
        assertEquals(NumberFormatException.class, prizes.getNumLaureatesWithYear("not a numbered year"));
    }



    @Test
    public void testFilterByCategoryWithValidInput() throws FileNotFoundException {
        Prizes prizes = new Prizes();
        try {
            File file = new File("src/main/resources/categorySubset.json");
            prizes = gson.fromJson(new FileReader(file), Prizes.class);
        } catch (Exception e) {
            e.getStackTrace();
        }

        String actualPrizeCategory = prizes.filterByCategory("literature").get(0).getCategory();
        String expectedPrizeCategory = "literature";

        assertTrue(expectedPrizeCategory.equals(actualPrizeCategory));
    }


    @Test
    public void testFilterByYearWithValidInput() throws FileNotFoundException {
        Prizes prizes = new Prizes();
        try {
            File file = new File("src/main/resources/yearSubset.json");
            prizes = gson.fromJson(new FileReader(file), Prizes.class);
        } catch (Exception e) {
            e.getStackTrace();
        }


        String expectedPrizeYear = "2005";
        String actualPrizeYear = prizes.filterByYear("2005").get(0).getYear();


        assertTrue(expectedPrizeYear.equals(actualPrizeYear));
    }


    @Test
    public void testFilterByLaureateWithValidInput() throws FileNotFoundException {
        Prizes prizes = new Prizes();
        try {
            File file = new File("src/main/resources/nameSubset.json");
            prizes = gson.fromJson(new FileReader(file), Prizes.class);
        } catch (Exception e) {
            e.getStackTrace();
        }


        String actualPrizeListFullName = prizes.filterByLaureate("Malala", "Yousafzai").get(0).getLaureates().get(1).getFirstName() + " " + prizes.filterByLaureate("Malala", "Yousafzai").get(0).getLaureates().get(1).getSurname();
        String expectedPrizeListFullName = makePrizeEntryWithLaureateNameToCompare();

        assertTrue(expectedPrizeListFullName.equals(actualPrizeListFullName));
    }

    /**
     * Helper method to make list of the laureate with the full name being tested.
     * @return expected full name of the laureate to compare with the actual full name retrieved from the JSON.
     */
    public String makePrizeEntryWithLaureateNameToCompare() {
        List<Laureate> listOfLaureatesToSort = new ArrayList<>();
        listOfLaureatesToSort.add(new Laureate("Malala", "Yousafzai")); //name you are expected to get
        Prize namePrize = new Prize(listOfLaureatesToSort);


        expectedPrizeList.add(namePrize); // adding hard coded objects
        return expectedPrizeList.get(0).getLaureates().get(0).getFirstName() + " " + expectedPrizeList.get(0).getLaureates().get(0).getSurname();
    }


    @Test
    public void testFilterByIDWithValidInput() throws FileNotFoundException {
        Prizes prizes = new Prizes();
        try {
            File file = new File("src/main/resources/IDSubset.json");
            prizes = gson.fromJson(new FileReader(file), Prizes.class);
        } catch (Exception e) {
            e.getStackTrace();
        }


        String expectedPrizeID = makePrizeEntryWithIDToCompare();

        String actualPrizeID = prizes.filterByID("944").get(0).getLaureates().get(0).getId();

        assertTrue(expectedPrizeID.equals(actualPrizeID));
    }

    /**
     * Helper method to make list of the laureate with ID being tested.
     * @return expected ID to compare with the actual ID retrieved from the JSON.
     */
    public String makePrizeEntryWithIDToCompare() {
        List<Laureate> listOfLaureatesToSort = new ArrayList<>();
        listOfLaureatesToSort.add(new Laureate("944")); //name you are expected to get
        Prize idPrize = new Prize(listOfLaureatesToSort);


        expectedPrizeList.add(idPrize); // adding hard coded objects

        return expectedPrizeList.get(0).getLaureates().get(0).getId();
    }

    @Test
    public void testFilterByMotivationWithValidInput() {
        Prizes prizes = new Prizes();
        try {
            File file = new File("src/main/resources/motivationSubset.json");
            prizes = gson.fromJson(new FileReader(file), Prizes.class);
        } catch (Exception e) {
            e.getStackTrace();
        }

        String expectedPrizeMotivation = makePrizeEntryWithMotivationToCompare(); // result of helper function with

        String actualPrizeMotivation = prizes.filterByMotivation("innate immunity").get(0).getLaureates().get(0).getMotivation();

        assertTrue(expectedPrizeMotivation.equals(actualPrizeMotivation));
    }


    /**
     * Helper method to make list of the laureate with motivation being filtered by.
     * @return expected motivation to compare with the actual motivation of the laureate retrieved from the JSON.
     */
    public String makePrizeEntryWithMotivationToCompare() {
        List<Laureate> listOfLaureatesToSort = new ArrayList<>();
        listOfLaureatesToSort.add(new Laureate("Jules A.", "Hoffmann", "\"for their discoveries concerning the activation of innate immunity\""));
        Prize motivationPrize = new Prize(listOfLaureatesToSort);


        expectedPrizeList.add(motivationPrize); // adding hard coded objects

        return expectedPrizeList.get(0).getLaureates().get(0).getMotivation();
    }


    @Test
    public void testGetFrequencyOfLaureateWithValidInput() throws FileNotFoundException {
        Prizes prizes = new Prizes();
        try {
            File file = new File("src/main/resources/nameSubset.json");
            prizes = gson.fromJson(new FileReader(file), Prizes.class);
        } catch (Exception e) {
            e.getStackTrace();
        }


        int expectedLaureateCount = 1; // Laureate Malala Yousafzai only appears in the subset once

        // holds actual count of the laureate frequency in the subset tested based on the Gson reader.
        int actualLaureateCount  = prizes.getFrequencyOfLaureate("Malala", "Yousafzai");

        assertEquals(expectedLaureateCount, actualLaureateCount);
    }


    @Test
    public void testGetNameBasedOnIDWithValidInput() throws FileNotFoundException {
        Prizes prizes = new Prizes();
        try {
            File file = new File("src/main/resources/nameAndIDSubset.json");
            prizes = gson.fromJson(new FileReader(file), Prizes.class);
        } catch (Exception e) {
            e.getStackTrace();
        }

        String expectedName = "Kailash Satyarthi"; // name that corresponds to the ID of 913 in the subset being tested.

        assertEquals(expectedName, prizes.getNameBasedOnID("913"));
    }


    @Test
    public void getNumLaureatesWithCategoryWithValidInput() throws FileNotFoundException {
        Prizes prizes = new Prizes();
        try {
            File file = new File("src/main/resources/categoryAndLaureatesSubset.json");
            prizes = gson.fromJson(new FileReader(file), Prizes.class);
        } catch (Exception e) {
            e.getStackTrace();
        }

        int economicsLaureatesExpectedCount = 2; // 2 laureates won economics prizes in the subset being tested.

        assertEquals(economicsLaureatesExpectedCount, prizes.getNumLaureatesWithCategory("economics"));
    }


    @Test
    public void getNumLaureatesWithYearWithValidInput() throws FileNotFoundException {
        Prizes prizes = new Prizes();
        try {
            File file = new File("src/main/resources/categoryAndLaureatesSubset.json");
            prizes = gson.fromJson(new FileReader(file), Prizes.class);
        } catch (Exception e) {
            e.getStackTrace();
        }

        int expectedLaureatesWithYearCount = 3; // 3 laureates were awarded in 2020 in the subset being tested.

        assertEquals(expectedLaureatesWithYearCount, prizes.getNumLaureatesWithYear("2020"));
    }

}