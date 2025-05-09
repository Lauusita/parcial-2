package com.laura.parcial_2;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.laura.parcial_2.adaptadores.UsuarioAdaptador;
import com.laura.parcial_2.clases.Usuario;
import com.laura.parcial_2.fragment.HomeFragment;
import com.laura.parcial_2.fragment.ProfileFragment;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView nav_options;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nav_options = findViewById(R.id.nav_options);

        loadFragment(new HomeFragment());
        nav_options.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                boolean state = false;

                int itemId = item.getItemId();

                if (itemId == R.id.btn_home) {
                    fragment = new HomeFragment();
                } else if ( itemId == R.id.btn_pfp ) {
                    fragment = new ProfileFragment();
                }

                if (fragment != null) {
                    loadFragment(fragment);
                    state = true;
                }

                return state;
            }
        });
    }

    public void loadFragment(Fragment selectedFragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, selectedFragment)
                .commit();
    }
}