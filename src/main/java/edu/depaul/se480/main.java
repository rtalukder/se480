package edu.depaul.se480;

/**
 * Class: SE480 - main
 * Author: Raquib Talukder
 **/

public class main {
    public static void main(String[] args) {
        IUserService tom = new UserService(10, "Tom");
        IUserService molly = new UserService(13, "Molly");
        IUserService jake = new UserService(16, "Jake");
        IUserService julian = new UserService(17, "Julian");
        IUserService jim = new UserService(19, "Jim");


//        IMovieRecommendation age10 = new MovieRecommendation(tom);
//        IMovieRecommendation age13 = new MovieRecommendation(molly);
//        IMovieRecommendation age16 = new MovieRecommendation(jake);
//        IMovieRecommendation age17 = new MovieRecommendation(julian);
//        IMovieRecommendation age19 = new MovieRecommendation(jim);
//
//        System.out.println(age10.getRecommendedMovies());
//        System.out.println(age13.getRecommendedMovies());
//        System.out.println(age16.getRecommendedMovies());
//        System.out.println(age17.getRecommendedMovies());
//        System.out.println(age19.getRecommendedMovies());
    }
}
