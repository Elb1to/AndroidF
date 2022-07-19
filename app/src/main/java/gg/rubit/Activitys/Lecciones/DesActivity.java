package gg.rubit.Activitys.Lecciones;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import gg.rubit.R;

public class DesActivity extends AppCompatActivity {
    private Button video,chat;
    private ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_des);


        InicializarControles();

        video.setOnClickListener(Dv -> {
            Intent VideoD= new Intent(DesActivity.this, VideoLecturaActivity.class);
            startActivity(VideoD);
        });
        chat.setOnClickListener(Dv2 -> Toast.makeText(this,
                "deberia ir a la leccion cuento",
                Toast.LENGTH_LONG).show());
        back.setOnClickListener(Dv3 -> {
            Intent Retorno2 = new Intent(DesActivity.this, LeccionActivity.class);
            startActivity(Retorno2);
        });
    }



    private void InicializarControles() {
        video = findViewById(R.id.Dleccion1);
        chat = findViewById(R.id.Dleccion2);
        back = findViewById(R.id.back);
    }

}