package ca.cours5b5.vladimirchrisphonte.activites;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import ca.cours5b5.vladimirchrisphonte.controleurs.ControleurAction;
import ca.cours5b5.vladimirchrisphonte.controleurs.interfaces.Fournisseur;
import ca.cours5b5.vladimirchrisphonte.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.vladimirchrisphonte.global.GCommande;
import ca.cours5b5.vladimirchrisphonte.R;


public class AMenuPrincipal extends Activite implements Fournisseur {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        fournirActions();
    }
    private void fournirActions() {

        fournirActionOuvrirMenuParametres();

        fournirActionDemarrerPartie();
    }
    private void fournirActionOuvrirMenuParametres() {

        ControleurAction.fournirAction(this,
                GCommande.OUVRIR_MENU_PARAMETRES,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {

                        transitionAParametres();

                    }
                });
    }
    private void fournirActionDemarrerPartie() {

        ControleurAction.fournirAction(this, GCommande.DEMARRER_PARTIE,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {
                        transitionAPartie();

                    }
                });
    }
    private void transitionAPartie(){
        Intent intentionJouer = new Intent(this, APartie.class);
        this.startActivity(intentionJouer);
    }

    private void transitionAParametres(){
        Intent intentionParametres = new Intent(this, AParametres.class);
        this.startActivity(intentionParametres);
    }

/*

  static{
        Log.d("Atelier04", AMenuPrincipal.class.getSimpleName() + "::static");
    }

    @Override
    protected void onResume() {
        super.onResume();

        // FIXME: c'est temporaire, ça va dans une action (MVC)
        Button bouton = this.findViewById(R.id.button);
        bouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transitionParametres();
            }
        });


        Button bouton2 = this.findViewById(R.id.button2);
        bouton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transitionAPartie();
            }
        });


        // Log.d("Atelier06", AMenuPrincipal.class.getSimpleName() + "::APartie");

    }
*/

}