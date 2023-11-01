package com.mflorezddelgado.t_mate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

public class TeamViewCoach extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_view_coach);

        Button btnCrear = findViewById(R.id.btn_crear);
        Button btnUnirse = findViewById(R.id.btn_unirse);

        View popupViewUnirse = getLayoutInflater().inflate(R.layout.popup_layout_unirse, null);
        PopupWindow popupWindowUnirse = new PopupWindow(popupViewUnirse, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);

        View popupViewCrear = getLayoutInflater().inflate(R.layout.popup_layout_crear, null);
        PopupWindow popupWindowCrear = new PopupWindow(popupViewCrear, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);

        btnUnirse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindowUnirse.showAtLocation(v, Gravity.TOP, 0, 250);
            }
        });

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindowCrear.showAtLocation(v, Gravity.TOP, 0, 250);
            }
        });
    }
}