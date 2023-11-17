package com.mflorezddelgado.t_mate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class CreateEventActivity extends AppCompatActivity {

    private EditText etAsunto, etDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        etAsunto = findViewById(R.id.ed_text_titulo);
        etDescripcion = findViewById(R.id.ed_text_descripcion);

        //ImageViews para la barra de navegación
        ImageView imgGoToEvents = findViewById(R.id.img_events_foot);
        ImageView imgGoToTraining = findViewById(R.id.img_trainings_foot);
        ImageView imgGoToMenu = findViewById(R.id.img_home_foot);
        ImageView imgGoToTeam = findViewById(R.id.img_myteam_foot);
        ImageView imgGoToProfile = findViewById(R.id.img_profile_foot);

        imgGoToEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CreateEventActivity.this, EventsActivity.class));
            }
        });
        imgGoToTraining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CreateEventActivity.this, TrainingsActivity.class));
            }
        });

        imgGoToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CreateEventActivity.this, TeamViewCoach.class));
            }
        });

        imgGoToTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CreateEventActivity.this, TeamsViewPlayer.class));
            }
        });

        imgGoToProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CreateEventActivity.this, ProfileActivity.class));
            }
        });
    }


    public void clickGuardarEvento(View view){
        //Se crea un nuevo Evento y se obtienen sus datos
        Evento nuevoEvento = new Evento();
        nuevoEvento.setAsunto(etAsunto.getText().toString());
        nuevoEvento.setDescripcion(etDescripcion.getText().toString());

        FirebaseFirestore firestore = FirebaseFirestore.getInstance();

        //Guarda el evento en la collección "Evento" dentro de la base de datos
        firestore.collection("Evento").add(nuevoEvento).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
            @Override
            public void onComplete(@NonNull Task<DocumentReference> task) {
                //Confirma si sí se pudo crear la instancia del evento
                if (task.isSuccessful()){
                    Toast.makeText(CreateEventActivity.this, "Se guardó el evento", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(CreateEventActivity.this, task.getException().toString() , Toast.LENGTH_SHORT).show();
                }
            }
        });
        //Vuelve a la lista de eventos una vez ya creado
        startActivity(new Intent(CreateEventActivity.this, EventsActivity.class));
    }
}