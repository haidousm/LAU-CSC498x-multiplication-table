package com.haidousm.multiplication_table;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

// simple adapter class just so that the list items are not clickable
class MultiplicationItemAdapter extends ArrayAdapter<Integer>{

    public MultiplicationItemAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Integer> objects) {
        super(context, resource, objects);
    }

    @Override
    public boolean isEnabled(int position){
        return false;
    }

}

public class MainActivity extends AppCompatActivity {

    ArrayList<Integer> listItems = new ArrayList<>(Arrays.asList(1, 2, 3, 4));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView multiplicationList = (ListView) findViewById(R.id.multList);

        MultiplicationItemAdapter arrayAdapter = new MultiplicationItemAdapter(this,
                android.R.layout.simple_list_item_1,
                listItems);

        multiplicationList.setAdapter(arrayAdapter);

    }
}