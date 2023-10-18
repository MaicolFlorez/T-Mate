package com.mflorezddelgado.t_mate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Main_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button MLogin = findViewById(R.id.btn_loginM);
        Button MResgister = findViewById(R.id.btn_backr);
        MLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main_Activity.this, Login_Activity.class);
                startActivity(intent);
            }
        });
    }
}