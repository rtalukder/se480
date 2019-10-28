package edu.depaul.se480;

/**
 * Class: SE480 - Movie Recommendation Unit Tests
 * Author: Raquib Talukder
 **/

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import org.junit.BeforeClass;
import org.junit.Test;

import org.mockito.Mockito;
import static org.junit.Assert.assertEquals;


import java.util.ArrayList;
import java.util.List;

public class MovieRecommendationUnitTest {

    static List<List> listExpected = new ArrayList<>();

    @BeforeClass
    public static void GenerateLists(){
        List<String> under13 = new ArrayList<>();
        List<String> older13younger17 = new ArrayList<>();
        List<String> older17 = new ArrayList<>();

        under13.add("Shrek, Coco, The Incredibles");
        older13younger17.add("The Avengers, The Dark Knight, Inception");
        older17.add("The Godfather, Deadpool, Saving Private Ryan");

        listExpected.add(under13);
        listExpected.add(older13younger17);
        listExpected.add(older17);
    }

    @Test
    public void successful_under13_test(){
        // Arrange
        int age = 10;
        String name = "under13";
        UserService under13 = new UserService(age, name);

        // Act
        HystrixCommand.Setter config = HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("TestClassCall"));
        List<String> listActual = new MovieRecommendation(config,under13).getRecommendedMovies();

        // Assert
        assertEquals(listExpected.get(0), listActual);
    }

    @Test
    public void successful_older13younger17_test(){
        // Arrange
        int age = 15;
        String name = "older13younger17";
        UserService older13younger17 = new UserService(age, name);

        // Act
        HystrixCommand.Setter config = HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("TestClassCall"));
        List<String> listActual = new MovieRecommendation(config, older13younger17).getRecommendedMovies();

        // Assert
        assertEquals(listExpected.get(1), listActual);
    }

    @Test
    public void successful_older17_test(){
        // Arrange
        int age = 19;
        String name = "older17";
        UserService older17 = new UserService(age, name);

        // Act
        HystrixCommand.Setter config = HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("TestClassCall"));
        List<String> listActual = new MovieRecommendation(config, older17).getRecommendedMovies();

        // Assert
        assertEquals(listExpected.get(2), listActual);
    }

    @Test
    public void mock_successful_tests() throws Exception {

        // mocking userservice
        IUserService userService = Mockito.mock(UserService.class);
        HystrixCommand.Setter config = HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("TestClassCall"));

        IMovieRecommendation movieRecommendation = new MovieRecommendation(config, userService);

        // return age is < 13
        Mockito.when(userService.execute()).thenReturn(10);
        // test case x < 13
        assertEquals(listExpected.get(0), movieRecommendation.getRecommendedMovies());

        // return age 15
        Mockito.when(userService.execute()).thenReturn(15);
        // test case 13 <= x < 17
        assertEquals(listExpected.get(1), movieRecommendation.getRecommendedMovies());

        // return age is 19
        Mockito.when(userService.execute()).thenReturn(19);
        // test case x >= 17
        assertEquals(listExpected.get(2), movieRecommendation.getRecommendedMovies());

        // throw exception and return age < 13 list
        Mockito.when(userService.execute()).thenThrow(new InterruptedException());
        // since service has thrown an exception, method will return age < 13 list
        assertEquals(listExpected.get(0), movieRecommendation.getRecommendedMovies());

        // configured timeout properties to 100m
        HystrixCommandProperties.Setter commandProperties = HystrixCommandProperties.Setter();
        commandProperties.withExecutionTimeoutInMilliseconds(100);
        config.andCommandPropertiesDefaults(commandProperties);

        // sleep for 5000ms
        Thread.sleep(5000);

        // since service has taken longer than 100ms to respond, method will return age < 13 list
        assertEquals(listExpected.get(0), movieRecommendation.getRecommendedMovies());
    }
}
