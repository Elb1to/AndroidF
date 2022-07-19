package gg.rubit.Activitys.Lecciones;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import gg.rubit.R;


public class IngActivity extends AppCompatActivity {
        private Button video, chat;
        private ImageButton back;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_ing);


            InicializarControles();
            video.setOnClickListener(Dv -> {
                Intent VideoI = new Intent(IngActivity.this, VideoLecturaActivity.class);
                startActivity(VideoI);
            });
            chat.setOnClickListener(Dv2 -> Toast.makeText(this,
                    "deberia ir a la leccion cuento",
                    Toast.LENGTH_LONG).show());
            back.setOnClickListener(Iv3 -> {
                Intent Retorno1 = new Intent(IngActivity.this, LeccionActivity.class);
                startActivity(Retorno1);
            });

        }

        private void InicializarControles() {
            video = findViewById(R.id.video);
            chat = findViewById(R.id.chat);
            back = findViewById(R.id.back);
        }
    }