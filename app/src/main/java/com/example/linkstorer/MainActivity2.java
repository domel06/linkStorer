package com.example.linkstorer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        dbHelper DB = new dbHelper(this);
        ArrayList<HashMap<String, String>> userLink = DB.getdata();
        ListView lv = (ListView)findViewById(R.id.link_list);


        ListAdapter adapter =  new SimpleAdapter(MainActivity2.this, userLink, R.layout.linklist,new String[]{"linkDesc","link"}, new int[]{R.id.linkDesc, R.id.link});
       lv.setAdapter(adapter);
    }

}