package edu.depaul.se480;

import java.util.ArrayList;
import java.util.List;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * Class: SE480 - Movie Recommendations
 * Author: Raquib Talukder
 **/

public class MovieRecommendation extends HystrixCommand<String> implements IMovieRecommendation {
    IUserService user;
    List<List> recommendedMovies;

    public MovieRecommendation(Setter config, IUserService user) throws IllegalArgumentException{
        super(HystrixCommandGroupKey.Factory.asKey("MovieGroup"));
        this.user = user;
        this.recommendedMovies = new ArrayList<>();
        GenerateLists();
    }

    private void GenerateLists(){
        List<String> under13 = new ArrayList<>();
        List<String> older13younger17 = new ArrayList<>();
        List<String> older17 = new ArrayList<>();

        under13.add("Shrek, Coco, The Incredibles");
        older13younger17.add("The Avengers, The Dark Knight, Inception");
        older17.add("The Godfather, Deadpool, Saving Private Ryan");

        recommendedMovies.add(under13);
        recommendedMovies.add(older13younger17);
        recommendedMovies.add(older17);
    }

    public List<String> getRecommendedMovies() {
        try {
            String userAge = run();
            int userAgeInt = Integer.parseInt(userAge);

            if (userAgeInt < 13) {
                return recommendedMovies.get(0);
            } else if ((userAgeInt >= 13) && (userAgeInt < 17)) {
                return recommendedMovies.get(1);
            } else if (userAgeInt >= 17) {
                return recommendedMovies.get(2);
            }
            return null;
        } catch (InterruptedException exception) {
            System.out.println(exception);
            System.out.println("Exception found, returning age <13 list.");
        }
        return recommendedMovies.get(0);
    }

    @Override
    protected String run() throws InterruptedException {
        int intString = user.execute();
        return String.valueOf(intString);
    }

    @Override
    protected String getFallback() {
        return "Hello Failure " + "!";
    }
}
