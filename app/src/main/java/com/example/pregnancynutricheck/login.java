package com.example.pregnancynutricheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.pregnancynutricheck.events.database;

public class login extends AppCompatActivity {
    TextView txt;
    Button login;
    EditText phone,edtpass;
    CheckBox box;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SharedPreferences sp;
        final SharedPreferences.Editor edit;

        sp=getSharedPreferences("App name",MODE_PRIVATE);
        edit=sp.edit();

        phone=findViewById(R.id.txtPhone);
        edtpass=findViewById(R.id.txtPass);

        txt=findViewById(R.id.reg);

        box=findViewById(R.id.checkbox1);

        login=findViewById(R.id.btn_login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneno=phone.getText().toString().trim();
                String pass=edtpass.getText().toString().trim();
                if (phoneno.equals("")||pass.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Fill All The Fields",Toast.LENGTH_SHORT).show();

                    if(phoneno.equals(""))
                    {
                        phone.setError("Enter phone number");
                    }
                    if(pass.equals(""))
                    {
                        edtpass.setError("Password is Empty");
                    }
                }
                else
                {
                    events.getInstance(getApplicationContext());
                    events.open();
                    Cursor cursor=database.rawQuery("SELECT * FROM " + keys.TABLE_NAME + " WHERE " + keys.PHONE_NO + "=? AND " + keys.PASS + "=?", new String[]{phoneno, pass});
                    if (cursor!=null)
                    {
                        cursor.moveToLast();
                        if (cursor.getCount()>0)
                        {
                            Toast.makeText(getApplicationContext(), "Successfully Logged", Toast.LENGTH_SHORT).show();
                            Intent i=new Intent(login.this,MainActivity.class);

                            if (box.isChecked())
                            {
                                edit.putString("phone",phoneno);
                                edit.putString("pass",pass);
                                edit.commit();
                            }
                            else
                            {
                                edit.remove("phone");
                                edit.remove("pass");
                                edit.commit();
                            }
                            startActivity(i);
                            finish();
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"Invalid Login",Toast.LENGTH_SHORT).show();
                            edit.remove("phone");
                            edit.remove("pass");
                            edit.commit();
                        }
                    }

                    events.close();
                }

            }

        });

        if (sp.contains("phone"));
        phone.setText(sp.getString("phone",""));

        if (sp.contains("pass"));
        edtpass.setText(sp.getString("pass",""));

        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a=new Intent(login.this,nav_main.class);
                startActivity(a);
            }
        });
    }


    /*
    @Override

    public void onBackPressed()
    {
        Intent i=new Intent(Intent.ACTION_MAIN);
        i.addCategory(Intent.CATEGORY_HOME);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
    }
*/

    }


