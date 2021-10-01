package com.example;

public class Laureate {

    private String id;
    private String firstname;
    private String surname;
    private String motivation;
    private String share;

    /**
     * Constructor representing the Laureate object with only the first and last name instance variables.
     * @param first first name to be initialized.
     * @param lastName last name to be initialized.
     */
    public Laureate(String first, String lastName) {
        firstname = first;
        surname = lastName;
    }

    /**
     * Constructor representing the Laureate object with the first and last name and motivation instance variables.
     * @param first first name to be initialized.
     * @param lastName last name to be initialized.
     * @param motive motivation to be initialized.
     */
    public Laureate(String first, String lastName, String motive) {
        firstname = first;
        surname = lastName;
        motivation = motive;
    }

    public Laureate(String idNumber) {
        id = idNumber;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public String getMotivation() {
        return motivation;
    }

    public String getShare() {
        return share;
    }


}
