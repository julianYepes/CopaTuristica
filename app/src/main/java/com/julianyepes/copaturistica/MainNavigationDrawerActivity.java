package com.julianyepes.copaturistica;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainNavigationDrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    String user,email;

    FragmentManager fm;
    FragmentTransaction ft;
    TextView tmUsername;
    TextView tmEmail;

    SharedPreferences prefs;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_navigation_drawer);

        prefs = getSharedPreferences("MisPreferencias",MODE_PRIVATE);
        editor = prefs.edit();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View heder = navigationView.getHeaderView(0);

        Bundle extras=getIntent().getExtras();
        user = extras.getString("username");
        email = extras.getString("email");

        tmUsername = (TextView) heder.findViewById(R.id.tmUsername);
        tmUsername.setText(user);
        tmEmail = (TextView) heder.findViewById(R.id.tmEmail);
        tmEmail.setText(email);

        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();

        switch ( extras.getString("fragment") ){
            case "listView":
                this.setTitle("Inicio");
                listaFragment fragment =  new listaFragment();
                ft.replace(R.id.contenedorfrag, fragment).commit();
                break;
            case "Info del Municipio":
                this.setTitle("Informacion del Municipio");
                InfoFragment fragment2 =  new InfoFragment();
                ft.replace(R.id.contenedorfrag, fragment2).commit();
                break;
            case "Simbolos":
                this.setTitle("Simbolos");
                SimbolosFragment fragment3 =  new SimbolosFragment();
                ft.replace(R.id.contenedorfrag, fragment3).commit();
                break;
            case "Fiestas":
                this.setTitle("Fiestas");
                FiestasFragment fragment4 =  new FiestasFragment();
                ft.replace(R.id.contenedorfrag, fragment4).commit();
                break;
            case "Ver Mapa":
                this.setTitle("Mapa");
                MapaFragment fragment5 =  new MapaFragment();
                ft.replace(R.id.contenedorfrag, fragment5).commit();
                break;
            case "perfil":
                this.setTitle("Perfil");
                perfilFragment fragment6 = perfilFragment.newInstance(email,user);
                ft.replace(R.id.contenedorfrag, fragment6).commit();
                break;
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Intent intent = new Intent(MainNavigationDrawerActivity.this,TabsNavigationDrawerActivity.class);

        if (id == R.id.nav_main) {
            Intent intent2 = new Intent(MainNavigationDrawerActivity.this,MainNavigationDrawerActivity.class);
            intent2.putExtra("places","Bares");
            intent2.putExtra("username",user);
            intent2.putExtra("email",email);
            intent2.putExtra("fragment","listView");
            startActivity(intent2);
        }else if (id == R.id.nav_bares) {
            intent.putExtra("places","Bares");
            intent.putExtra("username",user);
            intent.putExtra("email",email);
            startActivity(intent);
        } else if (id == R.id.nav_deportes) {
            intent.putExtra("places","Deporte");
            intent.putExtra("username",user);
            intent.putExtra("email",email);
            startActivity(intent);
        } else if (id == R.id.nav_sitios) {
            intent.putExtra("places","SiteTour");
            intent.putExtra("username",user);
            intent.putExtra("email",email);
            startActivity(intent);
        } else if (id == R.id.nav_perfil) {
            Intent intent3 = new Intent(MainNavigationDrawerActivity.this,MainNavigationDrawerActivity.class);
            intent3.putExtra("username",user);
            intent3.putExtra("email",email);
            intent3.putExtra("fragment","perfil");
            startActivity(intent3);
        } else if (id == R.id.nav_salir) {
            editor.putInt("login",-1);
            editor.commit();
            Intent intent4 = new Intent(MainNavigationDrawerActivity.this,LoginActivity.class);
            startActivity(intent4);
            finish();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
