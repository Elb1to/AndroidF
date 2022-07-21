package gg.rubit.components.lessons;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import gg.rubit.R;

public class EngineeringActivity extends AppCompatActivity {

    private Button video, chat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ing);

        initializeControllers();

        chat.setOnClickListener(view -> {
            startActivity(new Intent(EngineeringActivity.this, VideoLessonActivity.class));
        });

        video.setOnClickListener(view -> {
            startActivity(new Intent(EngineeringActivity.this, ConversationActivity.class));
        });
    }

    private void initializeControllers() {
        video = findViewById(R.id.video);
        chat = findViewById(R.id.chat);
    }
}