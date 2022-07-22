package gg.rubit.components.puntos;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

import gg.rubit.R;
import gg.rubit.adapters.ResumenListViewAdapter;
import gg.rubit.api.ApiService;
import gg.rubit.api.request.PartidaRequest;
import gg.rubit.api.request.RequestGame;
import gg.rubit.api.response.Partida;
import gg.rubit.database.DatabaseManager;
import gg.rubit.ui.bar.navigation.NavigationBarUI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PuntosActivity extends AppCompatActivity {

    TextView puntaje;
    

    MediaPlayer click, music;

    Intent i;
    int puntos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntaje);
        InicializarControles();
        MapearCampos();

        click = MediaPlayer.create(this, R.raw.click);
        music = MediaPlayer.create(this, R.raw.resum);
        music.start();
    }

    private void MapearCampos() {
        i = getIntent();
        puntos = i.getIntExtra("puntaje", 0);
        puntaje.setText(Integer.toString(puntos));
    }

    private void InicializarControles(){
        puntaje = (TextView)findViewById(R.id.txtPuntos);
    }

    @Override
    protected void onPause(){
        super.onPause();
        music.pause();
    }
}