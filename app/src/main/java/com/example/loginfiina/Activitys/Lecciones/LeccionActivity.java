package com.example.loginfiina.Activitys.Lecciones;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.loginfiina.R;

public class LeccionActivity extends AppCompatActivity {
    private Button btning,btndes;
    private ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leccion);



        btning.setOnClickListener(v -> {
            Intent paraIng =new Intent(LeccionActivity.this, IngActivity.class);
            startActivity(paraIng);
        });
        btndes.setOnClickListener(v2 -> {
            Intent paraDes = new Intent(LeccionActivity.this, DesActivity.class);
            startActivity(paraDes);
        });
        back.setOnClickListener(v3 -> Toast.makeText(this,
                "deberia ir a un menu plz",
                Toast.LENGTH_LONG).show());

    }




}