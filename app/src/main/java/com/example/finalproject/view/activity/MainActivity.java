package com.example.finalproject.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.finalproject.R;
import com.example.finalproject.view.fragment.AddQuoteFragment;
import com.example.finalproject.view.fragment.FavQsFragment;
import com.example.finalproject.view.fragment.ProfileFragment;
import com.example.finalproject.view.fragment.QuoteFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView bottomNavigationView;
//    private Fragment selectedFragment = new FavQsFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNav);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        loadFragment(new FavQsFragment());
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_favqs:
                //selectedFragment = new FavQsFragment();
                loadFragment(new FavQsFragment());
                break;
            case R.id.menu_add:
                //selectedFragment = new AddQuoteFragment();
                loadFragment(new AddQuoteFragment());
                break;
            case R.id.menu_profile:
                loadFragment(new ProfileFragment());
                break;
        }
        return true;
    }

    private boolean loadFragment(Fragment selectedFragment) {
        if(selectedFragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_main,selectedFragment)
                    .commit();
            return true;
        }
        else {
            return false;
        }
    }
}