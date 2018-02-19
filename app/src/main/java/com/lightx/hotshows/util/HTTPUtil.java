package com.lightx.hotshows.util;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Nitin Gautam on 07/02/2018.
 */

public class HTTPUtil {
    public static String fetchResponse(String apiUrl) {
        URL url = null;
        try {
            url = new URL(apiUrl);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = urlConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String s = bufferedReader.readLine();
            bufferedReader.close();
            return s;
        } catch (IOException e) {
            Log.e("Error: ", e.getMessage(), e);
        }
        return null;
    }

}
