package ca.cours5b5.vladimirchrisphonte.activites;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import ca.cours5b5.vladimirchrisphonte.R;
import ca.cours5b5.vladimirchrisphonte.controleurs.ControleurAction;
import ca.cours5b5.vladimirchrisphonte.controleurs.interfaces.Fournisseur;
import ca.cours5b5.vladimirchrisphonte.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.vladimirchrisphonte.global.GCommande;

import static ca.cours5b5.vladimirchrisphonte.global.GConstantes.CODE_CONNEXION_FIREBASE;

public class AMenuPrincipal extends Activite implements Fournisseur {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loadLocale();


        setContentView(R.layout.activity_menu_principal);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.app_name));

        fournirActions();

    }


    private void fournirActions() {

        fournirActionParametres();

        fournirActionDemarrerPartie();

        fournirActionConnexion();

        fournirActionDeconnexion();

        fournirActionJoindreOuCreerPartieReseau();

        fournirActionChangLangage();

    }

    private void fournirActionChangLangage() {

        ControleurAction.fournirAction(this,
                GCommande.CHANGE_LANGUE,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {

                        changerLangueDialog();

                    }
                });
    }

    private void changerLangueDialog() {
        final String[] listItems = {"English", "Deutsch", "Español","Français"};

        AlertDialog.Builder elBuilder = new AlertDialog.Builder(AMenuPrincipal.this);
        elBuilder.setTitle("Choisir une langue");
        elBuilder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0) {
                    setLocale("en");
                    recreate();
                } else if (i == 1) {
                    setLocale("de");
                    recreate();
                } else if (i == 2) {
                    setLocale("es");
                    recreate();
                }

                else if (i == 3) {
                    setLocale("fr");
                    recreate();
                }

                dialogInterface.dismiss();
            }
        });
        AlertDialog leDialog = elBuilder.create();
        leDialog.show();

    }

    private void setLocale(String langue) {

        Locale locale = new Locale(langue);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.setLocale(locale);
        getBaseContext().getResources().updateConfiguration(config,getBaseContext().getResources().getDisplayMetrics());

        SharedPreferences.Editor editor =getSharedPreferences("Settings",MODE_PRIVATE).edit();
        editor.putString("my_lang",langue);
        editor.apply();

    }

    public void loadLocale(){
        SharedPreferences pref =getSharedPreferences("Settings",Activity.MODE_PRIVATE);
        String langage = pref.getString("my_lang","fr");
        setLocale(langage);
    }


    private void fournirActionJoindreOuCreerPartieReseau() {

        ControleurAction.fournirAction(this,
                GCommande.JOINDRE_OU_CREER_PARTIE_RESEAU,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {

                        transitionAttendreAdversaire();
                    }
                });
    }


    private void fournirActionDeconnexion() {

        ControleurAction.fournirAction(this,
                GCommande.DECONNEXION,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {

                        effectuerDeconnexion();

                    }
                });
    }


    private void fournirActionConnexion() {

        ControleurAction.fournirAction(this,
                GCommande.CONNEXION,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {

                        effectuerConnexion();

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

    private void fournirActionParametres() {
        ControleurAction.fournirAction(this,
                GCommande.OUVRIR_MENU_PARAMETRES,
                new ListenerFournisseur() {

                    @Override
                    public void executer(Object... args) {

                        transitionParametres();

                    }
                });
    }

    private void transitionAttendreAdversaire() {

        Intent intentionAttendreAdversaire = new Intent(this, AEnAttenteAdversaire.class);

        startActivity(intentionAttendreAdversaire);

    }


    private void transitionParametres() {

        Intent intentionParametres = new Intent(this, AParametres.class);
        startActivity(intentionParametres);

    }


    private void transitionPartie() {

        Intent intentionPartie = new Intent(this, APartie.class);
        startActivity(intentionPartie);

    }


    private void effectuerConnexion() {

        List<AuthUI.IdpConfig> fournisseursDeConnexion = new ArrayList<>();

        fournisseursDeConnexion.add(new AuthUI.IdpConfig.GoogleBuilder().build());
        fournisseursDeConnexion.add(new AuthUI.IdpConfig.EmailBuilder().build());
        fournisseursDeConnexion.add(new AuthUI.IdpConfig.PhoneBuilder().build());

        Intent intentionConnexion = AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(fournisseursDeConnexion)
                .build();

        this.startActivityForResult(intentionConnexion, CODE_CONNEXION_FIREBASE);

    }


    public void effectuerDeconnexion() {

        AuthUI.getInstance()
                .signOut(this)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    public void onComplete(@NonNull Task<Void> task) {

                        // Rien

                    }
                });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == CODE_CONNEXION_FIREBASE) {

            //IdpResponse response = IdpResponse.fromResultIntent(data);

            if (resultCode == RESULT_OK) {


                FirebaseDatabase.getInstance().getReference("MParametres/YvcwhwdXpbN856LGyQ7eY9uflkD3/parametresPartie/hauteur").setValue(-1);

                // Connexion réussie

            } else {

                // connexion échouée
            }
        }
    }


}
