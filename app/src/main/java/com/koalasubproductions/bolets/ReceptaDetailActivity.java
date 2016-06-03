package com.koalasubproductions.bolets;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;


/**
 * Fragmento para el contenido principal
 */
public class ReceptaDetailActivity extends AppCompatActivity {
    /**
     * Este argumento del fragmento representa el título de cada
     * sección
     */
    public static final String ARG_SECTION_TITLE = "recep_name";
    public static final String RECEP_TYPE = "recep_type";
    private DrawerLayout mDrawerLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recepta_fragment);

        //afegim anunci
        /*AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);*/

        //carreguem l'Intent
        Intent intent = getIntent();
        final String rName = intent.getStringExtra(ARG_SECTION_TITLE);
        final String tName = intent.getStringExtra(RECEP_TYPE);

        //cridem el DrawerLayout que conté la vista de la pantalla inicial
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout_recepta);

        //carreguem la toolbar
        final Toolbar toolbar = (Toolbar)(findViewById(R.id.toolbar_recepta));
        toolbar.setTitle(rName);
        setSupportActionBar(toolbar);

        //afegim el botó menu a la toolbar
        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);

        //Cridem el menu desplegable NavigationView
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }

        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_recepta);
        collapsingToolbar.setTitle(rName);

        final FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton_recepta);
        floatingActionButton.setImageResource(R.drawable.ic_coberts);

        loadBackdropAndText();
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

                        switch (recepType){
                            case "BOLETS":
                                // Mostramos Toast
                                Toast.makeText(getApplicationContext(), recepType, Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(context, MainActivity.class);
                                startActivity(intent);
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void loadBackdropAndText() {
        Intent intent = getIntent();
        final String rName = intent.getStringExtra(ARG_SECTION_TITLE);
        final String tName = intent.getStringExtra(RECEP_TYPE);

        Recepta recepta = getItemByName(rName, tName);

        final ImageView imageView = (ImageView) findViewById(R.id.backdrop_recepta);
        Glide.with(this).load(recepta.getIdImatge()).centerCrop().into(imageView);

        final TextView textView1 = (TextView)findViewById(R.id.txtNom);
        final TextView textView2 = (TextView)findViewById(R.id.txtIngredients_recepta);
        final TextView textView3 = (TextView)findViewById(R.id.txtPreparacio_recepta);
        final TextView textView4 = (TextView)findViewById(R.id.txtTemps_recepta);

        textView1.setText(recepta.getNom());
        textView2.setText(recepta.getIdIngredients());
        textView3.setText(recepta.getIdPreparacio());
        textView4.setText(recepta.getIdTtemps());
        }

    private Recepta getItemByName(String rName, String tName) {
        Recepta recepta = null;
        String nomString;
        switch (tName) {
            case "Aperitius":
                for (Recepta item : Recepta.Aperitius_ITEMS) {
                    nomString = getResources().getString(item.getNomCurt());
                    if (nomString.equals(rName)) {
                        recepta = item;
                    }
                }
                break;
            case "Primers plats":
                for (Recepta item : Recepta.Primers_ITEMS) {
                    nomString = getResources().getString(item.getNomCurt());
                    if (nomString.equals(rName)) {
                        recepta = item;
                    }
                }
                break;
            case "Segons plats":
                for (Recepta item : Recepta.Segons_ITEMS) {
                    nomString = getResources().getString(item.getNomCurt());
                    if (nomString.equals(rName)) {
                        recepta = item;
                    }
                }
                break;
            case "Postres":
                for (Recepta item : Recepta.Postres_ITEMS) {
                    nomString = getResources().getString(item.getNomCurt());
                    if (nomString.equals(rName)) {
                        recepta = item;
                    }
                }
                break;

        }
        return recepta;
    }



}