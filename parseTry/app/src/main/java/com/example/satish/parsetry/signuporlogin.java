package com.example.satish.parsetry;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by satish on 12/23/2014.
 */
public class signuporlogin extends Activity{
    Button btn1,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginorsignup);
        btn1 = (Button) findViewById(R.id.signup);
        btn2 = (Button) findViewById(R.id.login);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openStartingPoint=new Intent("android.intent.action.SIGNUP");
                startActivity(openStartingPoint);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openStartingPoint=new Intent("android.intent.action.LOGIN");
                startActivity(openStartingPoint);
            }
        });


    }
}
