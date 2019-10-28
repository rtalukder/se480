package edu.depaul.se480;

/**
 * Class: SE480 - User Service Unit Tests
 * Author: Raquib Talukder
 **/

import static org.junit.Assert.*;
import org.junit.Test;

public class UserServiceUnitTest {

    @Test
    public void successful_user_userservice_object_created(){
        // Arrange
        int age = 10;
        String name = "testUser";

        // Act
        int ageExpected = 10;
        int ageActual = new UserService(age, name).getAge();

        // Assert
        assertEquals(ageExpected, ageActual);
    }

    @Test
    public void fails_negative_age_user_userservice(){
        // Arrange
        int negativeAge = -10;
        String name = "negativeAgeUser";

        // Act
        try{
            new UserService(negativeAge, name);
            fail("Should not be able to get here");

        } catch (IllegalArgumentException error){
            // Assert
            assertEquals("Error: Negative or zero age is not allowed", error.getMessage());
        }
    }
}
