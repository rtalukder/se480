package edu.depaul.se480;

import java.util.List;

/**
 * Class: SE<xxx> - <descrption>
 * Author: Raquib Talukder
 **/

public interface IMovieRecommendation {
    List<String> getRecommendedMovies() throws Exception;
}
