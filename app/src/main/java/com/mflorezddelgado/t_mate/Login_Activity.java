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
import com.google.android.gms.tasks.Task;
import com.google.firebase.Firebase;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login_Activity extends AppCompatActivity {

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button Login = findViewById(R.id.btn_loginM);
        ImageButton Lback = findViewById(R.id.btn_backr);

        EditText log_email = findViewById(R.id.et_email);
        EditText log_passw = findViewById(R.id.et_password);
        mAuth = FirebaseAuth.getInstance();

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login_Activity.this, TeamViewCoach.class);
                startActivity(intent);

                String emailUser = log_email.getText().toString().trim();
                String passUser = log_passw.getText().toString().trim();


                if (emailUser.isEmpty() && passUser.isEmpty()){
                    Toast.makeText(Login_Activity.this, "Debe completar todos los datos.", Toast.LENGTH_SHORT).show();
                }else{
                    loginUser(emailUser, passUser);

                }

            }
        });

        Lback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent log = new Intent(Login_Activity.this,Main_Activity.class);
                startActivity(log);
            }
        });
    }

    private void loginUser(String emailUser, String passUser){
        mAuth.signInWithEmailAndPassword(emailUser, passUser).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    finish();
                    startActivity(new Intent(Login_Activity.this, TeamsViewPlayer.class));
                    Toast.makeText(Login_Activity.this, "Bienvenido", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Login_Activity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Login_Activity.this, "Error al iniciar sesión", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null){
            startActivity(new Intent(Login_Activity.this, TeamsViewPlayer.class));
            finish();
        }
    }
}