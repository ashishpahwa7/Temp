package org.vipsace.ace_thetechnicalsocietyofvsit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ContentPage extends AppCompatActivity {

    ArrayList<String> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_page);


        //Toast.makeText(ContentPage.this, "You are now Logged in ", Toast.LENGTH_LONG).show();

        final ListView list = (ListView) findViewById(R.id.list);

        data.add("Events");
        data.add("Workshops");
        data.add("Developer of the Month");
        data.add("What's hot in Tech");

        data.add("Insights");
        data.add("Digital Profiles");

        data.add("Share suggestions/ideas");
        data.add("Submit a new Challenge");
        data.add("Join Team");


        //CustomAdapter customAdapter = new CustomAdapter(ContentPage.this, data);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ContentPage.this, android.R.layout.simple_list_item_1, data);


        list.setAdapter(adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                int itemPosition     = position;
                String  itemValue    = (String) list.getItemAtPosition(position);

                if(itemPosition==5)
                {

                    Intent intent=new Intent(ContentPage.this,HomePage.class);

                    startActivity(intent);}


            }
        });







    }
}
