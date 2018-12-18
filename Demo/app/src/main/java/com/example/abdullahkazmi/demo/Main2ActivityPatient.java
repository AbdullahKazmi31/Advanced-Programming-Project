package com.example.abdullahkazmi.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Main2ActivityPatient extends AppCompatActivity {

   // private TextView textView;
    //private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_patient);

      //  firebaseAuth.getInstance();

        //FirebaseUser user = firebaseAuth.getCurrentUser();

        //textView = (TextView)findViewById(R.id.textView);
        //textView.setText("Welcome" + user.getEmail());
    }
}
