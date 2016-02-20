package org.vipsace.ace_thetechnicalsocietyofvsit;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegPage extends AppCompatActivity {


    DataBaseHelper object ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_page);

        final EditText username = (EditText)findViewById(R.id.username);
        final EditText password= (EditText)findViewById(R.id.Password);
        Button button = (Button)findViewById(R.id.button);

        object = new DataBaseHelper(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String str = username.getText().toString();
                String pass = password.getText().toString();

                object.abc.execSQL("INSERT into my_table values ('"+str+"','"+pass+"');");

                Toast.makeText(RegPage.this, "User Added to DataBase", Toast.LENGTH_SHORT).show();



                Intent intent = new Intent(RegPage.this ,Success.class );



                getSharedPreferences("secure",0).edit().putString("username", str).commit();
                getSharedPreferences("secure",0).edit().putString("password",pass).commit();

                startActivity(intent);



            }
        });





    }
}
