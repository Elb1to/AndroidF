package gg.rubit.ui.bar.navigation;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import gg.rubit.R;
import gg.rubit.components.auth.AuthMessageActivity;
import gg.rubit.components.conversation.SelectConversation;
import gg.rubit.components.help.HelpActivity;
import gg.rubit.components.ranking.RankingActivity;
import gg.rubit.components.ranking.RankingFragment;
import gg.rubit.games.wordpicker.WordPickerGameActivity;

public class NavigationBarUI extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    private String firstName, lastName, email, cedula;
    private int userId;

    HelpActivity ayudaFragment = new HelpActivity();
    RankingFragment rankingFragment = new RankingFragment();
    Intent i;

    @SuppressLint("NonConstantResourceId")
    @Override
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
                    startActivity(new Intent(getApplicationContext(), SelectConversation.class));
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
                    Intent gameIntent = new Intent(getApplicationContext(), WordPickerGameActivity.class);
                    //gameIntent.putExtra("UserId", userId);
                    startActivity(gameIntent);
                    return true;
                case R.id.ayuda:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, ayudaFragment).commit();
                    return true;
            }

            return false;
        });
    }
}