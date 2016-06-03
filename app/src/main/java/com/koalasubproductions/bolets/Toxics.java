package com.koalasubproductions.bolets;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * Created by haddock on 31/10/2015.
 */
public class Toxics {



    public static final ArrayList<String> toxicsList = new ArrayList<String>(Arrays.asList(
            "Farinera Borda", "Fredolic Metzinòs", "Gírgola d'Olivera", "Lletraga", "Matagent", "Reig Bord", "Pixacà" ));

    private static final String noSemblants = "Pixacà";

    private static int[] toxicsRealDrawList = {R.drawable.farineraborda_real,  R.drawable.fradolicmetzinos_real, R.drawable.girgoladolivera_real,
            R.drawable.lletraga_real,  R.drawable.matagent_real, R.drawable.reigbord_real, R.drawable.pixaca_real};

    public static int[] farinerabordaImageList = {R.drawable.farineraborda1,R.drawable.farineraborda2,R.drawable.farineraborda3,R.drawable.farineraborda4,R.drawable.farineraborda5,R.drawable.farineraborda6};

    public static int[] fredolicmetzinosImageList = {R.drawable.fredolicmetzinos1,R.drawable.fredolicmetzinos2,R.drawable.fredolicmetzinos3,R.drawable.fredolicmetzinos4,R.drawable.fredolicmetzinos5,R.drawable.fredolicmetzinos6};

    public static int[] girgoladoliveraImageList = {R.drawable.girgoladolivera1,R.drawable.girgoladolivera2,R.drawable.girgoladolivera3,R.drawable.girgoladolivera4,R.drawable.girgoladolivera5,R.drawable.girgoladolivera6};

    public static int[] lletragaImageList = {R.drawable.lletraga1,R.drawable.lletraga2,R.drawable.lletraga3,R.drawable.lletraga4,R.drawable.lletraga5,R.drawable.lletraga6};

    public static int[] matagentImageList = {R.drawable.matagent1,R.drawable.matagent2,R.drawable.matagent3,R.drawable.matagent4,R.drawable.matagent5,R.drawable.matagent6};

    public static int[] reigbordImageList = {R.drawable.reigbord1,R.drawable.reigbord2,R.drawable.reigbord3,R.drawable.reigbord4,R.drawable.reigbord5,R.drawable.reigbord6};

    public static int[] pixacaImageList = {R.drawable.pixaca1,R.drawable.pixaca2,R.drawable.pixaca3,R.drawable.pixaca4,R.drawable.pixaca5,R.drawable.pixaca6};


    public static int getToxicsDrawable(int i) {

        return toxicsRealDrawList[i];
    }


    public static int getToxicsRealDrawable(String boletName) {

        int aRealDraw;

        switch (boletName){
            case "Farinera Borda":
                aRealDraw = toxicsRealDrawList[0];
                break;

            case "Reig Bord":
                aRealDraw = toxicsRealDrawList[5];
                break;

            case "Pixacà":
                aRealDraw = toxicsRealDrawList[6];
                break;

            case "Fredolic Metzinòs":
                aRealDraw = toxicsRealDrawList[1];
                break;

            case "Matagent":
                aRealDraw = toxicsRealDrawList[4];
                break;

            case "Gírgola d'Olivera":
                aRealDraw = toxicsRealDrawList[2];
                break;

            case "Lletraga":
                aRealDraw = toxicsRealDrawList[3];
                break;


            default:
                throw new IllegalArgumentException("T.Invalid bolet name(getToxicRealdrawable): " + boletName);
        }

        return aRealDraw;
    }


    public static int getToxicsDescriptionTxt(String bName) {
        int sResource;

        switch (bName){
            case "Farinera Borda":
                sResource = (R.string.farineraborda_description);
                break;

            case "Reig Bord":
                sResource = (R.string.reigbord_description);
                break;

            case "Pixacà":
                sResource = (R.string.pixaca_description);
                break;

            case "Fredolic Metzinòs":
                sResource = (R.string.fredolicmetzinos_description);
                break;

            case "Matagent":
                sResource = (R.string.matagent_description);
                break;

            case "Gírgola d'Olivera":
                sResource = (R.string.girgola_description);
                break;

            case "Lletraga":
                sResource = (R.string.lletraga_description);
                break;


            default:
                throw new IllegalArgumentException("T.Invalid bolet name (getToxicsDescriptionTxt): " + bName);
        }

        return sResource;

    }

    public static int getToxicsSemblantsTxt(String bName) {
        int sResource;

        switch (bName){
            case "Farinera Borda":
                sResource = (R.string.farineraborda_semblants);
                break;

            case "Reig Bord":
                sResource = (R.string.reigbord_semblants);
                break;

            case "Pixacà":
                sResource = (R.string.pixaca_semblants);
                break;

            case "Fredolic Metzinòs":
                sResource = (R.string.fredolicmetzinos_semblants);
                break;

            case "Matagent":
                sResource = (R.string.matagent_semblants);
                break;

            case "Gírgola d'Olivera":
                sResource = (R.string.girgola_semblants);
                break;

            case "Lletraga":
                sResource = (R.string.lletraga_semblants);
                break;

            default:
                throw new IllegalArgumentException("T.Invalid bolet semblant name (getToxicsSemblantsTxt): " + bName);
        }

        return sResource;

    }



    public static int[] getGallery(String bName){

        int[] sResource = fredolicmetzinosImageList;

        switch (bName){

            case "Fredolic Metzinòs":
                sResource = fredolicmetzinosImageList;
                break;

            case "Farinera Borda":
                sResource = farinerabordaImageList;
                break;

            case "Gírgola d'Olivera":
                sResource = girgoladoliveraImageList;
                break;

            case "Lletraga":
                sResource = lletragaImageList;
                break;

            case "Matagent":
                sResource = matagentImageList;
                break;

            case "Reig Bord":
                sResource = reigbordImageList;
                break;

            case "Pixacà":
                sResource = pixacaImageList;
                break;
        }

        return sResource;
    }




    public static boolean compareSemblants (String bName){
        boolean semafor = false;

        if (bName.equals(noSemblants)){
                semafor = true;
        }
        return semafor;
    }


}