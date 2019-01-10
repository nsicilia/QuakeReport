package com.example.android.quakereport;

class Quakes {


    private double mMagnidtude;
    private String mLocation;
    private long mEventDate;
    private String mURL;


    public Quakes (double magnidtude, String location, long eventDate, String url){

        mMagnidtude = magnidtude;
        mLocation = location;
        mEventDate = eventDate;
        mURL = url;
    }




    /**
     * Get the value of the magnitude.
     * @return double magnitude value
     */
    public double getmMagnidtude() {
        return mMagnidtude;
    }


    /**
     * Get the city location of the event.
     * @return String location name
     */
    public String getmLocation() {
        return mLocation;
    }


    /**
     * Get the MMMM/DD/YYYY
     * @return String default word
     */
    public long getmEventDate() {
        return mEventDate;
    }

    /**
     * Get the web adress
     * @return String url
     */
    public String getmURL() {
        return mURL;
    }
}


