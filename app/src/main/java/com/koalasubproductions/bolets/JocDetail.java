package com.koalasubproductions.bolets;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.os.CountDownTimer;
import java.util.concurrent.TimeUnit;

/**
 * Created by haddock on 11/11/2015.
 */
public class JocDetail extends AppCompatActivity {

    //public static final String ITEM = "a";

    //private static final String FORMAT = "%02d:%02d:%02d";
    private static final String FORMAT = "%02d:%02d";
    int seconds, minutes;
    CountDownTimer countDownTimer;

    private int punts = 0;
    private int i = 1;
    private int imatge;
    private int correcte;
    private int opcio1;
    private int opcio2;
    private int opcio3;


    public static int[] joc_ITEMS_P1 = {R.drawable.rovellons_real, R.string.rovelloNom, R.string.camadeperdiuNom, R.string.rovelloNom, R.string.cepNom};
    public static int[] joc_ITEMS_P2 = {R.drawable.llenegues_real, R.string.llenegaNom, R.string.llenegaNom, R.string.farinerabordaNom, R.string.rossinyolNom};
    public static int[] joc_ITEMS_P3 = {R.drawable.camadeperdiu6, R.string.camadeperdiuNom, R.string.fredolicmetzinosNom, R.string.reigbordNom, R.string.camadeperdiuNom};
    public static int[] joc_ITEMS_P4 = {R.drawable.oudereig1, R.string.oudereigNom, R.string.farinerabordaNom, R.string.oudereigNom, R.string.pixacaNom};
    public static int[] joc_ITEMS_P5 = {R.drawable.lletraga6, R.string.lletragaNom, R.string.rovelloNom, R.string.camasecNom, R.string.lletragaNom};
    public static int[] joc_ITEMS_P6 = {R.drawable.fredolicmetzinos4, R.string.fredolicmetzinosNom, R.string.fredolicmetzinosNom, R.string.fredolicNom, R.string.camasecNom};
    public static int[] joc_ITEMS_P7 = {R.drawable.camagroc1, R.string.camagrocNom, R.string.camasecNom, R.string.girgolaoliveraNom, R.string.camagrocNom};
    public static int[] joc_ITEMS_P8 = {R.drawable.reigbord4, R.string.reigbordNom, R.string.reigbordNom, R.string.farinerabordaNom, R.string.llenegaNom};
    public static int[] joc_ITEMS_P9 = {R.drawable.tofona4, R.string.tofonaNom, R.string.camadeperdiuNom, R.string.tofonaNom, R.string.lletragaNom};
    public static int[] joc_ITEMS_P10 = {R.drawable.camasec3, R.string.camasecNom, R.string.camasecNom, R.string.rossinyolNom, R.string.pixacaNom};
    public static int[] joc_ITEMS_P11 = {R.drawable.ceps_real, R.string.cepNom, R.string.llenegaNom, R.string.matagentNom, R.string.cepNom};
    public static int[] joc_ITEMS_P12 = {R.drawable.farineraborda6, R.string.farinerabordaNom, R.string.oudereigNom, R.string.farinerabordaNom, R.string.murgolaNom};
    public static int[] joc_ITEMS_P13 = {R.drawable.fredolic6, R.string.fredolicNom, R.string.fredolicmetzinosNom, R.string.trompetaNom, R.string.fredolicNom};
    public static int[] joc_ITEMS_P14 = {R.drawable.girgoladolivera2, R.string.girgolaoliveraNom, R.string.girgolaoliveraNom, R.string.rossinyolNom, R.string.lletragaNom};
    public static int[] joc_ITEMS_P15 = {R.drawable.murgola3, R.string.murgolaNom, R.string.matagentNom, R.string.llenguadebouNom, R.string.murgolaNom};
    public static int[] joc_ITEMS_P16 = {R.drawable.rossinyol1, R.string.rossinyolNom, R.string.rossinyolNom, R.string.matagentNom, R.string.llenguadebouNom};
    public static int[] joc_ITEMS_P17 = {R.drawable.trompeta6, R.string.trompetaNom, R.string.fredolicmetzinosNom, R.string.trompetaNom, R.string.farinerabordaNom};
    public static int[] joc_ITEMS_P18 = {R.drawable.pixaca6, R.string.pixacaNom, R.string.reigbordNom, R.string.farinerabordaNom, R.string.pixacaNom};
    public static int[] joc_ITEMS_P19 = {R.drawable.matagent_real, R.string.matagentNom, R.string.matagentNom, R.string.camasecNom, R.string.reigbordNom};
    public static int[] joc_ITEMS_P20 = {R.drawable.llenguadebou1, R.string.llenguadebouNom, R.string.girgolaoliveraNom, R.string.llenguadebouNom, R.string.llenegaNom};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joc_main);

        //iniciem musica
        MediaPlayer mPlayer = MediaPlayer.create(JocDetail.this, R.raw.song);
        mPlayer.setLooping(false);
        mPlayer.start();
        AudioManager manaeger = (AudioManager) this.getSystemService(Context.AUDIO_SERVICE);
        if (!manaeger.isMusicActive()) {
            mPlayer.start();
        }

        //inicialitzem els controls
        final RelativeLayout rlayJoc = (RelativeLayout) findViewById(R.id.rlayJoc);
        final TextView txtTitol_joc = (TextView) findViewById(R.id.txtTitol_joc);
        final TextView txtTemps_joc = (TextView) findViewById(R.id.txtTemps_joc);
        final ImageView imatge_joc = (ImageView) findViewById(R.id.imatge_joc);
        final RadioGroup rbGrup = (RadioGroup) findViewById(R.id.rbGrup);
        //RadioButton rbopcio1 = (RadioButton) findViewById(R.id.opcio1);
        //RadioButton rbopcio2 = (RadioButton) findViewById(R.id.opcio2);
        //RadioButton rbopcio3 = (RadioButton) findViewById(R.id.opcio3);
        final Button buttonEnvia_joc = (Button) findViewById(R.id.buttonEnvia_joc);
        Button buttonAbandona_joc = (Button) findViewById(R.id.buttonAbandona_joc);
        final TextView punts_joc = (TextView) findViewById(R.id.txtPunts_joc);


        loadData(i);

        countDownTimer = new CountDownTimer(180000, 1000) { // adjust the milli seconds here

            @Override
            public void onTick(long millisUntilFinished) {

                txtTemps_joc.setText(" " + String.format(FORMAT,
                                TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished),
                                TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)))
                                + "''");
            }

            @Override
            public void onFinish() {
                txtTemps_joc.setText(" 00:00''");
                txtTemps_joc.setTextColor(getResources().getColor(R.color.facildeconfondre));
                printRightAnswerColor().setTextColor(getResources().getColor(R.color.verd));
                //imatge_joc.setImageResource(R.drawable.incorrecta);
                rlayJoc.setBackgroundColor(getResources().getColor(R.color.facildeconfondre));
                buttonEnvia_joc.setEnabled(false);
                buttonEnvia_joc.setBackgroundColor(getResources().getColor(R.color.gris));
                Button next = (Button) findViewById(R.id.buttonNext_joc);
                next.setEnabled(true);
                next.setBackgroundColor(getResources().getColor(R.color.verd));
                next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                            Intent intent = new Intent(JocDetail.this, JocResultatDetail.class);
                            intent.putExtra("PUNTS", punts);
                            startActivity(intent);
                    }
                });
            }
        }.start();


        buttonEnvia_joc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int checked = rbGrup.getCheckedRadioButtonId();
                if (checked != -1) {
                    String radiovalue = ((RadioButton) findViewById(rbGrup.getCheckedRadioButtonId())).getText().toString();
                    if (radiovalue.equals(getResources().getString(correcte))) {
                        RadioButton rb = ((RadioButton) findViewById(rbGrup.getCheckedRadioButtonId()));
                        rb.setTextColor(getResources().getColor(R.color.verd));
                        punts = punts + 5;
                        punts_joc.setText("" + punts + " punts");
                        rlayJoc.setBackgroundColor(getResources().getColor(R.color.verd));
                        buttonEnvia_joc.setEnabled(false);
                        buttonEnvia_joc.setBackgroundColor(getResources().getColor(R.color.gris));
                        Button next = (Button) findViewById(R.id.buttonNext_joc);
                        next.setEnabled(true);
                        next.setBackgroundColor(getResources().getColor(R.color.verd));
                        next.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                i++;
                                if (i > 20) {
                                    Intent intent = new Intent(JocDetail.this, JocResultatDetail.class);
                                    intent.putExtra("PUNTS", punts);
                                    startActivity(intent);

                                } else {
                                    loadData(i);
                                }
                            }

                        });
                    } else {
                        RadioButton rb = ((RadioButton) findViewById(rbGrup.getCheckedRadioButtonId()));
                        rb.setTextColor(getResources().getColor(R.color.facildeconfondre));
                        printRightAnswerColor().setTextColor(getResources().getColor(R.color.verd));
                        rlayJoc.setBackgroundColor(getResources().getColor(R.color.facildeconfondre));
                        buttonEnvia_joc.setEnabled(false);
                        buttonEnvia_joc.setBackgroundColor(getResources().getColor(R.color.gris));
                        Button next = (Button) findViewById(R.id.buttonNext_joc);
                        next.setEnabled(true);
                        next.setBackgroundColor(getResources().getColor(R.color.verd));
                        next.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                i++;
                                if (i > 20) {
                                    Intent intent = new Intent(JocDetail.this, JocResultatDetail.class);
                                    intent.putExtra("PUNTS", punts);
                                    startActivity(intent);

                                } else {
                                    loadData(i);
                                }
                            }

                        });

                    }
                }

            }
        });

        buttonAbandona_joc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent(context, MainActivity.class);
                context.startActivity(intent);
            }
        });
    }

    private void loadData(int i) {

        //inicialitzem els controls
        final ImageView imatge_joc = (ImageView) findViewById(R.id.imatge_joc);
        final RadioGroup rbGrup = (RadioGroup) findViewById(R.id.rbGrup);
        final RadioButton rbopcio1 = (RadioButton) findViewById(R.id.opcio1);
        final RadioButton rbopcio2 = (RadioButton) findViewById(R.id.opcio2);
        final RadioButton rbopcio3 = (RadioButton) findViewById(R.id.opcio3);
        final TextView cont_joc = (TextView) findViewById(R.id.cont_joc);
        final TextView punts_joc = (TextView) findViewById(R.id.txtPunts_joc);
        final RelativeLayout rlayJoc = (RelativeLayout)findViewById(R.id.rlayJoc);

        rlayJoc.setBackgroundColor(getResources().getColor(R.color.white));
        Button next = (Button) findViewById(R.id.buttonNext_joc);
        next.setEnabled(false);
        next.setBackgroundColor(getResources().getColor(R.color.gris));
        Button buttonEnvia_joc = (Button) findViewById(R.id.buttonEnvia_joc);
        buttonEnvia_joc.setEnabled(true);
        buttonEnvia_joc.setBackgroundColor(getResources().getColor(R.color.verd));

        rbopcio1.setTextColor(getResources().getColor(R.color.cardview_dark_background));
        rbopcio2.setTextColor(getResources().getColor(R.color.cardview_dark_background));
        rbopcio3.setTextColor(getResources().getColor(R.color.cardview_dark_background));

        imatge = getjocITEM(i)[0];
        correcte = getjocITEM(i)[1];
        opcio1 = getjocITEM(i)[2];
        opcio2 = getjocITEM(i)[3];
        opcio3 = getjocITEM(i)[4];

        imatge_joc.setImageResource(imatge);
        cont_joc.setText(i + "/20");
        punts_joc.setText("" + punts + " punts");
        rbGrup.clearCheck();
        rbopcio1.setText(getString(opcio1));
        rbopcio2.setText(getString(opcio2));
        rbopcio3.setText(getString(opcio3));
    }

    private RadioButton printRightAnswerColor() {

        String ra = getResources().getString(correcte);
        RadioButton rbopcio1 = (RadioButton) findViewById(R.id.opcio1);
        RadioButton rbopcio2 = (RadioButton) findViewById(R.id.opcio2);
        RadioButton rbopcio3 = (RadioButton) findViewById(R.id.opcio3);
        String radiovalue1 = rbopcio1.getText().toString();
        String radiovalue2 = rbopcio2.getText().toString();
        //String radiovalue3 = rbopcio3.getText().toString();

        if (ra.equalsIgnoreCase(radiovalue1)) {
            return rbopcio1;
        } else if (ra.equalsIgnoreCase(radiovalue2)) {
            return rbopcio2;
        } else {
            return rbopcio3;
        }
    }

    private int[] getjocITEM(int i) {
        int[] item = joc_ITEMS_P1;

        switch (i) {
            case 1:
                item = joc_ITEMS_P1;
                break;
            case 2:
                item = joc_ITEMS_P2;
                break;
            case 3:
                item = joc_ITEMS_P3;
                break;
            case 4:
                item = joc_ITEMS_P4;
                break;
            case 5:
                item = joc_ITEMS_P5;
                break;
            case 6:
                item = joc_ITEMS_P6;
                break;
            case 7:
                item = joc_ITEMS_P7;
                break;
            case 8:
                item = joc_ITEMS_P8;
                break;
            case 9:
                item = joc_ITEMS_P9;
                break;
            case 10:
                item = joc_ITEMS_P10;
                break;
            case 11:
                item = joc_ITEMS_P11;
                break;
            case 12:
                item = joc_ITEMS_P12;
                break;
            case 13:
                item = joc_ITEMS_P13;
                break;
            case 14:
                item = joc_ITEMS_P14;
                break;
            case 15:
                item = joc_ITEMS_P15;
                break;
            case 16:
                item = joc_ITEMS_P16;
                break;
            case 17:
                item = joc_ITEMS_P17;
                break;
            case 18:
                item = joc_ITEMS_P18;
                break;
            case 19:
                item = joc_ITEMS_P19;
                break;
            case 20:
                item = joc_ITEMS_P20;
                break;
        }

        return item;
    }


}
