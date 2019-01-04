package com.example.android.quakereport;

class Quakes {


    private double mMagnidtude;
    private String mLocation;
    private String mEventDate;

    public Quakes (double magnidtude, String location, String eventDate){

        mMagnidtude = magnidtude;
        mLocation = location;
        mEventDate = eventDate;
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
    public String getmEventDate() {
        return mEventDate;
    }
}
