package com.mflorezddelgado.t_mate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

import java.util.ArrayList;
import java.util.List;

public class TeamViewCoach extends AppCompatActivity {

    List<ListElement> elements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_view_coach);

        initC();

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

    public void initC(){
        elements = new ArrayList<>();
        elements.add(new ListElement("#775447", "Mogus", "Fuchibol", "Crewmate"));
        elements.add(new ListElement("#766447", "Mogus", "Fuchibol", "Crewmate"));

        ListAdapter listAdapter = new ListAdapter(elements,this);
        RecyclerView recyclerView =findViewById(R.id.listTeamsView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
    }
}