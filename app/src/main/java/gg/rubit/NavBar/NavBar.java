package gg.rubit.NavBar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import gg.rubit.R;
import gg.rubit.components.Ayuda.AyudaActivity;
import gg.rubit.components.Jugar.JugarActivity;
import gg.rubit.components.Ranking.RankingActivity;
import gg.rubit.components.auth.PerfilFragment;
import gg.rubit.components.lessons.LeccionesFragment;

public class NavBar extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    RankingActivity rankingFragment = new RankingActivity();
    JugarActivity jugarFragment = new JugarActivity();
    AyudaActivity ayudaFragment = new AyudaActivity();
    PerfilFragment perfilFragment = new PerfilFragment();
    LeccionesFragment leccionesFragment = new LeccionesFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_bar);

        bottomNavigationView  = findViewById(R.id.bottom_navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.container,rankingFragment).commit();

        BadgeDrawable badgeDrawable = bottomNavigationView.getOrCreateBadge(R.id.ranking);
        badgeDrawable.setVisible(true);
        badgeDrawable.setNumber(8);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.lecciones:
                        //startActivity(new Intent(getApplicationContext(), LessonActivity.class));
                        return true;
                    case R.id.ranking:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,rankingFragment).commit();
                        return true;
                    case R.id.perfil:
                        //startActivity(new Intent(getApplicationContext(), AuthMessageActivity.class));
                        return true;
                    case R.id.jugar:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,jugarFragment).commit();
                        return true;
                    case R.id.ayuda:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,ayudaFragment).commit();
                        return true;
                }

                return false;
            }
        });

    }
}