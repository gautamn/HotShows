package com.lightx.hotshows.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.lightx.hotshows.constant.HotShowsConstant;
import com.lightx.hotshows.MovieArrayAdapter;
import com.lightx.hotshows.R;
import com.lightx.hotshows.response.MoviesResponse;
import com.lightx.hotshows.util.GsonUtil;
import com.lightx.hotshows.util.HTTPUtil;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list);
        listView.setOnItemClickListener(this);
        new MoviesDetailsFetcher().execute();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, MovieActivity.class);
        intent.putExtra("MOVIE", (MoviesResponse.Movie)parent.getItemAtPosition(position));
        startActivity(intent);
    }

    //AsyncTask to process network request
    class MoviesDetailsFetcher extends AsyncTask<String, Void, String> {
        //This method will run on UIThread and it will execute before doInBackground
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        //This method will run on background thread and after completion it will return result to onPostExecute
        @Override
        protected String doInBackground(String... params) {
            return HTTPUtil.fetchResponse(HotShowsConstant.HOT_SHOWS_URL);
        }

        //This method runs on UIThread and it will execute when doInBackground is completed
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            MoviesResponse moviesResponse = GsonUtil.fromJson(s, MoviesResponse.class);
            MovieArrayAdapter movieArrayAdapter = new MovieArrayAdapter(MainActivity.this, R.layout.movie_list, moviesResponse.getResults());
            listView.setAdapter(movieArrayAdapter);
        }
    }
}
