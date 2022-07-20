package gg.rubit.games.wordpicker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import gg.rubit.R;

public class WordPickerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_juego3);
    }

    public void play(View view) {
        startActivity(new Intent(this, WordPickerGame.class));
    }
}
