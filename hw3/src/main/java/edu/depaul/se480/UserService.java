package edu.depaul.se480;

/**
 * Class: SE480 - UserService
 * Author: Raquib Talukder
 **/

public class UserService implements IUserService {

    int age;
    String name;

    public UserService(int age, String name) throws IllegalArgumentException{
        if (age <= 0) throw new IllegalArgumentException("Error: Negative or zero age is not allowed");
        else this.age = age;

        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public int execute() throws InterruptedException {
        return getAge();
    }
}
