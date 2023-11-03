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

public class CreateTrainingActivity extends AppCompatActivity {

    private EditText etTitulo, etDescripcion, etCaracteristicas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_training);

        etTitulo = findViewById(R.id.ed_text_titulo);
        etDescripcion = findViewById(R.id.ed_text_descripcion);
        etCaracteristicas = findViewById(R.id.ed_text_caracteristicas);

        ImageView imgGoToEvents = findViewById(R.id.img_events_foot);
        ImageView imgGoToTraining = findViewById(R.id.img_trainings_foot);
        ImageView imgGoToMenu = findViewById(R.id.img_home_foot);
        ImageView imgGoToTeam = findViewById(R.id.img_myteam_foot);
        ImageView imgGoToProfile = findViewById(R.id.img_profile_foot);

        imgGoToEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CreateTrainingActivity.this, EventsActivity.class));
            }
        });
        imgGoToTraining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CreateTrainingActivity.this, TrainingsActivity.class));
            }
        });

        imgGoToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CreateTrainingActivity.this, TeamViewCoach.class));
            }
        });

        imgGoToTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CreateTrainingActivity.this, TeamsViewPlayer.class));
            }
        });

        imgGoToProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CreateTrainingActivity.this, ProfileActivity.class));
            }
        });

    }

    public void clickGuardarEjercicio(View view){
        Entrenamiento nuevoEntrenamiento = new Entrenamiento();
        nuevoEntrenamiento.setTitulo(etTitulo.getText().toString());
        nuevoEntrenamiento.setDescripcion(etDescripcion.getText().toString());
        nuevoEntrenamiento.setCaracteristicas(etCaracteristicas.getText().toString());

        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
        firestore.collection("Entrenamiento").add(nuevoEntrenamiento).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
            @Override
            public void onComplete(@NonNull Task<DocumentReference> task) {
                if (task.isSuccessful()){
                    Toast.makeText(CreateTrainingActivity.this, "Se creó el registro", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(CreateTrainingActivity.this, task.getException().toString() , Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}