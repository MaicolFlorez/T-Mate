package com.mflorezddelgado.t_mate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Register_Activity extends AppCompatActivity {

    FirebaseFirestore firestore;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ImageButton btnVolver = findViewById(R.id.btn_backr);
        Button RResgister = findViewById(R.id.btn_registerM);

        EditText reg_email = findViewById(R.id.et_email);
        EditText reg_name = findViewById(R.id.et_register_nombre);
        EditText reg_lastname = findViewById(R.id.et_register_apellidos);
        EditText reg_age = findViewById(R.id.et_edad);
        EditText reg_passw = findViewById(R.id.et_password);
        EditText reg_c_passw = findViewById(R.id.et_confirm);
        firestore = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main = new Intent(Register_Activity.this,Main_Activity.class);
                startActivity(main);
            }
        });

        RResgister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //AUTH
                String emailUser = reg_email.getText().toString().trim();
                String passUser = reg_passw.getText().toString().trim();
                String cPassUser = reg_c_passw.getText().toString().trim();
                String userName = reg_name.getText().toString().trim();
                String userLastName = reg_lastname.getText().toString().trim();
                String userAge = reg_age.getText().toString().trim();


                if (emailUser.isEmpty() && passUser.isEmpty() && cPassUser.isEmpty() && userName.isEmpty() && userLastName.isEmpty() && userAge.isEmpty()){
                    Toast.makeText(Register_Activity.this, "Debe completar todos los datos.", Toast.LENGTH_SHORT).show();
                }
                else{
                    if (cPassUser.equals(passUser)){
                        registerUser(emailUser, passUser);
                        Intent Log = new Intent(Register_Activity.this,Login_Activity.class);
                        startActivity(Log);
                    }else{
                        Toast.makeText(Register_Activity.this, "Las constraseñas no concuerdan", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

    }

    private void registerUser(String emailUser, String passUser) {
        mAuth.createUserWithEmailAndPassword(emailUser, passUser).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                //String id = mAuth.getCurrentUser().getUid();
                Map<String, Object> map = new HashMap<>();
                //map.put("id", id);
                map.put("email", emailUser);
                map.put("password", passUser);

                firestore.collection("User").add(map).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        finish();
                        startActivity(new Intent(Register_Activity.this, Login_Activity.class));
                        Toast.makeText(Register_Activity.this, "Usuario registrado", Toast.LENGTH_SHORT).show();

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Register_Activity.this, "Error al guardar usuario", Toast.LENGTH_SHORT).show();

                    }
                });


            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Register_Activity.this, "Error al registrar", Toast.LENGTH_SHORT).show();
            }
        });
    }

}