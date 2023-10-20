package com.mflorezddelgado.t_mate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Register_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ImageButton btnVolver = findViewById(R.id.btn_backr);
        Button RResgister = findViewById(R.id.btn_registerM);

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main = new Intent(Register_Activity.this,Main_Activity.class);
                startActivity(main);
            }
        });

        RResgister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Log = new Intent(Register_Activity.this,Login_Activity.class);
                startActivity(Log);
            }
        });
    }
}