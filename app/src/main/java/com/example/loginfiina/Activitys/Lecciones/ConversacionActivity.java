package com.example.loginfiina.Activitys.Lecciones;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.loginfiina.Adaptadores.ConversacionListViewAdapter;
import com.example.loginfiina.Entidades.DatosConversacion;
import com.example.loginfiina.Procesos.ResponseEventHandler;
import com.example.loginfiina.R;
import com.example.loginfiina.Services.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ConversacionActivity extends AppCompatActivity {

    ListView lstConversacion;
    ConversacionListViewAdapter adapter;
    ResponseEventHandler responseEventHandler = new ResponseEventHandler();
    int size=0, count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversacion);

        startUI();

        ObtenerDialogos();

    }

    private void startUI() {
        lstConversacion = (ListView) findViewById(R.id.lstChats);
    }

    public void ActualizarDatoslst() {

        lstConversacion.setAdapter(adapter);
    }

    private void AttachEvents(){
        lstConversacion.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String Audio =  ((TextView)view.findViewById(R.id.lblaudio)).getText().toString();
                responseEventHandler.playMp3(Audio);
            }
        });
    }

    public void ObtenerDialogos() {

        Call<List<DatosConversacion>> call = ApiService.getApiService().getLisTDialogs();

        call.enqueue(new Callback<List<DatosConversacion>>() {
            @Override
            public void onResponse(Call<List<DatosConversacion>> call, Response<List<DatosConversacion>> response) {

                if(response.isSuccessful()) {
                    responseEventHandler.setContext(getApplicationContext());
                    size = responseEventHandler.responseReceived(response.body());

                    if(size<1) {
                        Toast.makeText(getApplicationContext(), "No se encontraron mensajes de la leccion", Toast.LENGTH_LONG).show();
                    }
                    else {
                        adapter = new ConversacionListViewAdapter(getApplicationContext(),responseEventHandler.datos(count));
                        AttachEvents();
                        ActualizarDatoslst();
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), "Fallo de api", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<DatosConversacion>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Fallo de red", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void AvanzarCuento(View v) {

        if(count + 1 < size) {
            count = count + 1;
            responseEventHandler.datos(count);
            ActualizarDatoslst();
        }
        else {
            Toast.makeText(this, "Se ha terminado la lección", Toast.LENGTH_LONG).show();
        }

    }

    /*public void IrAlInicio(View v) {
        startActivity(new Intent(getApplicationContext(), CrearDatos.class));
    }*/

}