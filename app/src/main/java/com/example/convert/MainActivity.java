package com.example.convert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Spinner spF, spT;
    EditText textIn;
    Button convert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textIn = (EditText)findViewById(R.id.input);
        spF = (Spinner)findViewById(R.id.spFrom);
        spT = (Spinner)findViewById(R.id.spTo);
        convert = (Button) findViewById(R.id.convert);

        String[] lib = {"BIN", "OCT", "DEC", "HEX"};
        ArrayAdapter ad = new ArrayAdapter <String>(this, R.layout.support_simple_spinner_dropdown_item, lib);

        spF.setAdapter(ad);
        spT.setAdapter(ad);

        convert.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String input = textIn.getText().toString();
                if (spF.getSelectedItem().toString().equals(spT.getSelectedItem().toString())) {
                    printResult(input);
                } else {
                    if (spF.getSelectedItem().toString() == "HEX") {
                        int hex = Integer.parseInt(input, 16);
                        input = Integer.toString(hex);
                    }
                    if (spF.getSelectedItem().toString() == "OCT") {
                        int oct = Integer.parseInt(input, 8);
                        input = Integer.toString(oct);
                    }
                    if (spF.getSelectedItem().toString() == "BIN") {
                        int bin = Integer.parseInt(input, 2);
                        input = Integer.toString(bin);
                    }
                    int change = Integer.parseInt(input);
                    if (spT.getSelectedItem().toString() == "HEX"){
                        String s = Integer.toHexString(change);
                        printResult(s);
                    }
                    if (spT.getSelectedItem().toString() == "DEC"){
                        printResult(input);
                    }
                    if (spT.getSelectedItem().toString() == "OCT"){
                        String s = Integer.toOctalString(change);
                        printResult(s);
                    }
                    if (spT.getSelectedItem().toString() == "BIN"){
                        String s = Integer.toBinaryString(change);
                        printResult(s);
                    }
                }
            }
        });


    }
    void printResult(String out){
        TextView result = (TextView)findViewById(R.id.result);
        result.setText(out);
    }
}