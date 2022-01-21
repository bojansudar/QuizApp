package com.kviz_pokusaj1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class RazredActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_razred);

        Button razred6Btn = findViewById(R.id.razred6Btn);
        Button razred7Btn = findViewById(R.id.razred7Btn);
        Button razred8Btn = findViewById(R.id.razred8Btn);
        Button razred9Btn = findViewById(R.id.razred9Btn);
        Button odjavaBtn = findViewById(R.id.odjavaBtn);


        odjavaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(), "Uspješno ste se odjavili", Toast.LENGTH_LONG).show();
            }
        });

        razred6Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Razred6Activity.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(),"Uspješno ste odabrali 6 razred", Toast.LENGTH_LONG).show();
            }

        });
        razred7Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Razred7Activity.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(), "Uspješno ste odabrali 7 razred",Toast.LENGTH_LONG).show();
            }
        });
        razred8Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Razred8Activity.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(),"Uspješno ste odabrali 8 razred", Toast.LENGTH_LONG).show();
            }
        });
        razred9Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Razred9Activity.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(), "Uspješno ste odabrali 9 razred", Toast.LENGTH_LONG).show();
            }
        });
    }
}