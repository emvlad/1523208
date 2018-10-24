package ca.cours5b5.vladimirchrisphonte.activites;



import android.os.Bundle;


import ca.cours5b5.vladimirchrisphonte.R;
import ca.cours5b5.vladimirchrisphonte.controleurs.ControleurModeles;
import ca.cours5b5.vladimirchrisphonte.controleurs.interfaces.Fournisseur;
import ca.cours5b5.vladimirchrisphonte.modeles.MParametres;



public class AParametres extends Activite implements Fournisseur {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametres);
    }

    @Override
    protected void onPause() {
        super.onPause();

        ControleurModeles.sauvegarderModele(MParametres.class.getSimpleName());

    }

    /*
    static{
        Log.d("Atelier04", AParametres.class.getSimpleName() + "::static");
    }
*/
    /*
    private void restaurerParametres(Bundle savedInstanceState){

        String json = savedInstanceState.getString(GConstantes.cle);

        Map<String, Object> objetJson = Jsonification.aPartirChaineJson(json);

        MParametres.instance.aPartirObjetJson(objetJson);
        MParametres.instance = new MParametres();

        Log.d("Atelier05", AParametres.class.getSimpleName() + "::restaurerParametres, clé: " + GConstantes.cle);
        Log.d("Atelier05", AParametres.class.getSimpleName() + "::restaurerParametres, json:\n" + json);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        this.sauvegarderParametres(outState);

    }

    private void sauvegarderParametres(Bundle outState){

        Map<String, Object> objetJson = MParametres.instance.enObjetJson();

        String json = Jsonification.enChaineJson(objetJson);
        outState.putString(GConstantes.cle, json);

        Log.d("Atelier05", AParametres.class.getSimpleName() + "::sauvegarderParametres, clé: " + GConstantes.cle);
        Log.d("Atelier05", AParametres.class.getSimpleName() + "::sauvegarderParametres, json: \n" + json);


    }

*/
}