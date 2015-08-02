package com.example.satish.parsetry;

/**
 * Created by satish on 1/26/2015.
 */
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Mahidhar on 1/25/2015.
 */
public class Snake extends ListActivity{
    String classes[] = {"THE POISONOUS SNAKES IN INDIA ARE:", "IndianCobra", "CommonKrait", "RusselViper", "SawScaleViper"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(Snake.this, android.R.layout.simple_list_item_1,classes));

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String cheese = classes[position];

        try {
            Class ourClass = Class.forName("com.example.satish.parsetry." + cheese);
            Intent ourIntent = new Intent(Snake.this, ourClass);
            startActivity(ourIntent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}


