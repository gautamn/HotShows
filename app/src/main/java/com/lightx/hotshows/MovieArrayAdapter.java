package com.lightx.hotshows;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
//import com.bumptech.glide.Glide;
import com.bumptech.glide.Glide;
import com.lightx.hotshows.activity.MainActivity;
import com.lightx.hotshows.constant.HotShowsConstant;
import com.lightx.hotshows.response.MoviesResponse;

import java.util.List;

public class MovieArrayAdapter extends ArrayAdapter {

    private List<MoviesResponse.Movie> movies;
    private int resource;
    private Context context;

    public MovieArrayAdapter(Context context, int resource, List<MoviesResponse.Movie> movieDetails) {
        super(context, resource, movieDetails);
        this.context = context;
        this.movies = movieDetails;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MoviesResponse.Movie movie = movies.get(position);
        View view = LayoutInflater.from(context).inflate(resource, parent, false);
        TextView movieName = (TextView) view.findViewById(R.id.textView);
        ImageView image = (ImageView) view.findViewById(R.id.imageView);
        movieName.setText(movie.getTitle());
        Glide.with(context).load(HotShowsConstant.IMAGE_LOCATION_PATH + movie.getPoster_path()).into(image);
        return view;
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }
}
