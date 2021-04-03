package com.example.unitconversion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity  implements AdapterView.OnItemSelectedListener {
    EditText txt;
    Button btn;
    String msg,r;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spineer = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.contain, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        txt = findViewById(R.id.editTextNumber);
        btn=findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(MainActivity.this,second.class);
                int m=check(r);
                if(m==1) {

                    in.putExtra("value", msg);
                    startActivity(in);
                }

            }
        });
        spineer.setAdapter(adapter);
        spineer.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String s = parent.getItemAtPosition(position).toString();
         String []s1 = s.split(" ");
        txt.setHint("Enter Value in " + s1[0]);
       r=s1[0];



       // System.out.println(s);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public int check(String p) {
        String s = txt.getText().toString();
        if (s.isEmpty()) {
            txt.setError("Plz enter text");
            return 0;
        } else {

            if (p.equals("Doller")) {
                String s2 = txt.getText().toString();

                int rup = 73 * Integer.parseInt(s2);
                msg = Integer.parseInt(s2) + " Doller is equal to " + rup + " rupees";
            }

            if (p.equals("Meter")) {
                String s2 = txt.getText().toString();

                int rup = 100 * Integer.parseInt(s2);
                msg = Integer.parseInt(s2) + " Meter  is equal to " + rup + " centimeter";
            }
            if (p.equals("Kg")) {
                String s2 = txt.getText().toString();

                int rup = 1000 * Integer.parseInt(s2);
                msg = Integer.parseInt(s2) + " Kilogram is equal to " + rup + " gram";
            }
            if (p.equals("Inches")) {
                String s2 = txt.getText().toString();

                double rup = (double) 0.0833 * Integer.parseInt(s2);
                msg = Integer.parseInt(s2) + " Inches is equal to " + rup + " Foot";
            }
            if (p.equals("Cm")) {
                String s2 = txt.getText().toString();

                double rup = (double) 0.01 * Integer.parseInt(s2);
                msg = Integer.parseInt(s2) + " Centimeter is equal to " + rup + " Meter";
            }
            if (p.equals("Gram")) {
                String s2 = txt.getText().toString();

                double rup = (double) 0.01 * Integer.parseInt(s2);
                msg = Integer.parseInt(s2) + " Gram is equal to " + rup + " Kilogram";
            }
            if (p.equals("Rupees")) {
                String s2 = txt.getText().toString();

                double rup = (double) 0.014 * Integer.parseInt(s2);
                msg = Integer.parseInt(s2) + " Rupees is equal to " + rup + " Doller";
            }
            if (p.equals("Foot")) {
                String s2 = txt.getText().toString();

                int rup = 12 * Integer.parseInt(s2);
                msg = Integer.parseInt(s2) + " Foot is equal to " + rup + " inches";
            }

return 1;
        }
    }



}