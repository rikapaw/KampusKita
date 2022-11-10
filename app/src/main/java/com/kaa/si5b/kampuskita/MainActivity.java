package com.kaa.si5b.kampuskita;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bnvKampusKita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bnvKampusKita = findViewById(R.id.bnv_kampus_kita);

        bukaFragmen(new HomeFragment());
        getSupportActionBar().setTitle("Home");

        bnvKampusKita.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                case R.id.menu_home:
                    bukaFragmen(new HomeFragment());
                    getSupportActionBar().setTitle("Home");
                return true;
                case R.id.menu_jadwal:
                    bukaFragmen(new JadwalFragment());
                    getSupportActionBar().setTitle("Jadwal");
                return true;
                case R.id.menu_nilai:
                    bukaFragmen(new NilaiFragment());
                    getSupportActionBar().setTitle("Nilai");
                return true;

            }
        });
    }

    private void  bukaFragmen(Fragment varFragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fl_container, varFragment);
        ft.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_atas, menu);
        return super.onCreateOptionsMenu(menu);
    }
}