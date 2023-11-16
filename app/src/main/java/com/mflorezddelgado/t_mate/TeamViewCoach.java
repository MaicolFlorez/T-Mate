package com.mflorezddelgado.t_mate;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class TeamViewCoach extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Teams> teamsList;
    ListAdapter listAdapter;

    FirebaseFirestore db;

    //List<Teams> elements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_view_coach);


        //initC();

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

        recyclerView = findViewById(R.id.listTeamsView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        db = FirebaseFirestore.getInstance();
        teamsList = new ArrayList<Teams>();
        listAdapter = new ListAdapter(teamsList,this);

        recyclerView.setAdapter(listAdapter);

        EventChangerListener();
    }

    private void EventChangerListener() {
        db.collection("Teams").orderBy("name", Query.Direction.ASCENDING)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                if (error != null){
                    Log.e("Error de Firestore",error.getMessage());
                    return;
                }

                for (DocumentChange dc : value.getDocumentChanges()){
                    if (dc.getType() == DocumentChange.Type.ADDED){
                        teamsList.add(dc.getDocument().toObject(Teams.class));
                    }

                    listAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    /*public void initC(){
        elements = new ArrayList<>();
        elements.add(new Teams(R.drawable.equi, "Mogus", "Fuchibol", "Crewmate"));
        elements.add(new Teams(R.drawable.equip, "Mogus", "Fuchibol", "Crewmate"));
        elements.add(new Teams(R.drawable.equipo, "Mogus", "Fuchibol", "Crewmate"));
        elements.add(new Teams(R.drawable.equipos, "Mogus", "Fuchibol", "Crewmate"));
        elements.add(new Teams(R.drawable.equipose, "Mogus", "Fuchibol", "Crewmate"));
        elements.add(new Teams(R.drawable.equi, "Mogus", "Fuchibol", "Crewmate"));
        elements.add(new Teams(R.drawable.equipo, "Mogus", "Fuchibol", "Crewmate"));
        elements.add(new Teams(R.drawable.equip, "Mogus", "Fuchibol", "Crewmate"));

        ListAdapter listAdapter = new ListAdapter(elements,this);
        RecyclerView recyclerView =findViewById(R.id.listTeamsView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
    }*/

    //Creación de equipos


}