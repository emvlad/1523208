package ca.cours5b5.vladimirchrisphonte.modeles;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ca.cours5b5.vladimirchrisphonte.exceptions.ErreurSerialisation;
import ca.cours5b5.vladimirchrisphonte.global.GCouleur;
import ca.cours5b5.vladimirchrisphonte.global.GDirection;


public class MGrille extends Modele {

    private List<MColonne> colonnes;

    public boolean siCouleurGagne(GCouleur couleur, int pourGagner) {
        return true;
    }

    private boolean siCouleurGagneCetteColonne(GCouleur couleur, int idColonne, int pourGagner) {
        return true;
    }

    private boolean siCouleurGagneCetteCase(GCouleur couleur, int idColonne, int idRangee, int pourGagner) {
        return true;
    }



    private boolean siCouleurGagneDansCetteDirection(GCouleur couleur, int idColonne, int idRangee, GDirection direc){
      return  true;
    }

    private boolean siMemeCouleurCetteCase(GCouleur couleur, int idColonne, int idRangee) {
        return true;
    }




    public MGrille(int largeur) {

        colonnes = new ArrayList<>();

        initialiserColonnes(largeur);

    }

    private void initialiserColonnes(int largeur) {

        for (int i = 0; i < largeur; i++) {

            colonnes.add(new MColonne());

        }
    }


    public List<MColonne> getColonnes() {
        return colonnes;
    }


    public void placerJeton(int colonne, GCouleur couleur) {

        colonnes.get(colonne).placerJeton(couleur);

    }

    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) throws ErreurSerialisation {

        throw new UnsupportedOperationException();

    }

    @Override
    public Map<String, Object> enObjetJson() throws ErreurSerialisation {

        throw new UnsupportedOperationException();

    }

}
