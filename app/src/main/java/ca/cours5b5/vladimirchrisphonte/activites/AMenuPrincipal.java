package ca.cours5b5.vladimirchrisphonte.activites;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.List;

import ca.cours5b5.vladimirchrisphonte.R;
import ca.cours5b5.vladimirchrisphonte.controleurs.ControleurAction;
import ca.cours5b5.vladimirchrisphonte.controleurs.interfaces.Fournisseur;
import ca.cours5b5.vladimirchrisphonte.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.vladimirchrisphonte.global.GCommande;
import ca.cours5b5.vladimirchrisphonte.global.GConstantes;

import static ca.cours5b5.vladimirchrisphonte.global.GConstantes.CODE_CONNEXION_FB;

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

        fournirConnexion();
        fournirDeConnexion();
    }

    private void fournirActionOuvrirMenuParametres() {

        ControleurAction.fournirAction(this,
                GCommande.OUVRIR_MENU_PARAMETRES, new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {

                        transitionParametres();

                    }
                });
    }

    private void fournirActionDemarrerPartie() {

        ControleurAction.fournirAction(this,
                GCommande.DEMARRER_PARTIE,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {

                        transitionPartie();

                    }
                });
    }

    private void fournirConnexion(){

        ControleurAction.fournirAction(this,
                GCommande.CONNEXION,
                new ListenerFournisseur() {
            @Override
            public void executer(Object... args) {
                transitionConnexion();
            }
        });
    }

    private void fournirDeConnexion(){

        ControleurAction.fournirAction(this,
                GCommande.DECONNEXION,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {
                        transitionDeConnexion();
                    }
                });
    }



    private void transitionParametres(){

        Intent intentionParametres = new Intent(this, AParametres.class);
        startActivity(intentionParametres);

    }

    private void transitionPartie(){

        Intent intentionParametres = new Intent(this, APartie.class);
        startActivity(intentionParametres);

    }

    private void transitionConnexion(){
        List<AuthUI.IdpConfig> fournisseursDeConnexion = new ArrayList<>();

        fournisseursDeConnexion.add(new AuthUI.IdpConfig.GoogleBuilder().build());
        fournisseursDeConnexion.add(new AuthUI.IdpConfig.EmailBuilder().build());
        fournisseursDeConnexion.add(new AuthUI.IdpConfig.PhoneBuilder().build());

        Intent intentionConnexion = AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(fournisseursDeConnexion)
                .build();

        this.startActivityForResult(intentionConnexion,  CODE_CONNEXION_FB);
    }
    private void transitionDeConnexion(){

        AuthUI.getInstance()
                .signOut(this)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    public void onComplete(@NonNull Task<Void> task) {

        // Déconnexion terminée
                    }
                });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == CODE_CONNEXION_FB ) {

            Button disconnect = findViewById(R.id.button_deconnexion);
            Button connect = findViewById(R.id.button_connexion);

            if (resultCode == RESULT_OK) {

                disconnect.setVisibility(View.VISIBLE);
                connect.setVisibility(View.INVISIBLE);

            } else {

                disconnect.setVisibility(View.INVISIBLE);
                connect.setVisibility(View.VISIBLE);


            }
        }
    }

    private void fournirActionJoindreOuCreerPartieReseau() {




    }


        private void transitionPartieReseau () {
            /*
             * Ajouter le FIXME_JSON_PARTIE_RESEAU dans les Extras de l'intention
             *
             */


        }
    }
