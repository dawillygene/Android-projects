package com.example.navigation_drawer;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;




public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.nav_open,R.string.nav_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout,new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);

        }

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId(); // Get the selected item's ID

        if (id == R.id.nav_home) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_layout, new HomeFragment())
                    .commit();
        } else if (id == R.id.nav_about) {

        } else if (id == R.id.nav_setting) {

        } else if (id == R.id.nav_exit) {
            Toast.makeText(this, "Logout", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "There is no action Here", Toast.LENGTH_LONG).show();
//            throw new IllegalStateException("Unexpected value: " + id);
        }

        // Close the navigation drawer after selection
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
   public void onBackPressed(){
     super.onBackPressed();

     if (drawerLayout.isDrawerOpen(GravityCompat.START)){
         drawerLayout.closeDrawer(GravityCompat.START);
     }
     else {
         super.onBackPressed();

     }

    }

}