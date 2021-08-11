package com.example.cs2410_finalproject_sudokuapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        MaterialToolbar topAppBar = findViewById(R.id.top_app_bar);

        NavigationView navView = findViewById(R.id.navigation_view);
        View headerView = navView.getHeaderView(0);
        TextView menuHeaderTextView = headerView.findViewById(R.id.menu_header);

        topAppBar.setNavigationOnClickListener(view -> {
            drawerLayout.open();
        });

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragment_container, NewGameFragment.class, null)
                    .commit();

            Log.d("fragment setting", "setting fragment to new game on opening");
        }

        navView.setNavigationItemSelectedListener(menuItem -> {
            menuItem.setChecked(true);

            if (menuItem.getItemId() == R.id.new_game_item) {
                // navigate to new game screen
                Log.d("Switching Fragments", "Switching to new courses fragment");
                getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.fragment_container, NewGameFragment.class, null)
                        .addToBackStack(null)
                        .commit();
            }
            if (menuItem.getItemId() == R.id.best_times_item) {
                // navigate to best times fragment
                Log.d("Switching Fragments", "Switching to best times fragment");
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, BestTimesFragment.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack(null)
                        .commit();

            }
            if (menuItem.getItemId() == R.id.settings_item) {
                // navigate to settings fragment
                Log.d("Switching Fragments", "Switching to settings fragment");
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, SettingsFragment.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack(null)
                        .commit();
            }

            drawerLayout.close();
            return true;
        });
    }
}