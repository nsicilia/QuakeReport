package com.example.android.quakereport;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class QuakeAdapter extends ArrayAdapter<Quakes> {
    public QuakeAdapter(Activity context, ArrayList<Quakes> quakes) {
        super(context,0, quakes);
    }

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


        // Find the TextView in the list_item.xml layout with the ID magnitude_textview
        TextView magnitudeTextView = listItemView.findViewById(R.id.magnitude_textview);
        // Get the version name from the current Quakes object and
        // set this text on the name TextView
        magnitudeTextView.setText(String.valueOf(currentQuake.getmMagnidtude()));


        TextView locationTextView = listItemView.findViewById(R.id.location_textview);
        locationTextView.setText(currentQuake.getmLocation());


        TextView eventDateTextView = listItemView.findViewById(R.id.event_date_textview);
        eventDateTextView.setText(currentQuake.getmEventDate());



        return listItemView;
    }
}
