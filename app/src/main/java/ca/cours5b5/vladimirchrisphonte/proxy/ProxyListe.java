package ca.cours5b5.vladimirchrisphonte.proxy;

import android.app.DownloadManager;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

import java.util.ArrayList;
import java.util.List;

import ca.cours5b5.vladimirchrisphonte.controleurs.Action;
import ca.cours5b5.vladimirchrisphonte.controleurs.ControleurAction;
import ca.cours5b5.vladimirchrisphonte.controleurs.interfaces.Fournisseur;
import ca.cours5b5.vladimirchrisphonte.global.GCommande;
import ca.cours5b5.vladimirchrisphonte.global.GConstantes;

public class ProxyListe extends Proxy implements Fournisseur {

    private ChildEventListener childEventListener;
    private DownloadManager.Query requete;
    private Action actionNouvelItem;
    private List<DatabaseReference> noeudsAjoutes;

    protected Query getRequete(){
        return noeudServeur.orderByValue().limitToLast(GConstantes.NOMBRE_DE_VALEURS_A_CHARGER_DU_SERVEUR_PAR_DEFAUT);
    }

    @Override
    public void connecterAuServeur() {
        super.connecterAuServeur();

         creerListener();

        getRequete().addChildEventListener(childEventListener);
    }

    @Override
    public void deconnecterDuServeur () {

        getRequete().removeEventListener(childEventListener);

        noeudsAjoutes = null;
        super.deconnecterDuServeur();
    }

    @Override
    public void detruireValeurs() {
   // noeudsAjoutes.remove(1);
    }


    public ProxyListe(String cheminServeur) {
        super(cheminServeur);

        noeudsAjoutes = new ArrayList<>();
    }


    public void ajouterValeur(Object valeur) {

        DatabaseReference sousNoeud = noeudServeur.push();

        sousNoeud.setValue(valeur);

        noeudsAjoutes.add(sousNoeud);
    }



    private void creerListener(){

        childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                Object valeurAjoutee = dataSnapshot.getValue();
                if (actionNouvelItem != null) {

                    actionNouvelItem.setArguments(valeurAjoutee);

                    actionNouvelItem.executerDesQuePossible();

                }


            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {



            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };

    }

    public void setActionNouvelItem(GCommande commande){

        actionNouvelItem = ControleurAction.demanderAction(commande);

    }


}
