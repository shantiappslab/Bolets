package com.koalasubproductions.bolets;


import java.util.ArrayList;
import java.util.Arrays;


/**
 * Created by haddock on 31/10/2015.
 */
public class Apreciats {



    public static final ArrayList<String> apreciatsList = new ArrayList<String>(Arrays.asList(
            "Cama de perdiu", "Camagroc", "Cama-sec", "Cep", "Fredolic", "Llenega", "Llengua de bou", "Moixernó",
            "Múrgola", "Ou de Reig", "Rossinyol", "Rovelló", "Tòfona", "Trompeta"  ));

    private static final String[] noSemblants = {"Moixernó", "Llenega", "Tòfona", "Múrgola", "Camagroc", "Llengua de bou",
            "Cama-sec", "Trompeta", "Cama de perdiu"};

    private static int[] apreciatsRealDrawList = {R.drawable.camadeperdiu_real, R.drawable.camagroc_real, R.drawable.camasec_real, R.drawable.ceps_real,
            R.drawable.fredolics_real, R.drawable.llenegues_real, R.drawable.llenguadebou_real, R.drawable.moixernons_real, R.drawable.murgoles_real,
            R.drawable.oudereig_real, R.drawable.rossinyols_real, R.drawable.rovellons_real,  R.drawable.tofones_real,  R.drawable.trompetadelamort_real, };

    public static int[] camadeperdiuImageList = {R.drawable.camadeperdiu1, R.drawable.camadeperdiu2, R.drawable.camadeperdiu3, R.drawable.camadeperdiu4, R.drawable.camadeperdiu5, R.drawable.camadeperdiu6};

    public static int[] camagrocImageList = {R.drawable.camagroc1, R.drawable.camagroc2, R.drawable.camagroc3, R.drawable.camagroc4, R.drawable.camagroc5, R.drawable.camagroc6};

    public static int[] camasecImageList = {R.drawable.camasec1, R.drawable.camasec2, R.drawable.camasec3, R.drawable.camasec4, R.drawable.camasec5, R.drawable.camasec6};

    public static int[] cepImageList = {R.drawable.cep1, R.drawable.cep2, R.drawable.cep3, R.drawable.cep4, R.drawable.cep5, R.drawable.cep6};

    public static int[] fredolicsImageList = {R.drawable.fredolic1, R.drawable.fredolic2, R.drawable.fredolic3, R.drawable.fredolic4, R.drawable.fredolic5, R.drawable.fredolic6};

    public static int[] llenegaImageList = {R.drawable.llenega1, R.drawable.llenega2, R.drawable.llenega3, R.drawable.llenega4, R.drawable.llenega5, R.drawable.llenega6};

    public static int[] llenguadebouImageList = {R.drawable.llenguadebou1, R.drawable.llenguadebou2, R.drawable.llenguadebou3, R.drawable.llenguadebou4, R.drawable.llenguadebou5, R.drawable.llenguadebou6};

    public static int[] moixernoImageList = {R.drawable.moixerno1, R.drawable.moixerno2, R.drawable.moixerno3, R.drawable.moixerno4, R.drawable.moixerno5, R.drawable.moixerno6};

    public static int[] murgolaImageList = {R.drawable.murgola1, R.drawable.murgola2, R.drawable.murgola3, R.drawable.murgola4, R.drawable.murgola5, R.drawable.murgola6};

    public static int[] oudereigImageList = {R.drawable.oudereig1, R.drawable.oudereig2, R.drawable.oudereig3, R.drawable.oudereig4, R.drawable.oudereig5, R.drawable.oudereig6};

    public static int[] rossinyolImageList = {R.drawable.rossinyol1, R.drawable.rossinyol2, R.drawable.rossinyol3, R.drawable.rossinyol4, R.drawable.rossinyol5, R.drawable.rossinyol6};

    public static int[] rovelloImageList = {R.drawable.rovello1, R.drawable.rovello2, R.drawable.rovello3, R.drawable.rovello4, R.drawable.rovello5, R.drawable.rovello6};

    public static int[] tofonaImageList = {R.drawable.tofona1, R.drawable.tofona2, R.drawable.tofona3, R.drawable.tofona4, R.drawable.tofona5, R.drawable.tofona6};

    public static int[] trompetaImageList = {R.drawable.trompeta1, R.drawable.trompeta2, R.drawable.trompeta3, R.drawable.trompeta4, R.drawable.trompeta5, R.drawable.trompeta6};

    public static int getApreciatsDrawable(int i) {

        return apreciatsRealDrawList[i];
    }


    public static int getApreciatsRealDrawable(String boletName) {

        int aRealDraw;

        switch (boletName){
            case "Fredolic":
                aRealDraw = apreciatsRealDrawList[4];
                break;

            case "Moixernó":
                aRealDraw = apreciatsRealDrawList[7];
                break;

            case "Cep":
                aRealDraw = apreciatsRealDrawList[3];
                break;

            case "Rossinyol":
                aRealDraw = apreciatsRealDrawList[10];
                break;

            case "Rovelló":
                aRealDraw = apreciatsRealDrawList[11];
                break;

            case "Llenega":
                aRealDraw = apreciatsRealDrawList[5];
                break;

            case "Tòfona":
                aRealDraw = apreciatsRealDrawList[12];
                break;

            case "Múrgola":
                aRealDraw = apreciatsRealDrawList[8];
                break;

            case "Ou de Reig":
                aRealDraw = apreciatsRealDrawList[9];
                break;

            case "Camagroc":
                aRealDraw = apreciatsRealDrawList[1];
                break;

            case "Llengua de bou":
                aRealDraw = apreciatsRealDrawList[6];
                break;

            case "Cama-sec":
                aRealDraw = apreciatsRealDrawList[2];
                break;

            case "Trompeta":
                aRealDraw = apreciatsRealDrawList[13];
                break;

            case "Cama de perdiu":
                aRealDraw = apreciatsRealDrawList[0];
                break;

            default:
                throw new IllegalArgumentException("Invalid bolet name: " + boletName);
        }

        return aRealDraw;
    }


    public static int getApreciatsDescriptionTxt(String bName) {
        int sResource;

        switch (bName){
            case "Fredolic":
                sResource = (R.string.fredolics_description);
                break;

            case "Moixernó":
                sResource = (R.string.moixernons_description);
                break;

            case "Cep":
                sResource = (R.string.ceps_description);
                break;

            case "Rossinyol":
                sResource = (R.string.rossinyols_description);
                break;

            case "Rovelló":
                sResource = (R.string.rovellons_description);
                break;

            case "Llenega":
                sResource = (R.string.llenegues_description);
                break;

            case "Tòfona":
                sResource = (R.string.tofones_description);
                break;

            case "Múrgola":
                sResource = (R.string.murgoles_description);
                break;


            case "Ou de Reig":
                sResource = (R.string.oudereig_description);
                break;

            case "Camagroc":
                sResource = (R.string.camaroc_description);
                break;

            case "Llengua de bou":
                sResource = (R.string.llenguadebou_description);
                break;

            case "Cama-sec":
                sResource = (R.string.camasecs_description);
                break;

            case "Trompeta":
                sResource = (R.string.trompeta_description);
                break;

            case "Cama de perdiu":
                sResource = (R.string.camadeperdiu_description);
                break;

            default:
                throw new IllegalArgumentException("Invalid bolet name: " + bName);
        }

        return sResource;

    }

    public static int getApreciatsSemblantsTxt(String bName) {
        int sResource;

        switch (bName){
            case "Fredolic":
                sResource = (R.string.fredolics_semblants);
                break;

            case "Moixernó":
                sResource = (R.string.moixernons_semblants);
                break;

            case "Cep":
                sResource = (R.string.ceps_semblants);
                break;

            case "Rossinyol":
                sResource = (R.string.rossinyols_semblants);
                break;

            case "Rovelló":
                sResource = (R.string.rovellons_semblants);
                break;

            case "Llenega":
                sResource = (R.string.llengues_semblants);
                break;

            case "Tòfona":
                sResource = (R.string.tofones_semblants);
                break;

            case "Múrgola":
                sResource = (R.string.murgoles_semblants);
                break;

            case "Ou de Reig":
                sResource = (R.string.oudereig_semblants);
                break;

            case "Camagroc":
                sResource = (R.string.camagroc_semblants);
                break;

            case "Llengua de bou":
                sResource = (R.string.llenguadebou_semblants);
                break;

            case "Cama-sec":
                sResource = (R.string.camasec_semblants);
                break;

            case "Trompeta":
                sResource = (R.string.trompeta_semblants);
                break;

            case "Cama de perdiu":
                sResource = (R.string.camadeperdiu_semblants);
                break;

            default:
                throw new IllegalArgumentException("Invalid bolet name: " + bName);
        }

        return sResource;

    }
    //si està a la llista de noSemblants retorna true
    public static boolean compareSemblants (String bName){
        boolean semafor = false;

        for (int i=0; i<noSemblants.length; i++){
            if (bName.equals(noSemblants[i])){
                semafor = true;
            }

        }

        return semafor;
    }

    public static int[] getGallery(String bName){

        int[] sResource = rovelloImageList;

        switch (bName){

            case "Fredolic":
                sResource = fredolicsImageList;
                break;

            case "Moixernó":
                sResource = moixernoImageList;
                break;

            case "Cep":
                sResource = cepImageList;
                break;

            case "Rossinyol":
                sResource = rossinyolImageList;
                break;

            case "Rovelló":
                sResource = rovelloImageList;
                break;

            case "Llenega":
                sResource = llenegaImageList;
                break;

            case "Tòfona":
                sResource = tofonaImageList;
                break;

            case "Múrgola":
                sResource = murgolaImageList;
                break;

            case "Ou de Reig":
                sResource = oudereigImageList;
                break;

            case "Camagroc":
                sResource = camagrocImageList;
                break;

            case "Llengua de bou":
                sResource = llenguadebouImageList;
                break;

            case "Cama-sec":
                sResource = camasecImageList;
                break;

            case "Trompeta":
                sResource = trompetaImageList;
                break;

            case "Cama de perdiu":
                sResource = camadeperdiuImageList;
                break;

        }

        return sResource;
    }

}
