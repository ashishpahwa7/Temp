package org.vipsace.ace_thetechnicalsocietyofvsit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity {

    EditText input;
    String str;
    Button Add;

    ArrayList<String> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        input = (EditText) findViewById(R.id.T1);
        Add = (Button) findViewById(R.id.add);

        final   ListView list = (ListView) findViewById(R.id.list);


        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                str = input.getText().toString();




                if(!data.contains(str))
                {
                    data.add(str);

                    CustomAdapter customAdapter = new CustomAdapter(HomePage.this, data);
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(HomePage.this, R.layout.mylayout, data);


                    list.setAdapter(customAdapter);
                }
                else { Toast.makeText(getBaseContext(),"Pagal hai ? ", Toast.LENGTH_LONG).show();}


            }
        });


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TextView abc = (TextView) view.findViewById(R.id.Title);
                Button b2 = (Button) view.findViewById(R.id.b2);
                str = abc.getText().toString();


                Toast.makeText(getBaseContext(), str, Toast.LENGTH_LONG).show();


            }
        });




    }
}
