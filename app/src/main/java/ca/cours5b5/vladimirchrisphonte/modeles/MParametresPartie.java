package ca.cours5b5.vladimirchrisphonte.modeles;


import java.util.HashMap;
import java.util.Map;

import ca.cours5b5.vladimirchrisphonte.exceptions.ErreurSerialisation;
import ca.cours5b5.vladimirchrisphonte.global.GConstantes;
import ca.cours5b5.vladimirchrisphonte.serialisation.AttributSerialisable;

public class MParametresPartie extends Modele {
    private static MParametres instanceParam = new MParametres();
    @AttributSerialisable
    private Integer hauteur;
    private final String __hauteur = "hauteur";


    @AttributSerialisable
    private Integer largeur;
    private final String __largeur = "largeur";

    @AttributSerialisable
    private Integer pourGagner;
    private final String __pourGagner = "pourGagner";

 

    //constructeur
    public MParametresPartie(Integer hauteur, Integer largeur, Integer pourGagner) {
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.pourGagner = pourGagner;
    }

    public Integer getHauteur() {
        return hauteur;
    }

    public Integer getLargeur() {
        return largeur;
    }

    public Integer getPourGagner() {
        return pourGagner;
    }


    public void setPourGagner(int pourGagner) {
        this.pourGagner = pourGagner;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public void setHauteur(int hauteur) {this.hauteur = hauteur;

    }

    public MParametresPartie () {
        this.setHauteur(GConstantes.HAUTEUR_PAR_DEFAUT);
        this.setLargeur(GConstantes.LARGEUR_PAR_DEFAUT);
        this.setPourGagner(GConstantes.POUR_GAGNER_PAR_DEFAUT);

    }
    public MParametresPartie cloner(){
        MParametresPartie instanceParampartie = new MParametresPartie(
                instanceParam.hauteur,
                instanceParam.largeur,
                instanceParam.pourGagner);

        return instanceParampartie;
        /*
         * Retournne une instance de MParametresPartie avec exactement les mêmes
         * hauteur/largeur/pourGagner que l'objet courant
         */
    }

    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) throws ErreurSerialisation {
        for(Map.Entry<String, Object> entry: enObjetJson().entrySet()) {
            String cle = entry.getKey();

            if (cle.equals(__hauteur)) {
                setHauteur(Integer.valueOf(((String)entry.getValue())));
            } else  if (cle.equals(__largeur)) {
                setLargeur(Integer.valueOf(((String)entry.getValue())));
            } else {
                setPourGagner(Integer.valueOf(((String)entry.getValue())));
            }
        }

    }

    @Override
    public Map<String, Object> enObjetJson() throws ErreurSerialisation {

        Map<String, Object> enObjetJson = new HashMap<>();

        enObjetJson.put(__hauteur,getHauteur().toString());
        enObjetJson.put(__largeur, getLargeur().toString());
        enObjetJson.put(__pourGagner, getPourGagner().toString());

        return this.enObjetJson();

    }



}

