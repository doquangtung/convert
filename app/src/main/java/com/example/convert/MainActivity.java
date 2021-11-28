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
                String fr = spF.getSelectedItem().toString();
                String to = spT.getSelectedItem().toString();
                String s;
                if (fr.equals(to)) {
                    s = "No thing to convert";
                    printResult(s);
                } else {
                    if (fr == "HEX") {
                        int hex = Integer.parseInt(input, 16);
                        input = Integer.toString(hex);
                    }
                    if (fr == "OCT") {
                        int oct = Integer.parseInt(input, 8);
                        input = Integer.toString(oct);
                    }
                    if (fr == "BIN") {
                        int bin = Integer.parseInt(input, 2);
                        input = Integer.toString(bin);
                    }
                    int change = Integer.parseInt(input);
                    if (to == "HEX"){
                        s = Integer.toHexString(change);
                        printResult(s);
                    }
                    if (to == "DEC"){
                        s = input;
                        printResult(s);
                    }
                    if (spT.getSelectedItem().toString() == "OCT"){
                        s = Integer.toOctalString(change);
                        printResult(s);
                    }
                    if (spT.getSelectedItem().toString() == "BIN"){
                        s = Integer.toBinaryString(change);
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