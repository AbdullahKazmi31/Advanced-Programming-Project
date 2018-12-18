package com.example.abdullahkazmi.demo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Main2SignUp extends AppCompatActivity {

    private Button signupbutton;
    private EditText name;
    private EditText password;
    private EditText cnic;
    private EditText address;
    private EditText contactno;
    private EditText econtactno;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_sign_up);

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

        signupbutton = (Button)findViewById(R.id.signup);
        name = (EditText)findViewById(R.id.name);
        password = (EditText)findViewById(R.id.password);
        cnic = (EditText)findViewById(R.id.cnic);
        address = (EditText)findViewById(R.id.address);
        contactno = (EditText)findViewById(R.id.contactno);
        econtactno = (EditText)findViewById(R.id.econtactno);


        signupbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V){
                registerUser();
                //openMainActivity();
            }
        });

        name.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V){
                //openMainActivity();
            }
        });

        password.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V){
                //openMainActivity();
            }
        });

    }


    private void registerUser(){
        String email = name.getText().toString().trim();
        String passwor = password.getText().toString().trim();
        String cni = cnic.getText().toString().trim();
        String addres = address.getText().toString().trim();
        String contactn = contactno.getText().toString().trim();
        String econtactn = econtactno.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            //Email is empty
            Toast.makeText(this, "Please enter email.", Toast.LENGTH_SHORT).show();
            //Stop the function from executing further
            return;
        }
        if(TextUtils.isEmpty(passwor)){
            //Password is empty
            Toast.makeText(this, "Please enter password.", Toast.LENGTH_SHORT).show();
            //Stop the function from executing further
            return;
        }
        if(TextUtils.isEmpty(cni)){
            //Email is empty
            Toast.makeText(this, "Please enter cnic.", Toast.LENGTH_SHORT).show();
            //Stop the function from executing further
            return;
        }
        if(TextUtils.isEmpty(addres)){
            //Email is empty
            Toast.makeText(this, "Please enter address.", Toast.LENGTH_SHORT).show();
            //Stop the function from executing further
            return;
        }
        if(TextUtils.isEmpty(contactn)){
            //Email is empty
            Toast.makeText(this, "Please enter contact number.", Toast.LENGTH_SHORT).show();
            //Stop the function from executing further
            return;
        }
        if(TextUtils.isEmpty(econtactn)){
            //Email is empty
            Toast.makeText(this, "Please enter emergency contact number.", Toast.LENGTH_SHORT).show();
            //Stop the function from executing further
            return;
        }

        progressDialog.setMessage("Signing Up...");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email,passwor)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();
                if (task.isSuccessful()){
                    Toast.makeText(Main2SignUp.this,"Sign Up Successful.", Toast.LENGTH_SHORT).show();
                    openMainActivity();
                }
                else{
                    Toast.makeText(Main2SignUp.this,"Sign Up Failed.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void openMainActivity(){
        Intent intent3 = new Intent(this, MainActivity.class);
        startActivity(intent3);
    }
}
