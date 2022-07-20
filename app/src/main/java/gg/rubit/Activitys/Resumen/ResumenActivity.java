package gg.rubit.Activitys.Resumen;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import gg.rubit.database.DatabaseManager;
import gg.rubit.Entidades.Partida;
import gg.rubit.R;
import gg.rubit.api.ApiService;
import gg.rubit.api.request.RequestGame;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResumenActivity extends AppCompatActivity {

    TextView player, score;

    List<Partida> games = new ArrayList<>();
    MediaPlayer click, music;

    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen);

        int game = getIntent().getIntExtra("Partida", 0);
        loadViewByGameId(game);
        initializeControllers();
        assignValues();
        saveGameToApi(games);

        i = getIntent();

        click = MediaPlayer.create(this, R.raw.click);
        music = MediaPlayer.create(this, R.raw.resum);
        music.start();
    }

    private void saveGameToApi(List<Partida> partidas) {
        RequestGame request = new RequestGame();
        request.setNombre(partidas.get(0).getJugador());
        request.setPuntaje(getScore(partidas));

        Call<Integer> response = ApiService.getApiService().postRegistrarPartida(request);
        response.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                if (response.isSuccessful()) {
                    int registered = response.body();
                    if (registered > 0) {

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
        //Intent i = new Intent(getApplicationContext(), MenuLoginActivity.class);
        startActivity(i);
    }

    @SuppressLint("SetTextI18n")
    private void assignValues() {
        player.setText(games.get(0).getJugador());
        score.setText(Integer.toString(getScore(games)));
    }

    private int getScore(List<Partida> partidas) {
        int puntaje = 0;
        for (Partida part : partidas) {
            puntaje = puntaje + part.getPuntaje();
        }

        return puntaje;
    }

    private void loadViewByGameId(int partida) {
        DatabaseManager db = new DatabaseManager(getApplicationContext());
        games = db.getGameById(partida);
    }

    private void initializeControllers() {
        player = (TextView) findViewById(R.id.txtJugador);
        score = (TextView) findViewById(R.id.txtPuntos);
    }

    @Override
    protected void onPause() {
        super.onPause();
        music.pause();
    }
}