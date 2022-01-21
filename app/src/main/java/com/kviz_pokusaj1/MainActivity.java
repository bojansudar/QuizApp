package com.kviz_pokusaj1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.auth = FirebaseAuth.getInstance();

        Button loginBtn = findViewById(R.id.loginBtn);
        Button registracijaBtn = findViewById(R.id.registracijaBtn);
        EditText usernameTxt = findViewById(R.id.usernameTxt);
        EditText passwordPwd = findViewById(R.id.passwordPwd);

        registracijaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(i);
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameTxt.getText().toString();
                String password = passwordPwd.getText().toString();
                auth.signInWithEmailAndPassword(username, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Uspješno ste se prijavili", Toast.LENGTH_LONG).show();
                            /*Prelazak iz trenutne aktivnosti u StartActivity */
                            Intent i = new Intent(getApplicationContext(), RazredActivity.class); /*klasa StartActivity*/
                            startActivity(i); /*metoda koja pokrece sljedeci startactivity*/
                            /*                                               */
                        }else {
                            Toast.makeText(getApplicationContext(), "Niste se uspješno prijavili",Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });

    }
}