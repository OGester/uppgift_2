package org.example;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String firstName;
    private String lastName;

    private List<User> allUsers;

    public User() {
        allUsers = new ArrayList<>();
    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public void addUserToArray(User user) {
        allUsers.add(user);
        //System.out.println("New user " + allUsers);
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }


    //Representerar användare. Skall minst innehålla
    // *firstName - String & *lastName - String
}
