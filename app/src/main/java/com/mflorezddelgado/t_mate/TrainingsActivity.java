package com.mflorezddelgado.t_mate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class TrainingsActivity extends AppCompatActivity {
    List<Entrenamiento> elements;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainings);

        ImageView imgGoToEvents = findViewById(R.id.img_events_foot);
        ImageView imgGoToTraining = findViewById(R.id.img_trainings_foot);
        ImageView imgGoToMenu = findViewById(R.id.img_home_foot);
        ImageView imgGoToTeam = findViewById(R.id.img_myteam_foot);
        ImageView imgGoToProfile = findViewById(R.id.img_profile_foot);

        ImageButton btnCreateTraining = findViewById(R.id.imgbtn_crear_ejercicio);

        btnCreateTraining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TrainingsActivity.this, CreateTrainingActivity.class));
            }
        });
        imgGoToEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TrainingsActivity.this, EventsActivity.class));
            }
        });
        imgGoToTraining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TrainingsActivity.this, TrainingsActivity.class));
            }
        });

        imgGoToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TrainingsActivity.this, TeamViewCoach.class));
            }
        });

        imgGoToTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TrainingsActivity.this, TeamsViewPlayer.class));
            }
        });

        imgGoToProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TrainingsActivity.this, ProfileActivity.class));
            }
        });
    }
    public void initC(){
        elements = new ArrayList<>();
        elements.add(new Entrenamiento( "PIBE", "Fuchibol", "Crewmate"));
        elements.add(new Entrenamiento( "Mogus", "Fuchibol", "Crewmate"));
        elements.add(new Entrenamiento( "Mogus", "Fuchibol", "Crewmate"));
        elements.add(new Entrenamiento( "Mogus", "Fuchibol", "Crewmate"));
        elements.add(new Entrenamiento( "Mogus", "Fuchibol", "Crewmate"));
        elements.add(new Entrenamiento( "Mogus", "Fuchibol", "Crewmate"));
        elements.add(new Entrenamiento( "Mogus", "Fuchibol", "Crewmate"));
        elements.add(new Entrenamiento( "Mogus", "Fuchibol", "Crewmate"));

        ListAdapter listAdapter = new ListAdapter(elements,this);
        RecyclerView recyclerView =findViewById(R.id.listTeamsView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
    }
}