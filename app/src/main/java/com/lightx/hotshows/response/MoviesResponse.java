package com.lightx.hotshows.response;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Nitin Gautam on 07/02/2018.
 */

@Getter
@Setter
@ToString
public class MoviesResponse {

    private int total_results;
    private int total_pages;
    private List<Movie> results;

    @Getter
    @Setter
    @ToString
    public static class Movie implements Serializable {

        private String backdrop_path;
        private boolean adult;
        private String overview;
        private String release_date;
        private float vote_average;
        private String title;
        private String poster_path;
        private String original_language;
    }
}
