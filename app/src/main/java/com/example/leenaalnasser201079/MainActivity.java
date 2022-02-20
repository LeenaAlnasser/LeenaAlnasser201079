package com.example.leenaalnasser201079;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    private EditText editText;
    private Spinner spinner;
    private Button costButton;
    private TextView costTextView;
    private ArrayAdapter<String> adapter;
    private String currentSelectedBand;
    private double costTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        editText = findViewById(R.id.edit_text_tickets_num);
        spinner = findViewById(R.id.spinner);
        costButton = findViewById(R.id.button);
        costTextView = findViewById(R.id.cost_textView);

        costTextView.setVisibility(View.GONE);
        adapter.add("Adele");
        adapter.add("Coldplay");
        adapter.add("The Rolling Stones");
        adapter.add("Dua Lipa");
        adapter.add("Selena Gomez");
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        costButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == costButton){
            if(editText.getText().toString().equals("")){
                editText.setError("This field cannot be empty");
                return;
            }
            int person;
            person = Integer.parseInt(editText.getText().toString());
            costTotal = person*59.99;
            String outString = String.format("Number of persons: %d\nBand Name: %s\nTotal Cost: $%.2f",person,currentSelectedBand,costTotal);
            costTextView.setText(outString);
            costTextView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        currentSelectedBand = adapter.getItem(i);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}