package com.julianyepes.copaturistica;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.TextView;

import static com.julianyepes.copaturistica.R.id.container;

public class PlacesTabActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    String places;
    PlaceTab1Fragment tabP1 = new PlaceTab1Fragment();
    PlaceTab1Fragment tabP2 = new PlaceTab1Fragment();
    PlaceTab1Fragment tabP3 = new PlaceTab1Fragment();
    TextView tfPlace;

    String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //str = new String("hola");

        setContentView(R.layout.activity_places_tab);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        ///////////////////////

        Bundle extras=getIntent().getExtras();
        places = extras.getString("places");
        Bundle args1 = new Bundle();
        Bundle args2 = new Bundle();
        Bundle args3 = new Bundle();
        str = new String("hola");

        switch ( places ){
            case "Hotels":
                this.setTitle("Hoteles");

                args1.putInt("place",1);
                args1.putString("places",places);
                tabP1.setArguments(args1);

                args2.putInt("place",2);
                args2.putString("places",places);
                tabP2.setArguments(args2);

                args3.putInt("place",3);
                args3.putString("places",places);
                tabP3.setArguments(args3);
                break;
            case "Bares":
                this.setTitle("Bares");

                args1.putInt("place",1);
                args1.putString("places",places);
                tabP1.setArguments(args1);

                args2.putInt("place",2);
                args2.putString("places",places);
                tabP2.setArguments(args2);

                args3.putInt("place",3);
                args3.putString("places",places);
                tabP3.setArguments(args3);
                break;
            case "SiteTour":
                this.setTitle("Sitios");

                args1.putInt("place",1);
                args1.putString("places",places);
                tabP1.setArguments(args1);

                args2.putInt("place",2);
                args2.putString("places",places);
                tabP2.setArguments(args2);

                args3.putInt("place",3);
                args3.putString("places",places);
                tabP3.setArguments(args3);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        //cambio intem 0 a inicio
        //menu.getItem(0).setTitle(getResources().getString(R.string.home));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Intent intent = new Intent(PlacesTabActivity.this, PlacesTabActivity.class);

        switch (id){
            case R.id.mItem0://Hoteles
                intent.putExtra("places","Hotels");
                startActivity(intent);
                finish();
                break;
            case R.id.mItem1://Bares
                intent.putExtra("places","Bares");
                startActivity(intent);
                finish();
                break;
            case R.id.mItem2://Sitios Turisticos
                intent.putExtra("places","SiteTour");
                startActivity(intent);
                finish();
                break;
            case R.id.mItem3://Perfil
                Intent intent3 = new Intent(PlacesTabActivity.this,ProfileActivity.class);
                intent3.putExtra("username","user");
                intent3.putExtra("email","email");
                startActivity(intent3);
                break;
            case R.id.mItem4://Salir de la Aplicacion
                Intent intent4 = new Intent(PlacesTabActivity.this,LoginActivity.class);
                //setResult(RESULT_OK,intent1);
                //startActivityForResult(intent4,3);
                startActivity(intent4);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
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
            switch (position){
                case 0:
                    return tabP1;
                case 1:
                    return tabP2;
                case 2:
                    return tabP3;
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
                    return str;
                case 1:
                    return "Section 2";
                case 2:
                    return "Section 3";
            }
            return null;
        }
    }
}
