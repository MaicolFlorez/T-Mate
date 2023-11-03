package com.mflorezddelgado.t_mate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;

import java.util.ArrayList;
import java.util.List;

public class TeamsViewPlayer extends AppCompatActivity {

    List<Teams> elements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams_player_view);

        initP();

        ImageButton imgUnirse = findViewById(R.id.imgbtn_unirse);
        ImageView imgGoEvents = findViewById(R.id.img_events_foot);
        ImageView imgGoExercises = findViewById(R.id.img_trainings_foot);
        ImageView imgGoMenu = findViewById(R.id.img_home_foot);
        ImageView imgGoTeam = findViewById(R.id.img_myteam_foot);
        ImageView imgGoProfile = findViewById(R.id.img_profile_foot);


        View popupView = getLayoutInflater().inflate(R.layout.popup_layout_unirse, null);
        PopupWindow popupWindow = new PopupWindow(popupView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);

        imgUnirse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.showAtLocation(view, Gravity.TOP, 0, 250);
            }
        });

        imgGoEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TeamsViewPlayer.this, EventsActivity.class));
            }
        });

        imgGoExercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TeamsViewPlayer.this, TrainingsActivity.class));
            }
        });

        imgGoMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TeamsViewPlayer.this, TeamViewCoach.class));
            }
        });

        imgGoTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TeamsViewPlayer.this, TeamsViewPlayer.class));
            }
        });

        imgGoProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TeamsViewPlayer.this, ProfileActivity.class));
            }
        });
    }

    public void initP(){
        elements = new ArrayList<>();
        elements.add(new Teams("#775447", "Sos", "Futbol", "Directivo"));
        elements.add(new Teams("#775227", "Mogus", "Fuchibol", "Crewmate"));
        elements.add(new Teams("#775447", "Sos", "Futbol", "Directivo"));
        elements.add(new Teams("#775227", "Mogus", "Fuchibol", "Crewmate"));
        elements.add(new Teams("#775447", "Sos", "Futbol", "Directivo"));
        elements.add(new Teams("#775227", "Mogus", "Fuchibol", "Crewmate"));
        elements.add(new Teams("#775447", "Sos", "Futbol", "Directivo"));
        elements.add(new Teams("#775227", "Mogus", "Fuchibol", "Crewmate"));

        ListAdapter listAdapter = new ListAdapter(elements,this);
        RecyclerView recyclerView =findViewById(R.id.listTeamsView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
    }
}