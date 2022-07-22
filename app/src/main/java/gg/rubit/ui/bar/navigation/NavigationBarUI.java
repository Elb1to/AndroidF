package gg.rubit.ui.bar.navigation;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

import gg.rubit.R;
import gg.rubit.api.ApiService;
import gg.rubit.api.response.UserResponse;
import gg.rubit.components.auth.AuthMessageActivity;
import gg.rubit.components.help.HelpActivity;
import gg.rubit.components.lessons.LessonActivity;
import gg.rubit.components.ranking.RankingActivity;
import gg.rubit.components.ranking.RankingFragment;
import gg.rubit.games.wordpicker.WordPickerGameActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NavigationBarUI extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    Intent i;
    String firstName, lastName, email, cedula;
    int userId;

    HelpActivity ayudaFragment = new HelpActivity();
    RankingFragment rankingFragment = new RankingFragment();

    @SuppressLint("NonConstantResourceId") @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_bar);

        i = getIntent();
        userId = i.getIntExtra("UserId", 0);
        firstName = i.getStringExtra("Nombre");
        lastName = i.getStringExtra("Apellido");
        email = i.getStringExtra("Correo");
        cedula = i.getStringExtra("Cedula");

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, rankingFragment).commit();

        BadgeDrawable badgeDrawable = bottomNavigationView.getOrCreateBadge(R.id.ranking);
        badgeDrawable.setVisible(true);
        badgeDrawable.setNumber(8);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.lecciones:
                    startActivity(new Intent(getApplicationContext(), LessonActivity.class));
                    return true;
                case R.id.ranking:
                    startActivity(new Intent(getApplicationContext(), RankingActivity.class));
                    return true;
                case R.id.perfil:
                    Intent i = new Intent(getApplicationContext(), AuthMessageActivity.class);
                    i.putExtra("Nombre", firstName);
                    i.putExtra("Apellido", lastName);
                    i.putExtra("Cedula", email);
                    i.putExtra("Correo", cedula);

                    startActivity(i);
                    return true;
                case R.id.jugar:
                    Toast.makeText(getApplicationContext(), "Clicked play button", Toast.LENGTH_SHORT).show();
                     try {
                        Call<UserResponse> response = ApiService.getApiService().getUserDataById(userId);
                        response.enqueue(new Callback<UserResponse>() {
                            @Override
                            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                                if (response.isSuccessful()) {
                                    UserResponse jugador = response.body();
                                    if (jugador != null) {
                                        Intent i = new Intent(getApplicationContext(), WordPickerGameActivity.class);
                                        i.putExtra("UserId", userId);
                                        i.putExtra("Puntaje", jugador.getPuntajeac());

                                        startActivity(i);
                                    }
                                } else {
                                    Toast.makeText(getApplicationContext(), "Couldn't fetch UserResponse values", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<UserResponse> call, Throwable t) {
                                Toast.makeText(getApplicationContext(), "Couldn't fetch UserResponse values", Toast.LENGTH_SHORT).show();
                            }
                        });
                    } catch (Exception ignored) {
                    }

                    return true;
                case R.id.ayuda:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, ayudaFragment).commit();
                    return true;
            }

            return false;
        });
    }
}