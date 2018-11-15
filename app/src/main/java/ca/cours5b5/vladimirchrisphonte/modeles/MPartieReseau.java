package ca.cours5b5.vladimirchrisphonte.modeles;

import java.util.Map;

import ca.cours5b5.vladimirchrisphonte.controleurs.interfaces.Fournisseur;
import ca.cours5b5.vladimirchrisphonte.exceptions.ErreurSerialisation;
import ca.cours5b5.vladimirchrisphonte.serialisation.AttributSerialisable;

public class MPartieReseau extends MPartie implements Fournisseur, Identifiable {

    @AttributSerialisable
    public String idJoueurInvite;
    private String __idJoueurInvite;

    @AttributSerialisable
    public String idJoueurHote;
    private String __idJoueurHote;

    @Override
    public String getId() {

        /*
         * utiliser l'id du joueur hôte
         */
        return idJoueurHote;
    }

    public MPartieReseau(MParametresPartie parametres) {
        super(parametres);


    }

    private void fournirActionRecevoirCoup() {
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

        }

    }

    private void recevoirCoupReseau(int colonne) {
        @Override
        public void aPartirObjetJson (Map < String, Object > objetJson) throws ErreurSerialisation {
            /*
             * charger les champs
             * appeler aussi super
             */

        }
            @Override
            public Map<String, Object> enObjetJson () throws ErreurSerialisation {
                /*
                 * sauvegarder les champs
                 * appeler aussi super
                 */
            }
        }
    }

