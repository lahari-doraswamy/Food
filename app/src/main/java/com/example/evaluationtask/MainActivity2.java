package com.example.evaluationtask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity2 extends AppCompatActivity {

BottomNavigationView bottomNavigationView;
RemoteFragment remoteFragment=new RemoteFragment();
SavedFragment savedFragment= new SavedFragment();
    private Object Menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,remoteFragment).commit();
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected( MenuItem item) {
                switch (item.getItemId()){
                    case R.id.remote:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,remoteFragment).commit();
                        return true;
                    case R.id.saved:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,savedFragment).commit();
                        return true;
                }
                return false;

            }
        });

        }

}