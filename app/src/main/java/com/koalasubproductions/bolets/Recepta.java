package com.koalasubproductions.bolets;



public class Recepta {
    private int idNom;
    private int idNomCurt;
    private int idImatge;
    private int idIngredients;
    private int idPreparacio;
    private int idTemps;

    public Recepta (int idNomCurt, int idNom, int idImatge, int idIngredients, int idPreparacio, int idTemps){
        this.idNomCurt = idNomCurt;
        this.idNom = idNom;
        this.idImatge = idImatge;
        this.idIngredients = idIngredients;
        this.idPreparacio = idPreparacio;
        this.idTemps = idTemps;
    }

    public int getNomCurt() {
        return idNomCurt;
    }

    public int getNom() {
        return idNom;
    }

    public int getIdImatge() {
        return idImatge;
    }

    public int getIdIngredients() {
        return idIngredients;
    }

    public int getIdPreparacio() {
        return idPreparacio;
    }

    public int getIdTtemps() {
        return idTemps;
    }




    public static Recepta[] Aperitius_ITEMS = {
            new Recepta(R.string.nom_curt_amianidaousreig, R.string.nom_amianidaousreig,R.drawable.amanidaoureig, R.string.ingredients_amianidaousreig, R.string.preparacio_amianidaousreig, R.string.temps_amianidaousreig ),
            new Recepta(R.string.nom_curt_cocafredolics, R.string.nom_cocafredolics,R.drawable.cocafredolics, R.string.ingredients_cocafredolics, R.string.preparacio_cocafredolics, R.string.temps_cocafredolics ),
            new Recepta(R.string.nom_curt_cocaverdura, R.string.nom_cocaverdura,R.drawable.cocaverdures, R.string.ingredients_cocaverdura, R.string.preparacio_cocaverdura, R.string.temps_cocaverdura ),
            new Recepta(R.string.nom_curt_galetesinca, R.string.nom_galetesinca,R.drawable.galetesinca, R.string.ingredients_galetesinca, R.string.preparacio_galetesinca, R.string.temps_galetesinca ),
            new Recepta(R.string.nom_curt_lleneguesbrasa, R.string.nom_lleneguesbrasa,R.drawable.lleneguesbrasa, R.string.ingredients_lleneguesbrasa, R.string.preparacio_lleneguesbrasa, R.string.temps_lleneguesbrasa ),
            new Recepta(R.string.nom_curt_petsdellop, R.string.nom_petsdellop,R.drawable.petsdellop, R.string.ingredients_petsdellop, R.string.preparacio_petsdellop, R.string.temps_petsdellop ),
            new Recepta(R.string.nom_curt_pizzabolets, R.string.nom_pizzabolets,R.drawable.pizzabolets, R.string.ingredients_pizzabolets, R.string.preparacio_pizzabolets, R.string.temps_pizzabolets ),
            new Recepta(R.string.nom_curt_torradespebrot, R.string.nom_torradespebrot,R.drawable.torradespebrot, R.string.ingredients_torradespebrot, R.string.preparacio_torradespebrot, R.string.temps_torradespebrot ),
    };

    public static Recepta[] Primers_ITEMS = {
            new Recepta(R.string.nom_curt_amanidacarpaccio, R.string.nom_amanidacarpaccio,R.drawable.amanidacarpaccio, R.string.ingredients_amanidacarpaccio, R.string.preparacio_amanidacarpaccio, R.string.temps_amanidacarpaccio ),
            new Recepta(R.string.nom_curt_amanidagambes, R.string.nom_amanidagambes,R.drawable.amanidagambes, R.string.ingredients_amanidagambes, R.string.preparacio_amanidagambes, R.string.temps_amanidagambes ),
            new Recepta(R.string.nom_curt_arrosbacalla, R.string.nom_curt_arrosbacalla,R.drawable.arrosbacalla, R.string.ingredients_arrosbacalla, R.string.preparacio_arrosbacalla, R.string.temps_arrosbacalla),
            new Recepta(R.string.nom_curt_arrosmarmuntanya, R.string.nom_curt_arrosmarmuntanya,R.drawable.arrosmarmuntanya, R.string.ingredients_arrosmarmuntanya, R.string.preparacio_arrosmarmuntanya, R.string.temps_arrosmarmuntanya),
            new Recepta(R.string.nom_curt_fideuadaceps, R.string.nom_curt_fideuadaceps,R.drawable.fideuadaceps, R.string.ingredients_fideuadaceps, R.string.preparacio_fideuadaceps, R.string.temps_fideuadaceps),
            new Recepta(R.string.nom_curt_fideuscassola, R.string.nom_curt_fideuscassola,R.drawable.fideuscassola, R.string.ingredients_fideuscassola, R.string.preparacio_fideuscassola, R.string.temps_fideuscassola),
            new Recepta(R.string.nom_curt_macarronsrovellons, R.string.nom_curt_macarronsrovellons,R.drawable.macarronsrovellons, R.string.ingredients_macarronsrovellons, R.string.preparacio_macarronsrovellons, R.string.temps_macarronsrovellons),
            new Recepta(R.string.nom_curt_mongetatendra, R.string.nom_mongetatendra,R.drawable.mongetatendra, R.string.ingredients_mongetatendra, R.string.preparacio_mongetatendra, R.string.temps_mongetatendra ),
            new Recepta(R.string.nom_curt_mussacabolets, R.string.nom_curt_mussacabolets,R.drawable.mussacabolets, R.string.ingredients_mussacabolets, R.string.preparacio_mussacabolets, R.string.temps_mussacabolets),
            new Recepta(R.string.nom_curt_oumerengat, R.string.nom_curt_oumerengat,R.drawable.oumerengat, R.string.ingredients_oumerengat, R.string.preparacio_oumerengat, R.string.temps_oumerengat),
            new Recepta(R.string.nom_curt_raviolisbolets, R.string.nom_raviolisbolets, R.drawable.raviolis, R.string.ingredients_raviolisbolets, R.string.preparacio_raviolisbolets, R.string.temps_raviolisbolets ),
            new Recepta(R.string.nom_curt_raviolisfoie, R.string.nom_curt_raviolisfoie,R.drawable.raviolisfoie, R.string.ingredients_raviolisfoie, R.string.preparacio_raviolisfoie, R.string.temps_raviolisfoie ),
            new Recepta(R.string.nom_curt_remenatfredolics, R.string.nom_curt_remenatfredolics,R.drawable.remenatfredolics, R.string.ingredients_remenatfredolics, R.string.preparacio_remenatfredolics, R.string.temps_remenatfredolics),
            new Recepta(R.string.nom_curt_risottoceps, R.string.nom_risottoceps,R.drawable.risottoceps, R.string.ingredients_risottoceps, R.string.preparacio_risottoceps, R.string.temps_risottoceps ),
            new Recepta(R.string.nom_curt_sopaall, R.string.nom_curt_sopaall,R.drawable.sopaall, R.string.ingredients_sopaall, R.string.preparacio_sopaall, R.string.temps_sopaall ),
            new Recepta(R.string.nom_curt_sopabolets, R.string.nom_curt_sopabolets,R.drawable.sopabolets, R.string.ingredients_sopabolets, R.string.preparacio_sopabolets, R.string.temps_sopabolets ),
            new Recepta(R.string.nom_curt_sopafarigola, R.string.nom_curt_sopafarigola,R.drawable.sopafarigola, R.string.ingredients_sopafarigola, R.string.preparacio_sopafarigola, R.string.temps_sopafarigola ),
            new Recepta(R.string.nom_curt_sopamiso, R.string.nom_curt_sopamiso,R.drawable.sopamiso, R.string.ingredients_sopamiso, R.string.preparacio_sopamiso, R.string.temps_sopamiso ),
            new Recepta(R.string.nom_curt_tempurarovellons, R.string.nom_curt_tempurarovellons,R.drawable.tempurarovellons, R.string.ingredients_tempurarovellons, R.string.preparacio_tempurarovellons, R.string.temps_tempurarovellons),
    };

    public static Recepta[] Segons_ITEMS = {
            new Recepta(R.string.nom_curt_bacallapilpil, R.string.nom_curt_bacallapilpil,R.drawable.bacallapilpil, R.string.ingredients_bacallapilpil, R.string.preparacio_bacallapilpil, R.string.temps_bacallapilpil),
            new Recepta(R.string.nom_curt_calamarsons, R.string.nom_curt_calamarsons, R.drawable.calamarsons, R.string.ingredients_calamarsons, R.string.preparacio_calamarsons, R.string.temps_calamarsons),
            new Recepta(R.string.nom_curt_calamarsfarcits, R.string.nom_curt_calamarsfarcits,R.drawable.calamarsfarcits, R.string.ingredients_calamarsfarcits, R.string.preparacio_calamarsfarcits, R.string.temps_calamarsfarcits),
            new Recepta(R.string.nom_curt_canelonsrovellons, R.string.nom_curt_canelonsrovellons,R.drawable.canelonsrovellons, R.string.ingredients_canelonsrovellons, R.string.preparacio_canelonsrovellons, R.string.temps_canelonsrovellons),
            new Recepta(R.string.nom_curt_cassolarovellons, R.string.nom_curt_cassolarovellons,R.drawable.cassolarovellons, R.string.ingredients_cassolarovellons, R.string.preparacio_cassolarovellons, R.string.temps_cassolarovellons),
            new Recepta(R.string.nom_curt_conillbolets, R.string.nom_curt_conillbolets, R.drawable.conillbolets, R.string.ingredients_conillbolets, R.string.preparacio_conillbolets, R.string.temps_conillbolets),
            new Recepta(R.string.nom_curt_fricandollenega, R.string.nom_curt_fricandollenega, R.drawable.fricandollenega, R.string.ingredients_fricandollenega, R.string.preparacio_fricandollenega, R.string.temps_fricandollenega),
            new Recepta(R.string.nom_curt_guisatllenegues, R.string.nom_curt_guisatllenegues,R.drawable.guisatllenegues, R.string.ingredients_guisatllenegues, R.string.preparacio_guisatllenegues, R.string.temps_guisatllenegues),
            new Recepta(R.string.nom_curt_mongetesganxet, R.string.nom_curt_mongetesganxet, R.drawable.mongetesganxet, R.string.ingredients_mongetesganxet, R.string.preparacio_mongetesganxet, R.string.temps_mongetesganxet),
            new Recepta(R.string.nom_curt_pollastrecava, R.string.nom_curt_pollastrecava, R.drawable.pollastrecava, R.string.ingredients_pollastrecava, R.string.preparacio_pollastrecava, R.string.temps_pollastrecava),
            new Recepta(R.string.nom_curt_purepatata, R.string.nom_curt_purepatata, R.drawable.purepatata, R.string.ingredients_purepatata, R.string.preparacio_purepatata, R.string.temps_purepatata),
            new Recepta(R.string.nom_curt_rovellonsambceba, R.string.nom_curt_rovellonsambceba, R.drawable.rovellonsambceba, R.string.ingredients_rovellonsambceba, R.string.preparacio_rovellonsambceba, R.string.temps_rovellonsambceba),
    };

    public static Recepta[] Postres_ITEMS = {
            new Recepta(R.string.nom_curt_cremacatalana, R.string.nom_curt_cremacatalana,R.drawable.cremacatalana, R.string.ingredients_cremacatalana, R.string.preparacio_cremacatalana, R.string.temps_cremacatalana),
            new Recepta(R.string.nom_curt_gelatrossinyols, R.string.nom_curt_gelatrossinyols,R.drawable.gelatrossinyols, R.string.ingredients_gelatrossinyols, R.string.preparacio_gelatrossinyols, R.string.temps_gelatrossinyols),
            new Recepta(R.string.nom_curt_matocamagrocs, R.string.nom_curt_matocamagrocs,R.drawable.matocamagrocs, R.string.ingredients_matocamagrocs, R.string.preparacio_matocamagrocs, R.string.temps_matocamagrocs),
            new Recepta(R.string.nom_curt_truitadolsa, R.string.nom_curt_truitadolsa,R.drawable.truitadolsa, R.string.ingredients_truitadolsa, R.string.preparacio_truitadolsa, R.string.temps_truitadolsa),

    };




    /**
     * Obtiene item basado en su identificador
     *
     * @param id identificador
     * @return Coche
     */


}
