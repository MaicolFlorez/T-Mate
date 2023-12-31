package com.mflorezddelgado.t_mate;

import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class TeamsViewPlayer extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Teams> teamsList;
    ListAdapter listAdapter;

    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams_player_view);

        //initP();

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
                popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
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


   /* public void initP(){
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
}