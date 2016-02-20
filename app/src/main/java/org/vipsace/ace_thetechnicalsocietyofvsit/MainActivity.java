package org.vipsace.ace_thetechnicalsocietyofvsit;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DataBaseHelper object ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button reg = (Button) findViewById(R.id.reg);
        Button login = (Button) findViewById(R.id.login);
        final EditText username = (EditText) findViewById(R.id.username);
        final EditText password = (EditText) findViewById(R.id.password);

        object = new DataBaseHelper(this);


        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent regPage = new Intent(MainActivity.this,RegPage.class);

                startActivity(regPage);


            }
        });

            login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String val1 = username.getText().toString();
                String val2 = password.getText().toString();


                Cursor cursor = object.abc.rawQuery("select * from my_table where name=' " + val1.trim() + " ';", null);

                cursor.moveToFirst();


                if (cursor.getCount() == 0) {
                    Toast.makeText(MainActivity.this, "Username/passowrd doesn't exist", Toast.LENGTH_SHORT).show();
                    return;
                }

                 else {
                    Intent permit = new Intent(MainActivity.this, ContentPage.class);
                    startActivity(permit);
                }

            }

                //String str1= getSharedPreferences("secure",0).getString("username"," ");
                //String str2= getSharedPreferences("secure",0).getString("password"," ");

            });

        }
    }

