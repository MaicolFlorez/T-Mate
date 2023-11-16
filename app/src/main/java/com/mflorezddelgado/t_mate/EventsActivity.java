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

public class EventsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Evento> eventList;
    EventListAdapter eventListAdapter;

    FirebaseFirestore db;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        ImageView imgGoToEvents = findViewById(R.id.img_events_foot);
        ImageView imgGoToTraining = findViewById(R.id.img_trainings_foot);
        ImageView imgGoToMenu = findViewById(R.id.img_home_foot);
        ImageView imgGoToTeam = findViewById(R.id.img_myteam_foot);
        ImageView imgGoToProfile = findViewById(R.id.img_profile_foot);

        ImageButton btnCreateEvent = findViewById(R.id.imgbtn_crear_evento);

        btnCreateEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EventsActivity.this, CreateEventActivity.class));
            }
        });
        imgGoToEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EventsActivity.this, EventsActivity.class));
            }
        });
        imgGoToTraining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EventsActivity.this, TrainingsActivity.class));
            }
        });

        imgGoToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EventsActivity.this, TeamViewCoach.class));
            }
        });

        imgGoToTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EventsActivity.this, TeamsViewPlayer.class));
            }
        });

        imgGoToProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EventsActivity.this, ProfileActivity.class));
            }
        });

        recyclerView = findViewById(R.id.listEventsView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        db = FirebaseFirestore.getInstance();
        eventList = new ArrayList<Evento>();
        eventListAdapter = new EventListAdapter(eventList,this);

        recyclerView.setAdapter(eventListAdapter);

        EventChangerListener();

    }

    //Comprueba si hubieron cambios dentro de la base de datos
    private void EventChangerListener() {
        db.collection("Evento").orderBy("asunto", Query.Direction.ASCENDING)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                        if (error != null){
                            Log.e("Error de Firestore",error.getMessage());
                            return;
                        }

                        for (DocumentChange dc : value.getDocumentChanges()){
                            if (dc.getType() == DocumentChange.Type.ADDED){
                                eventList.add(dc.getDocument().toObject(Evento.class));
                            }

                            eventListAdapter.notifyDataSetChanged();
                        }
                    }
                });
    }
}