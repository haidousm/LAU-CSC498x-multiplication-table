package com.haidousm.multiplication_table;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

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

    private final int minimumVal = 1;
    private final int maximumVal = 20;

    ArrayList<Integer> listItems = new ArrayList<>();
    MultiplicationItemAdapter arrayAdapter;

    SeekBar seekBar;
    TextView seekedValueLabel;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setMin(minimumVal);
        seekBar.setMax(maximumVal);

        seekedValueLabel = (TextView) findViewById(R.id.seekedValueLabel);

        ListView multiplicationList = (ListView) findViewById(R.id.multList);

        arrayAdapter = new MultiplicationItemAdapter(this,
                android.R.layout.simple_list_item_1,
                listItems);
        multiplicationList.setAdapter(arrayAdapter);
        updateListItems(1);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateListItems(progress);
                seekedValueLabel.setText(String.format("The value you seek is %d", progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    private void updateListItems(int x) {
        listItems.clear();
        for (int i = minimumVal; i <= maximumVal; i++){
            listItems.add(i * x);
        }
        arrayAdapter.notifyDataSetChanged();
    }

}