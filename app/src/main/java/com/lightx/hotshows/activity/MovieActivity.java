package com.lightx.hotshows.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lightx.hotshows.R;
import com.lightx.hotshows.response.MoviesResponse;

//import com.bumptech.glide.Glide;

public class MovieActivity extends AppCompatActivity {

    private ImageView image;
    private TextView title, date, rating, overview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        image = (ImageView) findViewById(R.id.poster);
        title = (TextView) findViewById(R.id.title);
        date = (TextView)findViewById(R.id.date);
        rating = (TextView)findViewById(R.id.rating);
        overview = (TextView) findViewById(R.id.overview);
        MoviesResponse.Movie movie = (MoviesResponse.Movie) getIntent().getExtras().getSerializable("MOVIE");
        if(movie !=null){
            //Showing image from the movie db api into imageview using glide library
            Glide.with(this).load("https://image.tmdb.org/t/p/w500/"+ movie.getPoster_path()).into(image);
            title.setText(movie.getTitle());
            date.setText(movie.getRelease_date());
            rating.setText(Double.toString(movie.getVote_average()));
            overview.setText(movie.getOverview());
        }
    }
}
