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
import gg.rubit.api.request.RequestGame;
import gg.rubit.api.response.Partida;
import gg.rubit.database.DatabaseManager;
import gg.rubit.ui.bar.navigation.NavigationBarUI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PuntosActivity extends AppCompatActivity {

    ListView lstResumen;
    TextView jugador,puntaje;

    List<Partida> _partidas = new ArrayList<>();

    MediaPlayer click, music;

    Intent i;
    int Tipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen);

        int partida = getIntent().getIntExtra("Partida",0);

        InicializarControles();
        LoadListView(partida);
        MapearCampos();
        GuardarPartidaApi(_partidas);

        i = getIntent();
        Tipo = i.getIntExtra("Tipaje", 0);

        click = MediaPlayer.create(this, R.raw.click);

        music = MediaPlayer.create(this, R.raw.resum);
        music.start();
    }

    private void GuardarPartidaApi(List<Partida> partidas) {
        RequestGame request = new RequestGame();
        /*ID_Usuario,ID_Pregunta,Correcto,Puntaje*/
        request.setNombre(partidas.get(0).getJugador());
        request.setPuntaje(ObtenerPuntaje(partidas));
        request.setDetalle(partidas);

        if(Tipo==3) {

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

    }

    public void RegresarJuegos(View v){
        click.start();
        Intent i = new Intent(getApplicationContext(), NavigationBarUI.class);
        i.putExtra("Tipaje", Tipo);
        startActivity(i);
    }

    private void MapearCampos() {
        jugador.setText(_partidas.get(0).getJugador());
        puntaje.setText(Integer.toString(ObtenerPuntaje(_partidas)));
    }

    private int ObtenerPuntaje(List<Partida> partidas){
        int puntaje = 0;
        for (Partida part : partidas){
            puntaje = puntaje + part.getPuntaje();
        }

        return puntaje;
    }

    private void LoadListView(int partida) {
        DatabaseManager db = new DatabaseManager(getApplicationContext());

        _partidas = db.ObtenerPartidaById(partida);

        ResumenListViewAdapter adapter =
                new ResumenListViewAdapter(getApplicationContext(),_partidas);

        lstResumen.setAdapter(adapter);
    }

    private void InicializarControles(){
        jugador = (TextView)findViewById(R.id.txtJugador);
        puntaje = (TextView)findViewById(R.id.txtPuntos);
    }

    @Override
    protected void onPause(){
        super.onPause();
        music.pause();
    }
}