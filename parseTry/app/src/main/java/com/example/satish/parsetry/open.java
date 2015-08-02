package com.example.satish.parsetry;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetDataCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

/**
 * Created by satish on 12/25/2014.
 */
public class open extends Activity {

    Button logout,startsearch,post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        logout = (Button) findViewById(R.id.blogout);
        startsearch = (Button) findViewById(R.id.bstartsearch);
        post = (Button) findViewById(R.id.bcpref);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser.logOut();
                Intent openStartingPoint = new Intent("android.intent.action.SIGNUPORLOGIN");

                startActivity(openStartingPoint);



            }
        });
        startsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent openStartingPoint = new Intent("android.intent.action.START");

                startActivity(openStartingPoint);



            }
        });

        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openStartingPoint = new Intent("android.intent.action.DISEASE");

                startActivity(openStartingPoint);

            }
        });




    }
}
