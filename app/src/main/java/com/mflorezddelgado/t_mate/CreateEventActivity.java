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

public class CreateEventActivity extends AppCompatActivity {

    private EditText etAsunto, etDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        etAsunto = findViewById(R.id.ed_text_titulo);
        etDescripcion = findViewById(R.id.ed_text_descripcion);
    }
    public void clickGuardarEvento(View view){
        Evento nuevoEvento = new Evento();
        nuevoEvento.setAsunto(etAsunto.getText().toString());
        nuevoEvento.setDescripcion(etDescripcion.getText().toString());

        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
        firestore.collection("Evento").add(nuevoEvento).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
            @Override
            public void onComplete(@NonNull Task<DocumentReference> task) {
                if (task.isSuccessful()){
                    Toast.makeText(CreateEventActivity.this, "Se guardó el evento", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(CreateEventActivity.this, task.getException().toString() , Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}