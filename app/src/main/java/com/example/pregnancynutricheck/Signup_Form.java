package com.example.pregnancynutricheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.app.DatePickerDialog;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import static com.example.pregnancynutricheck.events.dbhelper;
import static com.example.pregnancynutricheck.events.database;
import static com.example.pregnancynutricheck.keys.PHONE_NO;
import static com.example.pregnancynutricheck.keys.TABLE_NAME;

import static android.graphics.Color.TRANSPARENT;


public class Signup_Form extends AppCompatActivity {

        private EditText Name,Husband_Name,Region,Phone_no,pass,retype_pass;
        private Button register;
        //private static String URL_REGIST="http://192.168.1.101/android_register_login/register.php";


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_signup__form);
            Name=findViewById(R.id.txt1);
            Husband_Name=findViewById(R.id.txt2);
            Region=findViewById(R.id.txt3);
            Phone_no=findViewById(R.id.txt4);
            pass=findViewById(R.id.txt5);
            retype_pass=findViewById(R.id.txt6);
            register=findViewById(R.id.btn_submit);
            register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Register();
                }
            });
    }
    private void Register(){
            register.setVisibility(View.GONE);
            final String name=this.Name.getText().toString().trim();
            final String husband_name=this.Husband_Name.getText().toString().trim();
            final String region=this.Region.getText().toString().trim();
            final String phone_no=this.Phone_no.getText().toString().trim();
            final String password=this.pass.getText().toString().trim();
            final String retype_password=this.retype_pass.getText().toString().trim();

        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL_REGIST, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try{
                    JSONObject jsonObject=new JSONObject(response);
                    String success=jsonObject.getString("success");
                    if(success.equals("1")){
                        Toast.makeText(Signup_Form.this,"Register successful",Toast.LENGTH_SHORT).show();
                    }
                }catch (JSONException e){
                    e.printStackTrace();
                    Toast.makeText(Signup_Form.this,"Register failed"+ e.toString(),Toast.LENGTH_SHORT).show();
                    register.setVisibility(View.VISIBLE);

                }

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Signup_Form.this,"Register failed"+ error.toString(),Toast.LENGTH_SHORT).show();
                        register.setVisibility(View.VISIBLE);

                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<>();
                params.put("name",name);
                params.put("husband_name",husband_name);
                params.put("region",region);
                params.put("phone_no",phone_no);
                params.put("password",password);


                return params;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);


    }

}