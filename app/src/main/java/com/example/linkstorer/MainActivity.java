package com.example.linkstorer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import java.util.List;

import static com.example.linkstorer.R.id.textView;
import static com.example.linkstorer.dbHelper.*;

public class MainActivity extends AppCompatActivity {
    dbHelper DB;
    EditText linkDescription;
    EditText link;
    Button addLink;
    ListView linklist;
    ArrayList<Link> links;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         linkDescription = (EditText)findViewById(R.id.linkDescription);
         link = (EditText)findViewById(R.id.link);
         addLink = (Button)findViewById(R.id.addLink);
        DB = new dbHelper(this);
        addLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String linkDesc = linkDescription.getText().toString();
                String linkTxt = link.getText().toString();
                Boolean checkInserted = DB.insertuserData(linkTxt,linkDesc);
                if(checkInserted==true)
                    Toast.makeText(MainActivity.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
                // display data
                Intent i = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(i);



            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();





    }
}