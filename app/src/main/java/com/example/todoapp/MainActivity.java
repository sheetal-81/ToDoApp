package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private MenuBuilder itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView=(ListView) findViewById(R.id.listView);
        Button Submit=(Button) findViewById(R.id.Submit);

        Submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                addItem(view);

            }
        });
        ArrayList<String> items = new ArrayList<>();
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        listView = findViewById(R.id.listView);
        listView.setAdapter(itemsAdapter);
        setUpListViewListener();



    }
    private void setUpListViewListener()
    {
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Context context=getApplicationContext();
                Toast.makeText(context,"Items are Removed Now",Toast.LENGTH_LONG).show();
                return true;
            }
        });
    }
    private void addItem(View view)
    {
        EditText input=findViewById(R.id.Text);
        String itemText=input.getText().toString();
        if(!(itemText.equals("")))
        {
            itemAdapter.add(itemText);
            input.setText("");
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Enter your Schedule",Toast.LENGTH_LONG).show();
        }
    }

}