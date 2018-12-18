package com.example.abdullahkazmi.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2option extends AppCompatActivity {

    private Button doctorbutton;
    private Button patientbutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2option);

        doctorbutton = (Button)findViewById(R.id.doctor);
        patientbutton = (Button)findViewById(R.id.patient);

        doctorbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V){
                openMain2login1();
            }
        });

        patientbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V){
                openMainActivity1();
            }
        });
    }

    public void openMain2login1(){
        Intent intent4 = new Intent(this, Main2login1.class);
        startActivity(intent4);
    }

    public void openMainActivity1(){
        Intent intent4 = new Intent(this, MainActivity.class);
        startActivity(intent4);
    }
}
