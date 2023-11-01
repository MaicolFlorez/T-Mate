package com.mflorezddelgado.t_mate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
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