package com.sananda.splproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class SignUp extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button signUp;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();

        username=findViewById(R.id.username);
        password= findViewById(R.id.password);
        Button signUp=findViewById(R.id.signUp);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userRegister();
            }
        });

    }

    private void userRegister() {
        String mail = username.getText().toString().trim();
        String pass = password.getText().toString().trim();

        //checking validity

        if(mail.isEmpty())
        {
            username.setError("Enter an email address");
            username.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(mail).matches())
        {
            username.setError("Enter a valid email address");
            username.requestFocus();
            return;
        }

        if(pass.isEmpty())
        {
            password.setError("Enter a valid password");
            password.requestFocus();
            return;
        }
        if(pass.length()<6)
        {
            password.setError("password length should be minimum 6");
            password.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(mail,pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {

                    Intent intent;
                    intent=new Intent(SignUp.this,Menu.class);
                    startActivity(intent);

                    Toast.makeText(SignUp.this,"Registration is successful",Toast.LENGTH_SHORT).show();

                    finish();

                } else {

                    if(task.getException()instanceof FirebaseAuthUserCollisionException)
                        Toast.makeText(SignUp.this,"User is already registered",Toast.LENGTH_SHORT).show();
                    else
                    {
                        Toast.makeText(SignUp.this,"Registration is not successful",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }
}
