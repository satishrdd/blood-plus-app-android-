package com.example.satish.parsetry;

import java.lang.ref.SoftReference;
import java.util.List;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;

public class startsearch extends Activity {
    // Declare Variables
    private ParseQueryAdapter<ParseObject> mainAdapter;
    private CustomAdapter urgentTodosAdapter;
    private ListView listView;
    private Button toggleButton;






    public static String sharedValue=null;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        Intent intent = getIntent();






       final String b = intent.getExtras().getString("blood");
        final String city = intent.getExtras().getString("city");
        System.out.println("Received bood is " + b);
        System.out.println("Recieved city id " + city);



        //start.sharedValue = b;

        startsearch.sharedValue = city;



        // final String City = bundle.getString("city");


        //String c = "bloodgroup";


        // Initialize main ParseQueryAdapter


        mainAdapter = new ParseQueryAdapter<ParseObject>(this, b);


        // }//mainAdapter = new ParseQueryAdapter<ParseObject>(this, );
        mainAdapter.setTextKey("Name");


        // mainAdapter.setImageKey("image");

        // Initialize the subclass of ParseQueryAdapter
        urgentTodosAdapter = new CustomAdapter(this);


        // Initialize ListView and set initial view to mainAdapter
        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(mainAdapter);

        mainAdapter.loadObjects();

        // Initialize toggle button
        toggleButton = (Button) findViewById(R.id.toggleButton);
        toggleButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (listView.getAdapter() == mainAdapter) {

                    listView.setAdapter(urgentTodosAdapter);
                    urgentTodosAdapter.loadObjects();
                } else {
                    listView.setAdapter(mainAdapter);
                    mainAdapter.loadObjects();
                }
            }

        });





    }





}










