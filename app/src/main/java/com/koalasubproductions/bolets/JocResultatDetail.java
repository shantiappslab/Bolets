package com.koalasubproductions.bolets;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by haddock on 13/11/2015.
 */
public class JocResultatDetail extends AppCompatActivity {

    public static final int PUNTS = 0;
    public static final int item = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joc_resultat_detail);

        Intent intent = getIntent();
        int punts = intent.getIntExtra("PUNTS",0);

        if (punts <0){
            punts = 0;
        }


        ImageView img = (ImageView) findViewById(R.id.imatgeResultatFinal);
        final TextView resultat = (TextView) findViewById(R.id.txtResultatFinal);
        final TextView resultat2 = (TextView) findViewById(R.id.txtResultatFinal2);


        if (punts < 20) {
            img.setImageResource(R.drawable.progres1);
            resultat.setText("Has obtingut " + punts + " punts");
            resultat2.setText("De bons n'has collit ben pocs. Estas molt verd boletaire! Segueix practicant i segur que ho faràs millor.");
        }
        else if (punts >= 20 && punts < 50) {
            img.setImageResource(R.drawable.progres2);
            resultat.setText("Has obtingut " + punts + " punts.");
            resultat2.setText("Ep! vigila aquest cistell...alguns dels bolets que has collit són metzinosos. Segueix practicant i segur que ho faràs millor.");
        }
        else if (punts >= 50 && punts < 70) {
            img.setImageResource(R.drawable.progres3);
            resultat.setText("Has obtingut " + punts + " punts.");
            resultat2.setText("No està gens malament. N'has fet un bon cistell boletaire! Segueix practicant i segur que ho faràs encara millor.");
        }
        else if (punts >= 70 && punts < 80) {
            img.setImageResource(R.drawable.progres4);
            resultat.setText("Has obtingut " + punts + " punts.");
            resultat2.setText("Molt bé! Estas fet un expert boletaire. Segueix practicant i segur que ho faràs encara millor.");
        }
        else if (punts >= 80 && punts < 99) {
            img.setImageResource(R.drawable.progres5);
            resultat.setText("Has obtingut " + punts + " punts.");
            resultat2.setText("Quin ull! Ets un boletaire professional. Segueix practicant i segur que ho faràs encara millor.");
        }
        else if (punts == 100) {
            img.setImageResource(R.drawable.progres6);
            resultat.setText("Has obtingut " + punts + " punts.");
            resultat2.setText("Boletaire nivell Déu. Les llegendes del bosc parlen de tu, no hi ha bolet que se t'escapi.");
        }
        else{
            resultat.setText("torna a jugar");
            resultat2.setText("Punts: " + punts);
        }

        Button torna = (Button) findViewById(R.id.buttonTorna_joc);
        Button surt = (Button) findViewById(R.id.buttonAbandona_joc);

        torna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(JocResultatDetail.this, JocDetail.class);
                startActivity(intent);
            }
        });

        surt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent2 = new Intent(context, MainActivity.class);
                context.startActivity(intent2);
            }
        });
    }
}


