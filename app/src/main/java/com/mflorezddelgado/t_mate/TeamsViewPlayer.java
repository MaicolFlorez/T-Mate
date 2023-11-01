package com.mflorezddelgado.t_mate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.PopupWindow;

public class TeamsViewPlayer extends AppCompatActivity {

    List<ListElement> elements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams_player_view);

        init();

        ImageButton imgUnirse = findViewById(R.id.imgbtn_unirse);

        View popupView = getLayoutInflater().inflate(R.layout.popup_layout_unirse, null);
        PopupWindow popupWindow = new PopupWindow(popupView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);

        imgUnirse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.showAtLocation(view, Gravity.CENTER_HORIZONTAL, 0, 0);
            }
        });
    }
}