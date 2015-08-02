package com.example.satish.parsetry;

import android.app.Application;
import android.content.Intent;

import com.parse.Parse;
import com.parse.ParseAnalytics;

/**
 * Created by satish on 12/23/2014.
 */
public class sampleactivity extends Application {
    public void onCreate(){
        super.onCreate();
        Parse.enableLocalDatastore(this);

        Parse.initialize(this,"0VH3sVgTcSuYgpENYJjp8bXsLlDw5tYcGokS71xM","BUklqGcuSAtPXPPfkwQJ02LvMIwkiLyu3D2uAeDe");


    }

}
