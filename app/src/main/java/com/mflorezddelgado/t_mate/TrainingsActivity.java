package com.mflorezddelgado.t_mate;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class TrainingsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Entrenamiento> trainingList;
    TrainingsListAdapter trainingsListAdapter;

    FirebaseFirestore db;
    @SuppressLint("MissingInflatedId")
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

        recyclerView = findViewById(R.id.listTrainingsView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        db = FirebaseFirestore.getInstance();
        trainingList = new ArrayList<Entrenamiento>();
        trainingsListAdapter = new TrainingsListAdapter(trainingList,this);

        recyclerView.setAdapter(trainingsListAdapter);

        EventChangerListener();
    }

    private void EventChangerListener() {
        db.collection("Entrenamiento").orderBy("titulo", Query.Direction.ASCENDING)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                        if (error != null){
                            Log.e("Error de Firestore",error.getMessage());
                            return;
                        }

                        //Actualiza la lista cada vez que se agregan un nuevo registro
                        for (DocumentChange dc : value.getDocumentChanges()){
                            if (dc.getType() == DocumentChange.Type.ADDED){
                                trainingList.add(dc.getDocument().toObject(Entrenamiento.class));
                            }

                            trainingsListAdapter.notifyDataSetChanged();
                        }
                    }
                });
    }
}