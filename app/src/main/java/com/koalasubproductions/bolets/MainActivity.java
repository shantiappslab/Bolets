package com.koalasubproductions.bolets;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*afegim anunci
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);*/

        //is first run? Dialog
        checkFirstRun();

        //afegim la toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setBackgroundColor(getResources().getColor(R.color.taronja_oficial));

        //cridem la llista deslliçable amb els bolets
        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        if (viewPager != null) {
            setupViewPager(viewPager);
        }

        //cridem el menú en forma de tabletes TabLayout i l'oplim amb el metode setupWithViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setBackgroundColor(getResources().getColor(R.color.taronja_oficial));


        //afegim el botó menu a la toolbar
        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setTitle("   BOLETS");

        //cridem el DrawerLayout que conté la vista de la pantalla inicial
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        //Cridem el menu desplegable NavigationView
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }

        //cridem el FloatingActionButton
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Llista de receptes", Snackbar.LENGTH_LONG)
                        .setAction("D'ACORD", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Context context = viewPager.getContext();
                                Intent intentHome = new Intent(context, ReceptaList.class);
                                startActivity(intentHome);
                            }
                        }).show();
            }
        });

        loadImageFloatingActionButton();

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupViewPager(ViewPager viewPager) {
        Adapter adapter = new Adapter(getSupportFragmentManager());
        adapter.addFragment(new ApreciatsListFragment(), "APRECIATS");
        adapter.addFragment(new ToxicsListFragment(), "TÓXICS");
        viewPager.setAdapter(adapter);
    }


    private void setupDrawerContent(final NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {

                        menuItem.setChecked(true);

                        //Recollim el nom de l'item
                        String recepType = menuItem.getTitle().toString();
                        // Creamos el Intent y lo pasamos a la Activity
                        Context context = navigationView.getContext();

                        switch (recepType) {
                            case "BOLETS":
                                mDrawerLayout.closeDrawers(); // Cerrar drawer
                                menuItem.setChecked(false);
                                break;
                            case "RECEPTES":
                                // Mostramos Toast
                                Toast.makeText(getApplicationContext(), recepType, Toast.LENGTH_SHORT).show();
                                // Creamos el Intent y lo pasamos a la Activity
                                Intent intent2 = new Intent(context, ReceptaList.class);
                                context.startActivity(intent2);
                                break;
                            case "JOC":
                                // Mostramos Toast
                                Toast.makeText(getApplicationContext(), recepType, Toast.LENGTH_SHORT).show();
                                // Creamos el Intent y lo pasamos a la Activity
                                Intent intent3 = new Intent(context, JocDetail.class);
                                context.startActivity(intent3);
                                break;
                            case "Shanti Lab":
                                Toast.makeText(getApplicationContext(), "shanti.apps.lab@gmail.com", Toast.LENGTH_SHORT).show();
                        }
                        return true;
                    }
                });
    }

    private void loadImageFloatingActionButton() {

        final FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);

        floatingActionButton.setImageResource(R.drawable.ic_mushroom_icon);
    }

    public void checkFirstRun() {
        boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("isFirstRun", true);
        if (isFirstRun){
            // Place your dialog code here to display the dialog
            new AlertDialog.Builder(this)

                    .setTitle("BOLETAIRES") //set the Title text

            .setIcon(R.drawable.rovello_icon) //Set the picture in the top left of the popup

                    .setMessage(R.string.dialogCos)

            .setNeutralButton("D'ACORD", null).show(); //Sets the button type

            getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                    .edit()
                    .putBoolean("isFirstRun", false)
                    .apply();
        }
    }

    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public Adapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }
    }


}
