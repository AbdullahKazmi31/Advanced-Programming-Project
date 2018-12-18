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

public class MainActivity extends AppCompatActivity {
private Button loginbutton;
private Button registerbutton;
private EditText EmailID;
private EditText password;
private ProgressDialog progressDialog;
private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() != null){
            //profile activity here
            openMain2ActivityPatient();
        }

        loginbutton = (Button)findViewById(R.id.login);
        registerbutton = (Button)findViewById(R.id.registerhere);

        EmailID = (EditText)findViewById(R.id.EmailID);
        password = (EditText)findViewById(R.id.password);

        loginbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V){
                userLogin();
                //openMain2ActivityPatient();
            }
        });

        registerbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V){
                openMain2SignUp();
            }
        });
    }

    public void openMain2ActivityPatient(){
        Intent intent = new Intent(this, Main2ActivityPatient.class);
        startActivity(intent);
    }

    public void openMain2SignUp(){
        Intent intent2 = new Intent(this, Main2SignUp.class);
        startActivity(intent2);
    }

    private void userLogin(){
        String loginemail = EmailID.getText().toString().trim();
        String loginpassword = password.getText().toString().trim();

        if(TextUtils.isEmpty(loginemail)){
            //Email is empty
            Toast.makeText(this, "Please enter email.", Toast.LENGTH_SHORT).show();
            //Stop the function from executing further
            return;
        }
        if(TextUtils.isEmpty(loginpassword)){
            //Email is empty
            Toast.makeText(this, "Please enter password.", Toast.LENGTH_SHORT).show();
            //Stop the function from executing further
            return;
        }
        progressDialog.setMessage("Logging in...");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(loginemail,loginpassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if(task.isSuccessful()){
                            //profile activity here
                            Toast.makeText(MainActivity.this,"Login Successful.", Toast.LENGTH_SHORT).show();
                            openMain2ActivityPatient();
                        }
                        else{
                            Toast.makeText(MainActivity.this,"Incorrect ID or password.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
