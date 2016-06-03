package com.koalasubproductions.bolets;

/**
 * Created by haddock on 31/10/2015.
 */

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;


public class MushroomDetailActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "variedad_name";
    public static final String FRAG_NAME = "fragment_name";
    private static String frag = "fragment_name";
    private DrawerLayout mDrawerLayout;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //afegim anunci
        /*AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);*/

        Intent intent = getIntent();
        final String bName = intent.getStringExtra(EXTRA_NAME);
        final String fName = intent.getStringExtra(FRAG_NAME);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //afegim el botó menu a la toolbar
        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);

        //cridem el DrawerLayout que conté la vista de la pantalla inicial
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        //Cridem el menu desplegable NavigationView
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }


        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(bName);

        TextView textView = (TextView) findViewById(R.id.txtSemblants);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, MushroomDetailActivity.class);

                String nomSemblant = getNomSemblant(fName, bName);

                intent.putExtra(MushroomDetailActivity.EXTRA_NAME, nomSemblant);
                intent.putExtra(MushroomDetailActivity.FRAG_NAME, frag);


                context.startActivity(intent);
            }
        });


        loadBackdrop();
        loadText();
        loadImageFloatingActionButton(fName);
        loadGallery();

    }


    private void loadBackdrop() {
        Intent intent = getIntent();
        final String bName = intent.getStringExtra(EXTRA_NAME);
        final String fName = intent.getStringExtra(FRAG_NAME);
        final ImageView imageView = (ImageView) findViewById(R.id.backdrop);
        switch (fName) {
            case "Apreciats":
                Glide.with(this).load(Apreciats.getApreciatsRealDrawable(bName)).centerCrop().into(imageView);
                break;
            case "Toxics":
                Glide.with(this).load(Toxics.getToxicsRealDrawable(bName)).centerCrop().into(imageView);
                break;
        }

    }


    private void loadText() {
        Intent intent = getIntent();
        final String bName = intent.getStringExtra(EXTRA_NAME);
        final String fName = intent.getStringExtra(FRAG_NAME);
        final TextView txtDescipcio = (TextView) findViewById(R.id.txtDescripcio);
        final TextView titleSemblants = (TextView) findViewById(R.id.titleSemblants);
        final TextView txtSemblants = (TextView) findViewById(R.id.txtSemblants);
        final LinearLayout linSemblants = (LinearLayout) findViewById(R.id.linSemblants);

        switch (fName) {
            case "Apreciats":
                txtDescipcio.setText(Apreciats.getApreciatsDescriptionTxt(bName));
                titleSemblants.setText(R.string.titol_toxics_semblants);
                String text1 = getResources().getString(Apreciats.getApreciatsSemblantsTxt(bName));
                SpannableString spanString1 = new SpannableString(text1);
                spanString1.setSpan(new UnderlineSpan(), 0, spanString1.length(), 0);
                txtSemblants.setText(spanString1 );
                txtSemblants.setTextColor(getResources().getColor(R.color.vermell));
                boolean semaforA = Apreciats.compareSemblants(bName);
                if (semaforA == true) {
                    setDisable(linSemblants);
                }
                break;

            case "Toxics":
                txtDescipcio.setText(Toxics.getToxicsDescriptionTxt(bName));
                titleSemblants.setText(R.string.titol_comestibles_semblants);
                String text2 = getResources().getString(Toxics.getToxicsSemblantsTxt(bName));
                SpannableString spanString2 = new SpannableString(text2);
                spanString2.setSpan(new UnderlineSpan(), 0, spanString2.length(), 0);
                txtSemblants.setText(spanString2 );
                txtSemblants.setTextColor(getResources().getColor(R.color.verd));
                boolean semaforT = Toxics.compareSemblants(bName);
                if (semaforT == true) {
                    setDisable(linSemblants);
                }
                break;


        }
    }

    private void loadImageFloatingActionButton(String fName) {

        final FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);

        switch (fName) {
            case "Apreciats":
                floatingActionButton.setImageResource(R.drawable.ic_comestibles);
                break;
            case "Toxics":
                floatingActionButton.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                floatingActionButton.setImageResource(R.drawable.ic_calavera);
                break;
        }
    }

    private void setDisable(LinearLayout lin) {
        for (int i = 0; i < lin.getChildCount(); i++) {
            View view = lin.getChildAt(i);
            view.setEnabled(false);
        }
    }

    private void loadGallery() {
        Intent intent = getIntent();
        final String bName = intent.getStringExtra(EXTRA_NAME);
        final String fName = intent.getStringExtra(FRAG_NAME);
        final ImageView image1 = (ImageView) findViewById(R.id.image1);
        final ImageView image2 = (ImageView) findViewById(R.id.image2);
        final ImageView image3 = (ImageView) findViewById(R.id.image3);
        final ImageView image4 = (ImageView) findViewById(R.id.image4);
        final ImageView image5 = (ImageView) findViewById(R.id.image5);
        final ImageView image6 = (ImageView) findViewById(R.id.image6);

        switch (fName) {
            case "Apreciats":
                Glide.with(this).load(Apreciats.getGallery(bName)[0]).centerCrop().into(image1);
                Glide.with(this).load(Apreciats.getGallery(bName)[1]).centerCrop().into(image2);
                Glide.with(this).load(Apreciats.getGallery(bName)[2]).centerCrop().into(image3);
                Glide.with(this).load(Apreciats.getGallery(bName)[3]).centerCrop().into(image4);
                Glide.with(this).load(Apreciats.getGallery(bName)[4]).centerCrop().into(image5);
                Glide.with(this).load(Apreciats.getGallery(bName)[5]).centerCrop().into(image6);
                break;
            case "Toxics":
                Glide.with(this).load(Toxics.getGallery(bName)[0]).centerCrop().into(image1);
                Glide.with(this).load(Toxics.getGallery(bName)[1]).centerCrop().into(image2);
                Glide.with(this).load(Toxics.getGallery(bName)[2]).centerCrop().into(image3);
                Glide.with(this).load(Toxics.getGallery(bName)[3]).centerCrop().into(image4);
                Glide.with(this).load(Toxics.getGallery(bName)[4]).centerCrop().into(image5);
                Glide.with(this).load(Toxics.getGallery(bName)[5]).centerCrop().into(image6);
                break;

        }

    }


    private String getNomSemblant(String fName, String bName) {
        String lName = "";

        switch (fName) {
            case "Apreciats":
                lName = getResources().getString(Apreciats.getApreciatsSemblantsTxt(bName));
                break;
            case "Toxics":
                lName = getResources().getString(Toxics.getToxicsSemblantsTxt(bName));
                break;
            default:
                throw new IllegalArgumentException("Invalid frame name(getNomSemblant): " + fName);
        }

        String nomSemblant = "";
        String fragName = "";

        switch (lName) {
            case "Matagent (Boletus Satanas)":
                nomSemblant = "Matagent";
                fragName = "Toxics";
                break;
            case "Fredolic Metzinòs (Tricholoma Pardinum)":
                nomSemblant = "Fredolic Metzinòs";
                fragName = "Toxics";
                break;
            case "Gírgola d'Olivera (Omphalotus Olearius)":
                nomSemblant = "Gírgola d'Olivera";
                fragName = "Toxics";
                break;
            case "Lletraga (Lactarius Chrysorrheus)":
                nomSemblant = "Lletraga";
                fragName = "Toxics";
                break;
            case "Farinera Borda (Amanita Phalloides)":
                nomSemblant = "Farinera Borda";
                fragName = "Toxics";
                break;
            case "Ou de Reig (Amanita caesarea)":
                nomSemblant = "Ou de Reig";
                fragName = "Apreciats";
                break;
            case "Fredolic (Tricholoma terreum)":
                nomSemblant = "Fredolic";
                fragName = "Apreciats";
                break;
            case "Cep (Boletus edulis)":
                nomSemblant = "Cep";
                fragName = "Apreciats";
                break;
            case "Rossinyol (Cantharellus cibarius)":
                nomSemblant = "Rossinyol";
                fragName = "Apreciats";
                break;
            case "Rovelló (Lactarius deliciosus)":
                nomSemblant = "Rovelló";
                fragName = "Apreciats";
                break;
            default:
                throw new IllegalArgumentException("Invalid bolet semblant name(getNomSemblant): lName=" + lName + fName + bName);
        }

        frag = fragName;
        return nomSemblant;

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
                                Intent intent2 = new Intent(MushroomDetailActivity.this, ReceptaList.class);
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


}
