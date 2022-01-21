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

public class RegisterActivity extends AppCompatActivity {

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        this.auth = FirebaseAuth.getInstance();

        Button RegisterBtn =  findViewById(R.id.RegisterBtn);
        EditText firstnameTxt =  findViewById(R.id.firstnameTxt);
        EditText lastnameTxt = findViewById(R.id.lastnameTxt);
        EditText emailTxt = findViewById(R.id.emailTxt);
        EditText passwordTxt = findViewById(R.id.passwordTxt);
        EditText passwordComfirmTxt = findViewById(R.id.passwordConfirmTxt);

        RegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstname = firstnameTxt.getText().toString();
                String lastname  = lastnameTxt.getText().toString();
                String email = emailTxt.getText().toString();
                String password = passwordTxt.getText().toString();
                String confirmPassword = passwordComfirmTxt.getText().toString();
                /*kod ispod nam govori ako nije nesto popunjeno da nam izbaci da popunimo sva polja*/
                if (firstname.equals("") || lastname.equals("") || email.equals("") || password.equals("") || confirmPassword.equals("")){
                    Toast.makeText(getApplicationContext(), "Popunite sva polja", Toast.LENGTH_LONG).show();
                } else if (!password.equals(confirmPassword))/* ako lozinka nije ista kao i kada potvrdjujemo*/{
                   Toast.makeText(getApplicationContext(),"Lozinke se ne podudaraju", Toast.LENGTH_LONG).show();
                } else {
                    auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(i);
                            }
                        }
                    });
                }
            }
        });
    }
}