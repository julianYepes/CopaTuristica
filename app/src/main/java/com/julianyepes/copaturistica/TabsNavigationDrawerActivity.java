package com.julianyepes.copaturistica;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import static com.julianyepes.copaturistica.R.id.container;

public class TabsNavigationDrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //////////////////////////////////////
    private TabsNavigationDrawerActivity.SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;
    String places;

    TextView tfPlace;

    String titleTab1,titleTab2,titleTab3;
    String user,email;
    ///////////////////////////////////////
    TextView ttUsername;
    TextView ttEmail;

    SharedPreferences prefs;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //////////////////////////////////////
        Bundle extras=getIntent().getExtras();
        places = extras.getString("places");
        user=extras.getString("username");
        email=extras.getString("email");

        switch ( places ){
            case "Deporte":
                this.setTitle("Deportes");
                titleTab1 = getResources().getString(R.string.deporte1);
                titleTab2 = getResources().getString(R.string.deporte2);
                titleTab3 = getResources().getString(R.string.deporte3);
                break;
            case "Bares":
                this.setTitle("Bares");
                titleTab1 = getResources().getString(R.string.bar1);
                titleTab2 = getResources().getString(R.string.bar2);
                titleTab3 = getResources().getString(R.string.bar3);
                break;
            case "SiteTour":
                this.setTitle("Sitios");
                titleTab1 = getResources().getString(R.string.site1);
                titleTab2 = getResources().getString(R.string.site2);
                titleTab3 = getResources().getString(R.string.site3);
                break;
        }

        ////////////////////////////////////////////////

        setContentView(R.layout.activity_tabs_navigation_drawer);

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

        ttUsername = (TextView) heder.findViewById(R.id.ttUsername);
        ttUsername.setText(user);
        ttEmail = (TextView) heder.findViewById(R.id.ttEmail);
        ttEmail.setText(email);

        ///////////////////////////////////////////////////
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new TabsNavigationDrawerActivity.SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        ///////////////////////
        
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
        Intent intent = new Intent(TabsNavigationDrawerActivity.this,TabsNavigationDrawerActivity.class);

        if (id == R.id.nav_main) {
            Intent intent2 = new Intent(TabsNavigationDrawerActivity.this, MainNavigationDrawerActivity.class);
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
            Intent intent3 = new Intent(TabsNavigationDrawerActivity.this,MainNavigationDrawerActivity.class);
            intent3.putExtra("username",user);
            intent3.putExtra("email",email);
            intent3.putExtra("fragment","perfil");
            startActivity(intent3);
        } else if (id == R.id.nav_salir) {
            editor.putInt("login",-1);
            editor.commit();
            Intent intent4 = new Intent(TabsNavigationDrawerActivity.this,LoginActivity.class);
            startActivity(intent4);
            finish();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            PlaceTab1Fragment tabP1 = new PlaceTab1Fragment();

            Bundle args = new Bundle();
            args.putString("places",places);
            switch (position){
                case 0:
                    args.putInt("place",1);
                    tabP1.setArguments(args);
                    return tabP1;
                case 1:
                    args.putInt("place",2);
                    tabP1.setArguments(args);
                    return tabP1;
                case 2:
                    args.putInt("place",3);
                    tabP1.setArguments(args);
                    return tabP1;
                default: return null;
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return titleTab1;
                case 1:
                    return titleTab2;
                case 2:
                    return titleTab3;
            }
            return null;
        }
    }
}
