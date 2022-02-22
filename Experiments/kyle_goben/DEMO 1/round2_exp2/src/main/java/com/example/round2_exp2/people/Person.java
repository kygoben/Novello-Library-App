package com.example.round2_exp2.people;


/**
 * Provides the Definition/Structure for the people row
 *
 * @author Vivek Bengre
 */

public class Person {

    private String userID;

    private String lastName;

    private String faveColor;

    private String faveNumber;

    public Person(){
        
    }

    public Person(String userID, String lastName, String faveColor, String faveNumber){
        this.userID = userID;
        this.lastName = lastName;
        this.faveColor = faveColor;
        this.faveNumber = faveNumber;
    }

    public String getUserID() {
        return this.userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFaveColor() {
        return this.faveColor;
    }

    public void setFaveColor(String faveColor) {
        this.faveColor = faveColor;
    }

    public String getFaveNumber() {
        return this.faveNumber;
    }

    public void setFaveNumber(String faveNumber) {
        this.faveNumber = faveNumber;
    }

    @Override
    public String toString() {
        return userID + " "
               + lastName + " "
               + faveColor + " "
               + faveNumber;
    }
}
