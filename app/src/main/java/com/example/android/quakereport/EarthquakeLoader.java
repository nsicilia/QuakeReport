package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.List;


/**
 * Loads a list of earthquakes by using an AsyncTask to perform the
 * network request to the given URL.
 */
public class EarthquakeLoader extends AsyncTaskLoader {

    /** Log tag */
    private static final String LOG_TAG = EarthquakeLoader.class.getName();

    /** Query URL */

    private String mUrl;

    /**
     * Constructs a new {@link EarthquakeLoader}.
     *
     * @param context of the activity
     * @param url to load data from
     */
    EarthquakeLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }


    @Override
    public List<Quakes> loadInBackground() {
        // Don't perform the request if there are no URLs, or the first URL is null.
        if (mUrl.length() < 1 || mUrl == null) {
            Log.i(LOG_TAG, "loadInBackground: There was no url string added.");
            return null;
        }
        // Perform the network request, parse the response, and extract a list of quakes.
        List<Quakes> earthquake = QueryUtils.fetchEarthquakeData(mUrl);
        return earthquake;
    }
}

