package ca.cours5b5.vladimirchrisphonte.modeles;

import java.util.Map;

import ca.cours5b5.vladimirchrisphonte.controleurs.ControleurAction;
import ca.cours5b5.vladimirchrisphonte.controleurs.interfaces.Fournisseur;
import ca.cours5b5.vladimirchrisphonte.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.vladimirchrisphonte.exceptions.ErreurAction;
import ca.cours5b5.vladimirchrisphonte.exceptions.ErreurSerialisation;
import ca.cours5b5.vladimirchrisphonte.global.GCommande;
import ca.cours5b5.vladimirchrisphonte.global.GConstantes;
import ca.cours5b5.vladimirchrisphonte.serialisation.AttributSerialisable;

public class MPartieReseau extends MPartie implements Fournisseur, Identifiable {

    @AttributSerialisable
    public String idJoueurInvite;
    private String __idJoueurInvite = GConstantes.CLE_ID_JOUEUR_INVITE;

    @AttributSerialisable
    public String idJoueurHote;
    private String __idJoueurHote = GConstantes.CLE_ID_JOUEUR_HOTE;

    @Override
    public String getId() {
       return idJoueurHote;
    }

    public MPartieReseau(MParametresPartie parametres) {
        super(parametres);

    }

    private void fournirActionRecevoirCoup() {

        ControleurAction.fournirAction(this,
                GCommande.RECEVOIR_COUP_RESEAU,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {

                    }
                });


    }
    @Override
    protected void fournirActionPlacerJeton () {
        /*
         * En plus de jouer le coup, le transmettre via
         * le ControleurPartieReseau
         *
         * ATTENTION au @Override. Le code qui fournit l'action
         * PLACER_JETON dans la classe parent MPartie
         * ne doit **pas** s'exécuter
         */
        ControleurAction.fournirAction(this,
                GCommande.JOUER_COUP_ICI,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {
                        try{

                            int colonne = (Integer) args[0];

                            jouerCoup(colonne);


                        }catch(ClassCastException e){

                            throw new ErreurAction(e);

                        }
                    }
                });

    }
    @Override
    public void aPartirObjetJson (Map < String, Object > objetJson) throws ErreurSerialisation {
        /*
         * charger les champs
         * appeler aussi super
         */

        idJoueurHote = (String) objetJson.get(__idJoueurHote);
        idJoueurInvite = (String) objetJson.get(__idJoueurInvite);

        super.aPartirObjetJson(enObjetJson());
    }

    @Override
    public Map<String, Object> enObjetJson () throws ErreurSerialisation {
        /*
         * sauvegarder les champs
         * appeler aussi super
         */

        Map<String, Object> objetJson = super.enObjetJson();

        objetJson.put(__idJoueurHote, idJoueurHote);
        objetJson.put(__idJoueurInvite, idJoueurInvite);

        return objetJson;
    }
    private void recevoirCoupReseau(int colonne) {

    }

    public void setIdJoueurs(String idJoueurHote, String idJoueurInvite){

    }

}

