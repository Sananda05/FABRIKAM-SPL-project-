package com.sananda.splproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignIn extends AppCompatActivity {

    private EditText mail;
    private EditText password;
    private Button log_in;
    private Button sign_up;
    private ImageView logo;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        mAuth = FirebaseAuth.getInstance();

        mail = findViewById(R.id.username);
        password = findViewById(R.id.password);
        log_in = findViewById(R.id.signIn);
        sign_up = findViewById(R.id.signUp);

        log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userLogin();
            }
        });

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(SignIn.this, SignUp.class);
                startActivity(intent);
            }
        });
    }

    private void userLogin() {

        String email = mail.getText().toString().trim();
        String pass = password.getText().toString().trim();
        //checking validity

        if (email.isEmpty()) {
            mail.setError("Enter an email address");
            mail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            mail.setError("Enter a valid email address");
            mail.requestFocus();
            return;
        }

        if (pass.isEmpty()) {
            password.setError("Enter a valid password");
            password.requestFocus();
            return;
        }
        if ((pass.length() < 6)){
            password.setError("password length should be minimum 6");
            password.requestFocus();
            return;
        }

        mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {

                    Intent intent;
                    intent = new Intent(SignIn.this, Menu.class);
                    startActivity(intent);


                    Toast.makeText(SignIn.this, "Log in is successful", Toast.LENGTH_SHORT).show();
                    finish();


                } else {
                    Toast.makeText(SignIn.this, "Log in is not successful", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
