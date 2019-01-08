package com.example.android.quakereport;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class QuakeAdapter extends ArrayAdapter<Quakes> {
    public QuakeAdapter(Activity context, ArrayList<Quakes> quakes) {
        super(context,0, quakes);
    }

    private static final String LOCATION_SEPARATOR = "of ";

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Quakes} object located at this position in the list
        Quakes currentQuake = getItem(position);

        // Create a new Date object from the time in milliseconds of the earthquake
        Date dateOjbect = new Date(currentQuake.getmEventDate());

        //Formats the the data to a single decimal point
        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        //Takes the input data, a double, from the quake class and formats it and
        //converts it to a string
        String decimalOutput = decimalFormat.format(currentQuake.getmMagnidtude());


        // Find the TextView in the list_item.xml layout with the ID magnitude_textview
        TextView magnitudeTextView = listItemView.findViewById(R.id.magnitude_textview);
        // Get the version name from the current Quakes object and
        // set this text on the name TextView
        magnitudeTextView.setText(String.valueOf(decimalOutput));


        String originalLocation = currentQuake.getmLocation();
        String locationOffset;
        String primaryLocation;
        if(currentQuake.getmLocation().contains(LOCATION_SEPARATOR)){
            String[] parts = originalLocation.split(LOCATION_SEPARATOR);
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        }else {
            locationOffset = getContext().getString(R.string.near_the);
            primaryLocation = originalLocation;
        }

        TextView locationTextView = listItemView.findViewById(R.id.location_km_textview);
        locationTextView.setText(locationOffset);

        TextView locationNameTextView = listItemView.findViewById(R.id.location_name_textview);
        locationNameTextView.setText(primaryLocation);



        TextView eventDateTextView = listItemView.findViewById(R.id.event_date_textview);
        // Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formatDate(dateOjbect);
        // Display the date of the current earthquake in that TextView
        eventDateTextView.setText(formattedDate);

        TextView eventTimeTextView = listItemView.findViewById(R.id.event_time_textview);
        // Format the time string (i.e. "Mar 3, 1984")
        String formattedTime = formatTime(dateOjbect);
        // Display the time of the current earthquake in that TextView
        eventTimeTextView.setText(formattedTime);


        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeTextView.getBackground();

        int magnitudeColor = getMagnitudeColor(currentQuake.getmMagnidtude());

        magnitudeCircle.setColor(magnitudeColor);



        return listItemView;
    }

    private int getMagnitudeColor(double value) {
        int magnitudeFloor = (int) Math.floor(value);
        int magnitudeColorResourceId;

        switch (magnitudeFloor){
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }

        return  ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }


    private String formatDate (Date dateObject){
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    private String formatTime (Date timeObject){
        SimpleDateFormat dateFormat = new SimpleDateFormat("h:mm a");
        return dateFormat.format(timeObject);
    }


}
