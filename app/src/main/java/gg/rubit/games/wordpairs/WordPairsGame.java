package gg.rubit.games.wordpairs;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import gg.rubit.R;
//import gg.rubit.adapters.WordPairsAdapter;
import gg.rubit.api.ApiService;
import gg.rubit.api.response.PairsResponse;
//import gg.rubit.data.Pairs;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/*public class WordPairsGame extends AppCompatActivity {

    private ListView lstPareo;
    private ListView lstPareo2;
    private Button btnpareo;
    private TextView lblPareo1, lblPareo2;
    private int idPareo1, idPareo2, avance = 0, idPreguntaPareo;
    private String opcPareo1, opcPareo2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pareo);
        initializeControllers();
    }

    private void loadDatabaseTable() {
        Call<List<PairsResponse>> llamadoPareo = ApiService.getApiService().getPairsList();
        llamadoPareo.enqueue(new Callback<List<PairsResponse>>() {
            @Override
            public void onResponse(Call<List<PairsResponse>> call, Response<List<PairsResponse>> response) {
                List<PairsResponse> listaProductos = response.body();
                for (PairsResponse PareoB : listaProductos) {
                    Pairs pairs = new Pairs(
                            PareoB.getQuestionId(),
                            PareoB.getAnswerId(),
                            PareoB.getPairsOrder(),
                            PareoB.getQuestion(),
                            PareoB.getAnswer()
                    );

                    pairs.insertPairsGame(getApplicationContext());
                }
            }

            @Override
            public void onFailure(Call<List<PairsResponse>> call, Throwable t) {
                int x = 1;
            }
        });
    }

    private void initializeControllers() {
        lstPareo = findViewById(R.id.lstPareo1);
        lstPareo2 = findViewById(R.id.lstPareo2);
        btnpareo = findViewById(R.id.btnPareo);

        loadListView();
        loadListViewAlt();
        AttachEvent();
    }

    private void loadListView() {
        List<Pairs> pairs = new Pairs().getPair(32, getApplicationContext());
        List<Pairs> pairsArrayList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            pairsArrayList.add(pairs.get(i));
        }

        Collections.shuffle(pairsArrayList);
        WordPairsAdapter adapter = new WordPairsAdapter(getApplicationContext(), pairsArrayList);
        lstPareo.setAdapter(adapter);
    }

    private void loadListViewAlt() {
        List<Pairs> pairs = new Pairs().getPair(32, getApplicationContext());
        List<Pairs> pairsArrayList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            pairsArrayList.add(pairs.get(i));
        }

        Collections.shuffle(pairsArrayList);
        WordPairsAdapter adapter = new WordPairsAdapter(getApplicationContext(), pairsArrayList);
        lstPareo2.setAdapter(adapter);
    }

    private void AttachEvent() {
        Pairs pairs = new Pairs();
        lstPareo.setOnItemClickListener((adapterView, view, i, l) -> {
            if (lblPareo1 != null) {
                lblPareo1.setBackgroundResource(R.drawable.jugabilidad);
            }

            TextView estate = view.findViewById(R.id.lblPareoTemplate);
            if (estate.isEnabled() != false) {
                lstPareo.getChildAt(i).setEnabled(false);

                view.findViewById(R.id.lblPareoTemplate).setBackgroundResource(R.drawable.seleccion);
                lblPareo1 = view.findViewById(R.id.lblPareoTemplate);

                TextView a = view.findViewById(R.id.lblPareores);
                String res = a.getText().toString();
                TextView txt = view.findViewById(R.id.lblPareoTemplate);

                opcPareo1 = txt.getText().toString();
                idPareo1 = pairs.getPairsGameId(opcPareo1, getApplicationContext());
                compararPreguntas(idPareo1, idPareo2);
            }
        });

        lstPareo2.setOnItemClickListener((adapterView, view, i, l) -> {
            if (lblPareo2 != null) {
                lblPareo2.setBackgroundResource(R.drawable.jugabilidad);
            }

            TextView estate = view.findViewById(R.id.lblPareoTemplate);
            if (estate.isEnabled() != false) {
                view.findViewById(R.id.lblPareoTemplate).setBackgroundResource(R.drawable.seleccion);
                lblPareo2 = view.findViewById(R.id.lblPareoTemplate);
                TextView a = view.findViewById(R.id.lblPareores);
                String res = a.getText().toString();

                TextView txt = view.findViewById(R.id.lblPareoTemplate);
                opcPareo2 = txt.getText().toString();
                idPareo2 = pairs.getPairsGameId(opcPareo2, getApplicationContext());
                compararPreguntas(idPareo1, idPareo2);
            }
        });
    }

    private void compararPreguntas(int p1, int p2) {
        if (opcPareo1 != null && opcPareo2 != null) {
            if (p1 == p2) {
                lblPareo1.setBackgroundResource(R.drawable.correcto);
                lblPareo2.setBackgroundResource(R.drawable.correcto);
                opcPareo1 = null;
                opcPareo2 = null;
                avance = avance + 1;
                if (avance == 5) {
                    btnpareo.setEnabled(true);
                }

                TimerTask timerTask = new TimerTask() {
                    @Override
                    public void run() {
                        lblPareo1.setEnabled(false);
                        lblPareo2.setEnabled(false);
                        lblPareo1 = null;
                        lblPareo2 = null;
                    }
                };

                Timer time = new Timer();
                time.schedule(timerTask, 250);
            } else {
                lblPareo2.setBackgroundResource(R.drawable.incorrecta);
                lblPareo1.setBackgroundResource(R.drawable.incorrecta);
                opcPareo1 = null;
                opcPareo2 = null;

                TimerTask timerTask = new TimerTask() {
                    @Override
                    public void run() {
                        lblPareo1.setBackgroundResource(R.drawable.jugabilidad);
                        lblPareo2.setBackgroundResource(R.drawable.jugabilidad);
                        lblPareo1 = null;
                        lblPareo2 = null;
                    }
                };

                Timer time = new Timer();
                time.schedule(timerTask, 250);
            }
        }
    } */

