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
    ImageView imgCargando;
    TextView txtNombre,txtApellido,txtCorreo,txtCedula;

    private String Nombre, Apellido,Correo,Cedula,userType;
    private int type;

    Intent i;
    //AnimationDrawable animationDrawable;
    MediaPlayer click, music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensaje_login);
        i = getIntent();
        Nombre = i.getStringExtra("Nombre");
        Apellido = i.getStringExtra("Apellido");
        Correo = i.getStringExtra("Correo");
        Cedula = i.getStringExtra("Cedula");

        imgCargando = (ImageView)findViewById(R.id.imgCargando);
        imgCargando.setBackgroundResource(R.drawable.cargando);


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
        txtCorreo = (TextView) findViewById(R.id.correo);
        txtCorreo = (TextView) findViewById(R.id.correo);

        txtNombre.setText(userType + "\n" + Nombre);
        txtCorreo.setText(Correo);
        txtCorreo.setText(Cedula);
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