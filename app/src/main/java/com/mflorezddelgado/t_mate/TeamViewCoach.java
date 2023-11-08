package com.mflorezddelgado.t_mate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;

import java.util.ArrayList;
import java.util.List;

public class TeamViewCoach extends AppCompatActivity {

    List<Teams> elements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_view_coach);

        initC();

        Button btnCrear = findViewById(R.id.btn_crear);
        Button btnUnirse = findViewById(R.id.btn_unirse);
        ImageView imgGoEvents = findViewById(R.id.img_events_foot);
        ImageView imgGoExercises = findViewById(R.id.img_trainings_foot);
        ImageView imgGoMenu = findViewById(R.id.img_home_foot);
        ImageView imgGoTeam = findViewById(R.id.img_myteam_foot);
        ImageView imgGoProfile = findViewById(R.id.img_profile_foot);

        View popupViewUnirse = getLayoutInflater().inflate(R.layout.popup_layout_unirse, null);
        PopupWindow popupWindowUnirse = new PopupWindow(popupViewUnirse, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);

        View popupViewCrear = getLayoutInflater().inflate(R.layout.popup_layout_crear, null);
        PopupWindow popupWindowCrear = new PopupWindow(popupViewCrear, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);

        btnUnirse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindowUnirse.showAtLocation(v, Gravity.CENTER, 0, 0);
            }
        });

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindowCrear.showAtLocation(v, Gravity.CENTER, 0, 0);
            }
        });

        imgGoEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TeamViewCoach.this, EventsActivity.class));
            }
        });

        imgGoExercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TeamViewCoach.this, TrainingsActivity.class));
            }
        });

        imgGoMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TeamViewCoach.this, TeamViewCoach.class));
            }
        });

        imgGoTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TeamViewCoach.this, TeamsViewPlayer.class));
            }
        });

        imgGoProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TeamViewCoach.this, ProfileActivity.class));
            }
        });
    }

    public void initC(){
        elements = new ArrayList<>();
        elements.add(new Teams(R.drawable.calendario, "Mogus", "Fuchibol", "Crewmate"));
        elements.add(new Teams(R.drawable.casa_de_perro, "Mogus", "Fuchibol", "Crewmate"));
        elements.add(new Teams(R.drawable.grupo, "Mogus", "Fuchibol", "Crewmate"));
        elements.add(new Teams(R.drawable.ic_launcher_background, "Mogus", "Fuchibol", "Crewmate"));
        elements.add(new Teams(R.drawable.ic_launcher_foreground, "Mogus", "Fuchibol", "Crewmate"));
        elements.add(new Teams(R.drawable.icono_tmate, "Mogus", "Fuchibol", "Crewmate"));
        elements.add(new Teams(R.drawable.pesa, "Mogus", "Fuchibol", "Crewmate"));
        elements.add(new Teams(R.drawable.usuario, "Mogus", "Fuchibol", "Crewmate"));

        ListAdapter listAdapter = new ListAdapter(elements,this);
        RecyclerView recyclerView =findViewById(R.id.listTeamsView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
    }
}