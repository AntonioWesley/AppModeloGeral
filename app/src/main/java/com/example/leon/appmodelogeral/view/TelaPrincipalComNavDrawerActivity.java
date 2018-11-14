package com.example.leon.appmodelogeral.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.leon.appmodelogeral.R;
import com.example.leon.appmodelogeral.constantes.ConstantesDoApp;

public class TelaPrincipalComNavDrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal_com_nav_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // chamada do método para mudar o fragment atual para o home ao abrir a activity
        this.mudarFragment(ConstantesDoApp.HOME);
    }

    private void mudarFragment(String fragmentAtual) {
       if(fragmentAtual.equalsIgnoreCase(ConstantesDoApp.HOME)) {
           HomeFragment fragmentHome = new HomeFragment();
           getSupportFragmentManager().beginTransaction().replace(R.id.content_fragment, fragmentHome).commit();

       }else if (fragmentAtual.equalsIgnoreCase(ConstantesDoApp.SEGUNDOFRAGMENT)){
           SegundoFragment fragment2 = new SegundoFragment();
           getSupportFragmentManager().beginTransaction().replace(R.id.content_fragment, fragment2).commit();
       }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tela_principal_com_nav_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.action_logout) {
            startActivity(new Intent(this,LoginActivity.class));
            finishAffinity();
            return true;
        }else  if (id == R.id.action_sobre) {
            startActivity(new Intent(this,TelaSobreActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            this.mudarFragment(ConstantesDoApp.HOME);
        }  else if (id == R.id.nav_manage) {
            this.mudarFragment(ConstantesDoApp.SEGUNDOFRAGMENT);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
