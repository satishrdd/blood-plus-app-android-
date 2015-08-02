package com.example.satish.parsetry;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import com.parse.ParseGeoPoint;
import com.parse.ParseObject;
import com.parse.ParseQueryAdapter;
import com.parse.ParseUser;

/**
 * Created by satish on 1/12/2015.
 */
public class start extends Activity implements AdapterView.OnItemSelectedListener {
    private Spinner blood,city;
    private Button bstart;
    private  String b;

    public static String  sharedValue= null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startsearch);





        Spinner spinnerblood = (Spinner) findViewById(R.id.spinnerblood);
// Create an ArrayAdapter using the string array and a default spinner layout

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.blood_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

// Apply the adapter to the spinner
        spinnerblood.setAdapter(adapter);
        spinnerblood.setOnItemSelectedListener(this);
       // spinnerb.setEnabled(true);


        Spinner spinnerc = (Spinner) findViewById(R.id.spinnerc);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adaptera = ArrayAdapter.createFromResource(this,
                R.array.city_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adaptera.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
       spinnerc.setOnItemSelectedListener(this);
        spinnerc.setAdapter(adaptera);




        blood = (Spinner) findViewById(R.id.spinnerblood);
        city = (Spinner) findViewById(R.id.spinnerc);
        bstart = (Button) findViewById(R.id.bstart);



















    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        final String Blood = blood.getSelectedItem().toString().trim();
       final  String City = city.getSelectedItem().toString().trim();





        System.out.println("Boold selected in spinner is "+Blood);




        if(Blood.equals("O-")) {
            b = "Ominus";
        }else if(Blood.equals("O+")){
            b ="Oplus";
        }else if(Blood.equals("A-")){
            b= "Aminus";
        }else if(Blood.equals("A+")){
            b = "Aplus";
        }else if(Blood.equals("B+")){
            b = "Bplus";
        }else if(Blood.equals("B-")){
            b = "Bminus";
        }else if(Blood.equals("AB+")){
            b = "ABplus";
        }else if(Blood.equals("AB-")){
            b = "ABminus";
        }
        start.sharedValue = b;
        bstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent antent = new Intent(start.this,startsearch.class);
                System.out.println("Blood is "+b);
                System.out.println("City ids"+City);
                antent.putExtra("blood",b);
                antent.putExtra("city",City);

                // intent.putExtra("city",Citya);
                startActivity(antent);



            }
        });
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
