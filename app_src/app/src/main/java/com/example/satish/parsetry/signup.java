package com.example.satish.parsetry;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseClassName;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;

/**
 * Activity which displays a login screen to the user.
 */
public class signup extends Activity {
    // UI references.
    private EditText usernameEditText;
    private EditText passwordEditText;
    private EditText passwordAgainEditText;
    private EditText Age;
    private Spinner bloodgp;
    private EditText landmark;
    private EditText mobile;
    private Spinner City;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.signup);

        // Set up the signup form.
        usernameEditText = (EditText) findViewById(R.id.username_edit_text);

        passwordEditText = (EditText) findViewById(R.id.password_edit_text);
        passwordAgainEditText = (EditText) findViewById(R.id.password_again_edit_text);
        Age = (EditText) findViewById(R.id.age);
        //bloodgp = (EditText) findViewById(R.id.bg);




        Spinner spinner = (Spinner) findViewById(R.id.spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);




        Spinner city = (Spinner) findViewById(R.id.city);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adaptera = ArrayAdapter.createFromResource(this,
                R.array.city_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adaptera.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        city.setAdapter(adaptera);




        landmark = (EditText) findViewById(R.id.lmark);
        mobile = (EditText) findViewById(R.id.mobnumber);
        passwordAgainEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == R.id.edittext_action_signup ||
                        actionId == EditorInfo.IME_ACTION_UNSPECIFIED) {
                    signup();
                    return true;
                }
                return false;
            }
        });
        bloodgp = (Spinner) findViewById(R.id.spinner);
        City = (Spinner) findViewById(R.id.city);
        // Set up the submit button click handler
        Button mActionButton = (Button) findViewById(R.id.action_button);
        mActionButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                signup();
            }
        });
    }

    private void signup() {
        String username = usernameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        String passwordAgain = passwordAgainEditText.getText().toString().trim();
        String bloodgroup = bloodgp.getSelectedItem().toString().trim();
        String Landmark = landmark.getText().toString().trim();
        String mob = mobile.getText().toString().trim();
        String city = City.getSelectedItem().toString().trim();
        String age = Age.getText().toString().trim();

        // Validate the sign up data
        boolean validationError = false;
        StringBuilder validationErrorMessage = new StringBuilder(getString(R.string.error_intro));
        if (username.length() == 0) {
            validationError = true;
            validationErrorMessage.append(getString(R.string.error_blank_username));
        }
        if (password.length() == 0) {
            if (validationError) {
                validationErrorMessage.append(getString(R.string.error_join));
            }
            validationError = true;
            validationErrorMessage.append(getString(R.string.error_blank_password));
        }
        if (!password.equals(passwordAgain)) {
            if (validationError) {
                validationErrorMessage.append(getString(R.string.error_join));
            }
            validationError = true;
            validationErrorMessage.append(getString(R.string.error_mismatched_passwords));
        }
        validationErrorMessage.append(getString(R.string.error_end));

        // If there is a validation error, display the error
        if (validationError) {
            Toast.makeText(signup.this, validationErrorMessage.toString(), Toast.LENGTH_LONG)
                    .show();
            return;
        }

        // Set up a progress dialog
        final ProgressDialog dialog = new ProgressDialog(signup.this);
        dialog.setMessage(getString(R.string.progress_signup));
        dialog.show();

        // Set up a new Parse user
        ParseUser user = new ParseUser();
        user.setUsername(username);
        user.setPassword(password);
       user.put("bloodgroup",bloodgroup);
        user.put("Mobile",mob);
        user.put("LandMark",Landmark);
        user.put("City",city);


       // byte[] data = "Working great".getBytes();
        //ParseFile file = new ParseFile("resume.txt",data);
       // file.saveInBackground();

         if(bloodgroup.equals("O-")) {
             ParseObject gameScore = new ParseObject("Ominus");

             gameScore.put("Name", username + "         "+"Mobile:"+mob+"        "+"Landmark:"+Landmark);
             gameScore.put("Bloodgroup", bloodgroup);
             gameScore.put("Mobile", mob);
             gameScore.put("LandMark", Landmark);
             gameScore.put("City", city);
             gameScore.put("Age",age);


             gameScore.put("Availability", "available");
             //String st = user.getObjectId();
             //gameScore.put("resumefile",file);
             gameScore.saveInBackground();
         }else if(bloodgroup.equals("O+")){
             ParseObject gameScore = new ParseObject("Oplus");

             //gameScore.put("Name", username);
             gameScore.put("Name", username + "         "+"Mobile:"+mob+"        "+"Landmark:"+Landmark);
             gameScore.put("Bloodgroup", bloodgroup);
             gameScore.put("Mobile", mob);
             gameScore.put("LandMark", Landmark);
             gameScore.put("City", city);
             gameScore.put("Age",age);


             gameScore.put("Availability", "available");
             //String st = user.getObjectId();
             //gameScore.put("resumefile",file);
             gameScore.saveInBackground();

         }else if(bloodgroup.equals("A-")){
             ParseObject gameScore = new ParseObject("Aminus");

             //gameScore.put("Name", username);
             gameScore.put("Name", username + "         "+"Mobile:"+mob+"        "+"Landmark:"+Landmark);
             gameScore.put("Bloodgroup", bloodgroup);
             gameScore.put("Mobile", mob);
             gameScore.put("LandMark", Landmark);
             gameScore.put("City", city);
             gameScore.put("Age",age);


             gameScore.put("Availability", "available");
             //String st = user.getObjectId();
             //gameScore.put("resumefile",file);
             gameScore.saveInBackground();

         }else if(bloodgroup.equals("A+")){
             ParseObject gameScore = new ParseObject("Aplus");
             gameScore.put("Name", username + "         "+"Mobile:"+mob+"        "+"Landmark:"+Landmark);

            // gameScore.put("Name", username);
             gameScore.put("Bloodgroup", bloodgroup);
             gameScore.put("Mobile", mob);
             gameScore.put("LandMark", Landmark);
             gameScore.put("City", city);
             gameScore.put("Age",age);


             gameScore.put("Availability", "available");
             //String st = user.getObjectId();
             //gameScore.put("resumefile",file);
             gameScore.saveInBackground();

         }else if(bloodgroup.equals("B-")){
             ParseObject gameScore = new ParseObject("Bminus");
             gameScore.put("Name", username + "         "+"Mobile:"+mob+"        "+"Landmark:"+Landmark);

           //  gameScore.put("Name", username);
             gameScore.put("Bloodgroup", bloodgroup);
             gameScore.put("Mobile", mob);
             gameScore.put("LandMark", Landmark);
             gameScore.put("City", city);
             gameScore.put("Age",age);

             gameScore.put("Availability", "available");
             //String st = user.getObjectId();
             //gameScore.put("resumefile",file);
             gameScore.saveInBackground();

         }else if(bloodgroup.equals("B+")){
             ParseObject gameScore = new ParseObject("Bplus");
             gameScore.put("Name", username + "         "+"Mobile:"+mob+"        "+"Landmark:"+Landmark);

             //gameScore.put("Name", username);
             gameScore.put("Bloodgroup", bloodgroup);
             gameScore.put("Mobile", mob);
             gameScore.put("LandMark", Landmark);
             gameScore.put("City", city);
             gameScore.put("Age",age);


             gameScore.put("Availability", "available");
             //String st = user.getObjectId();
             //gameScore.put("resumefile",file);
             gameScore.saveInBackground();

         }else if(bloodgroup.equals("AB+")){
             ParseObject gameScore = new ParseObject("ABplus");

            // gameScore.put("Name", username);
             gameScore.put("Name", username + "         "+"Mobile:"+mob+"        "+"Landmark:"+Landmark);
             gameScore.put("Bloodgroup", bloodgroup);
             gameScore.put("Mobile", mob);
             gameScore.put("LandMark", Landmark);
             gameScore.put("City", city);
             gameScore.put("Age",age);


             gameScore.put("Availability", "available");
             //String st = user.getObjectId();
             //gameScore.put("resumefile",file);
             gameScore.saveInBackground();

         }else if(bloodgroup.equals("AB-")){
             ParseObject gameScore = new ParseObject("ABminus");

             //gameScore.put("Name", username);
             gameScore.put("Name", username + "         "+"Mobile:"+mob+"        "+"Landmark:"+Landmark);
             gameScore.put("Bloodgroup", bloodgroup);
             gameScore.put("Mobile", mob);
             gameScore.put("LandMark", Landmark);
             gameScore.put("City", city);
             gameScore.put("Age",age);


             gameScore.put("Availability", "available");
             //String st = user.getObjectId();
             //gameScore.put("resumefile",file);
             gameScore.saveInBackground();

         }




        // Call the Parse signup method
        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                dialog.dismiss();
                if (e != null) {
                    // Show the error message
                    Toast.makeText(signup.this, e.getMessage(), Toast.LENGTH_LONG).show();
                } else {
                    // Start an intent for the dispatch activity
                    Intent intent = new Intent(signup.this, signuporlogin.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            }
        });
    }
}
