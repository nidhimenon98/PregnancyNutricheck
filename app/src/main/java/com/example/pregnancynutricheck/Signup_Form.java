package com.example.pregnancynutricheck;

import android.content.Intent;
import android.database.Cursor;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.regex.Pattern;

import static com.example.pregnancynutricheck.events.database;
import static com.example.pregnancynutricheck.events.dbhelper1;
import static com.example.pregnancynutricheck.keys.Col_PHONE;
import static com.example.pregnancynutricheck.keys.TBL_NAME;

public class Signup_Form extends AppCompatActivity {

    EditText edtName,edtphone,edtpass,edtstreet,edtcity,edtpin;
    Button btnReg;

    String name , city, pass, phone ,street,pin = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup__form);
        edtName=findViewById(R.id.txtName);
        edtphone=findViewById(R.id.txtPhone);
        edtpass=findViewById(R.id.txtPass);
        edtstreet=findViewById(R.id.txtstreet);
        edtcity=findViewById(R.id.txtcity);
        edtpin=findViewById(R.id.txtpin);
        btnReg=findViewById(R.id.btn_submit);
        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Records successfully inserted",Toast.LENGTH_SHORT).show();

                Intent i=new Intent(Signup_Form.this,login.class);
                events.close();
                finish();


            }
        });



    }
    /*

    private void register() {
        initialize();
        if (!validate()){
            Toast.makeText(getApplicationContext(), "Signup has failed", Toast.LENGTH_SHORT).show();
        }
        else{
            onSignupSuccess();
        }
    }

    private boolean validate() {
        boolean valid=true;
        events.getInstance(getApplicationContext());
        events.open();

        if(name.isEmpty()||name.length()>32){
            edtName.setError("Enter valid name");
            valid=false;
        }


        else if ( (checkUser(phone))){
            edtphone.setError("Email is already registered");
            valid=false;

        }
        else if((phone.isEmpty())){
            edtphone.setError("Not Valid Number");
            valid=false;
        }
        else if ((phone.length()!=10 )){
            edtphone.setError("Enter 10 digit Indian mobile number");
            valid=false;

        }
        else if(!Pattern.matches("^[7-9][0-9]{9}$+",phone)){
            edtphone.setError("Not an Indian Number");
            valid=false;

        }

        else if(pass.isEmpty()){
            edtpass.setError("Password should be of 8 characters ");
            valid=false;
        }


        else if(city.isEmpty()||city.length()>10){
            edtcity.setError("Enter a valid city ");
            valid=false;
        }
        events.close();

        return valid;


    }

    private void initialize() {

        pin = edtpin.getText().toString().trim();
        name = edtName.getText().toString().trim();
        phone = edtphone.getText().toString().trim();
        city = edtcity.getText().toString().trim();
        pass = edtpass.getText().toString().trim();
        street = edtstreet.getText().toString().trim();

    }

    private void onSignupSuccess() {


        events.getInstance(getApplicationContext());
        events.open();
        events.add(name,phone,pass,street,city,pin);
        Toast.makeText(getApplicationContext(),"Records successfully inserted",Toast.LENGTH_SHORT).show();

        Intent i=new Intent(Signup_Form.this,login.class);
        events.close();
        finish();

    }
    private boolean checkUser(String phone) {
        events.getInstance(getApplicationContext());
        events.open();
        String[] columns = {
                Col_PHONE
        };
        database = dbhelper1.getReadableDatabase();
        String selection = Col_PHONE + " = ?";
        String[] selectionArgs = {phone};
        Cursor cursor = database.query(TBL_NAME,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);
        int cursorCount = cursor.getCount();
        cursor.close();
        database.close();

        if (cursorCount > 0) {
            return true;
        }
        events.close();

        return false;
    }
*/
}