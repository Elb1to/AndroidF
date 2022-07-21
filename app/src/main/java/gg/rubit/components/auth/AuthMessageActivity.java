package gg.rubit.components.auth;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.service.autofill.UserData;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import gg.rubit.adapters.TablaListViewAdapter;
import gg.rubit.api.ApiService;
import gg.rubit.api.request.RequestUser;
import gg.rubit.api.response.CVID_Tabla;
import gg.rubit.api.response.UserResponse;
import gg.rubit.data.User;
import gg.rubit.data.UserDataValues;
import gg.rubit.database.DatabaseManager;
import gg.rubit.ui.bar.navigation.NavigationBarUI;
import gg.rubit.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthMessageActivity extends AppCompatActivity {
    DatabaseManager database;
    //ImageView imgCargando;
    TextView txtNombre,txtCorreo;

    private String nombre,correo,userType;
    private int type;

    //Intent i;
    //AnimationDrawable animationDrawable;
    MediaPlayer click, music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensaje_login);

        User user = database.getUserSession();
        try {
            click.start();
            String user = userEmail.getText().toString();
            String pass = userPassword.getText().toString();

                Call<List<UserData>> response = ApiService.getApiService().getDataUser();
                response.enqueue(new Callback<List<UserData>>() {
                    @Override
                    public void onResponse(Call<List<UserData>> call, Response<List<UserData>> response) {
                        if (response.isSuccessful()){
                            List<UserData> table = response.body();
                            
                        }
                    }

                    @Override
                    public void onFailure(Call<List<UserData>> call, Throwable t) {

                    }
                });

        }

        nombre = user.getName();
        correo = user.getEmail();

        type = 3;

        //imgCargando = (ImageView)findViewById(R.id.imgCargando);
        //imgCargando.setBackgroundResource(R.drawable.cargando);

        //animationDrawable = (AnimationDrawable) imgCargando.getBackground();
       // animationDrawable.start();

        click = MediaPlayer.create(this, R.raw.click);
        music = MediaPlayer.create(this, R.raw.resum);

        initializeControllers();
    }

    public void onResume() {
        super.onResume();
        music.start();
    }

    public void initializeControllers() {
        if (type == 3) {
            userType = "Estudiante";
        }

        txtNombre = (TextView) findViewById(R.id.nombre);

        txtNombre.setText(userType + "\n" + nombre);
        txtCorreo.setText(correo);
        //imgCargando = (ImageView)findViewById(R.id.imgCargando);
        //imgCargando.setBackgroundResource(R.drawable.cargando);
    }

    public void Menu(View v) {
        click.start();
        startActivity(new Intent(getApplicationContext(), NavigationBarUI.class));
    }

    public void utpLogo(View view) {
        click.start();
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://utp.ac.pa/")));
    }

    public void fiscLogo(View view) {
        click.start();
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://fisc.utp.ac.pa/")));
    }

    @Override
    protected void onPause() {
        super.onPause();
        music.pause();
    }
}