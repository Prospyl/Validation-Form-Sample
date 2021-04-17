package com.example.validationform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Short way to initialize group of variables
        EditText name, number , emailAddress, webSite, userName, password, confirmPassword;
        Button press_button;
        AwesomeValidation awesomeValidation;

        //Assigning variables to an ID

        name = (EditText) findViewById(R.id.i_Name);
        number = (EditText) findViewById(R.id.i_Number);
        emailAddress = (EditText) findViewById(R.id.i_Email);
        webSite = (EditText) findViewById(R.id.i_Website);
        userName = (EditText) findViewById(R.id.i_UserName);
        password = (EditText) findViewById(R.id.i_Password);
        confirmPassword = (EditText) findViewById(R.id.i_Confirm_Password);
        press_button = (Button) findViewById(R.id.press_button);

        //Initializing Validation Style
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        //Add Validation for name
        awesomeValidation.addValidation(this,R.id.i_Name,
                RegexTemplate.NOT_EMPTY,R.string.invalid_name);

        //Add Validation for Mobile number
        awesomeValidation.addValidation(this, R.id.i_Number,
                RegexTemplate.TELEPHONE,R.string.invalid_mobile);

        //Add Validation for Email Address
        awesomeValidation.addValidation(this, R.id.i_Email,
                Patterns.EMAIL_ADDRESS,R.string.invalid_email);

        //Add Validation for Website
        awesomeValidation.addValidation(this, R.id.i_Website,
                Patterns.WEB_URL, R.string.invalid_website);

        //Add Validation for Username
        awesomeValidation.addValidation(this, R.id.i_UserName,
                RegexTemplate.NOT_EMPTY,R.string.invalid_username);

        //Add Validation for Password
        awesomeValidation.addValidation(this, R.id.i_Password,
                ".{6,}",R.string.invalid_password);


        //Add Validation for Confirm Password
        awesomeValidation.addValidation(this, R.id.i_Confirm_Password,
                R.id.i_Password,R.string.invalid_confirm_password);

        press_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(awesomeValidation.validate()){
                    Toast.makeText(getApplicationContext(),
                            "Logging Successful",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),
                            "Logging failed .....",Toast.LENGTH_SHORT).show();
                }
            }
        });






    }
}