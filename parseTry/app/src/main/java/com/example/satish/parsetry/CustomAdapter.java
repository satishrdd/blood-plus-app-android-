package com.example.satish.parsetry;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.parse.ParseFile;
import com.parse.ParseImageView;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;



/**
 * Created by satish on 1/12/2015.
 */


public class CustomAdapter extends ParseQueryAdapter<ParseObject>  {






    public CustomAdapter(final Context context) {





        // Use the QueryFactory to construct a PQA that will only show
        // Todos marked as high-pri


        super(context, new ParseQueryAdapter.QueryFactory<ParseObject>() {
            public ParseQuery create() {




                   // String b =startsearch.sharedValue;
                String  city = startsearch.sharedValue;
                   String b = start.sharedValue;
                System.out.println("REceived blood in cadapter is"+b);
                System.out.println("Received city in adapter is "+city);


                ParseQuery query = new ParseQuery(b);
              // query.whereEqualTo("Name", true);
                query.whereEqualTo("City",city);
                query.whereNotEqualTo("Availability", "unavailable");
                query.whereGreaterThan("Age",18);
                return query;
            }
        });
    }










    // Customize the layout by overriding getItemView
    @Override
    public View getItemView(ParseObject object, View v, ViewGroup parent) {
        if (v == null) {
            v = View.inflate(getContext(), R.layout.urgent_item, null);
        }

        super.getItemView(object, v, parent);

       /* // Add and download the image
        ParseImageView todoImage = (ParseImageView) v.findViewById(R.id.icon);
        ParseFile imageFile = object.getParseFile("image");
        if (imageFile != null) {
            todoImage.setParseFile(imageFile);
            todoImage.loadInBackground();
        }*/

        // Add the title view
        TextView titleTextView = (TextView) v.findViewById(R.id.text1);
        titleTextView.setText(object.getString("Name"));


        return v;
    }

}


