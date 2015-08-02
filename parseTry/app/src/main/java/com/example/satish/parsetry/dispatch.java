
package com.example.satish.parsetry;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.parse.ParseUser;



/**
 * Created by satish on 12/23/2014.
 */
public class dispatch extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(ParseUser.getCurrentUser()!=null){
            Intent intent = new Intent( this,open.class);
           startActivity(intent);

        }else {
            Intent intent = new Intent( this,signuporlogin.class);
            startActivity(intent);
        }
    }
}
