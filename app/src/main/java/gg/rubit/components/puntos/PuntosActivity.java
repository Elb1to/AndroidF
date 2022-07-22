package gg.rubit.components.puntos;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
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
import gg.rubit.api.request.RequestGame;
import gg.rubit.api.response.Partida;
import gg.rubit.database.DatabaseManager;
import gg.rubit.ui.bar.navigation.NavigationBarUI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PuntosActivity extends AppCompatActivity {

<<<<<<< Updated upstream
    ListView lstResumen;
    TextView jugador, puntaje;

    List<Partida> partidas = new ArrayList<>();
=======
    TextView puntaje;
>>>>>>> Stashed changes

    MediaPlayer click, music;

    Intent i;
    int puntos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< Updated upstream
        setContentView(R.layout.activity_resumen);

        int partida = getIntent().getIntExtra("Partida", 0);

        initializeControllers();
        loadListView(partida);
        mapValues();
        saveMatchToApi(partidas);

        i = getIntent();
        puntos = i.getIntExtra("Puntaje", 0);
=======
        setContentView(R.layout.activity_puntaje);
        InicializarControles();
        MapearCampos();
>>>>>>> Stashed changes

        click = MediaPlayer.create(this, R.raw.click);
        music = MediaPlayer.create(this, R.raw.resum);
        music.start();
    }

<<<<<<< Updated upstream
    private void saveMatchToApi(List<Partida> partidas) {
        RequestGame request = new RequestGame();
        /*id_usuarios,id_pregunta,Correcto,Puntaje*/
        request.setNombre(partidas.get(0).getJugador());
        request.setPuntaje(getScore(partidas));
        request.setDetalle(partidas);

        Call<Integer> response = ApiService.getApiService().postRegistrarPartida(request);
        response.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                if (response.isSuccessful()) {
                    int registrado = response.body();
                    if (registrado > 0) {

                    }
                } else {
                    int x = 1;
                }
            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {
                int x = 1;
            }
        });
    }

    public void getGames(View v) {
        click.start();
        Intent i = new Intent(getApplicationContext(), NavigationBarUI.class);
        i.putExtra("Puntaje", puntos);
        startActivity(i);
    }

    @SuppressLint("SetTextI18n")
    private void mapValues() {
        jugador.setText(partidas.get(0).getJugador());
        puntaje.setText(Integer.toString(getScore(partidas)));
    }

    private int getScore(List<Partida> partidas) {
        int puntaje = 0;
        for (Partida part : partidas) {
            puntaje = puntaje + part.getPuntaje();
        }

        return puntaje;
    }

    private void loadListView(int partida) {
        DatabaseManager db = new DatabaseManager(getApplicationContext());
        partidas = db.ObtenerPartidaById(partida);

        ResumenListViewAdapter adapter = new ResumenListViewAdapter(getApplicationContext(), partidas);
        lstResumen.setAdapter(adapter);
    }

    private void initializeControllers() {
        jugador = findViewById(R.id.txtJugador);
        puntaje = findViewById(R.id.txtPuntos);
=======
    private void MapearCampos() {
        i = getIntent();
        puntos = i.getIntExtra("puntaje", 0);
        puntaje.setText(Integer.toString(puntos));
    }

    private void InicializarControles(){
        puntaje = (TextView)findViewById(R.id.txtPuntos);
>>>>>>> Stashed changes
    }

    @Override
    protected void onPause() {
        super.onPause();
        music.pause();
    }
}