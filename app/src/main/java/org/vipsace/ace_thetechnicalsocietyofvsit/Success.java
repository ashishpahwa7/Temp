package org.vipsace.ace_thetechnicalsocietyofvsit;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Success extends AppCompatActivity {

    DataBaseHelper object ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        Button login = (Button) findViewById(R.id.login);

        //String username = getSharedPreferences("secure",0).getString("username"," ");
        //String  password= getSharedPreferences("secure",0).getString("password", " ");



        object = new DataBaseHelper(this);


        Cursor cursor = object.abc.rawQuery("select *from my_table",null);

        cursor.moveToLast();

        String record=" " ;

        record = cursor.getString(0);

        Toast.makeText(Success.this,record, Toast.LENGTH_SHORT).show();

        record = cursor.getString(1);

        Toast.makeText(Success.this,record, Toast.LENGTH_SHORT).show();






        //Toast.makeText(Success.this, username, Toast.LENGTH_LONG).show();
        //Toast.makeText(Success.this, password, Toast.LENGTH_SHORT).show();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent homepage = new Intent(Success.this,MainActivity.class);
                startActivity(homepage);
            }
        });



    }
}
