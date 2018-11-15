package ca.cours5b5.vladimirchrisphonte.controleurs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.cours5b5.vladimirchrisphonte.controleurs.interfaces.Fournisseur;
import ca.cours5b5.vladimirchrisphonte.controleurs.interfaces.ListenerGetModele;
import ca.cours5b5.vladimirchrisphonte.donnees.ListenerChargement;
import ca.cours5b5.vladimirchrisphonte.donnees.Serveur;
import ca.cours5b5.vladimirchrisphonte.donnees.SourceDeDonnees;
import ca.cours5b5.vladimirchrisphonte.exceptions.ErreurModele;
import ca.cours5b5.vladimirchrisphonte.modeles.MParametres;

import ca.cours5b5.vladimirchrisphonte.modeles.MPartie;
import ca.cours5b5.vladimirchrisphonte.modeles.Modele;
import ca.cours5b5.vladimirchrisphonte.donnees.Disque;

public final class ControleurModeles {

    private static Map<String, Modele> modelesEnMemoire;
    private static SourceDeDonnees[] sequenceDeChargement;
    private static List<SourceDeDonnees> listeDeSauvegardes;

    static {

        modelesEnMemoire = new HashMap<>();

        listeDeSauvegardes = new ArrayList<>();
        listeDeSauvegardes.add(Disque.getInstance());
        listeDeSauvegardes.add(Serveur.getInstance());

    }

    private ControleurModeles(){}

    public static void setSequenceDeChargement(SourceDeDonnees... sequenceDeChargement){

        ControleurModeles.sequenceDeChargement = sequenceDeChargement;

    }

    public static void sauvegarderModeleDansCetteSource(String nomModele, SourceDeDonnees sourceDeDonnees) {

        Modele modele = modelesEnMemoire.get(nomModele);

        if(modele != null){

            Map<String, Object> objetJson = modele.enObjetJson();

            sourceDeDonnees.sauvegarderModele(nomModele, objetJson);

        }
    }

    static void getModele(final String nomModele, final ListenerGetModele listenerGetModele){

        Modele modele = modelesEnMemoire.get(nomModele);

        if(modele == null){

            creerModeleEtChargerDonnees(nomModele, new ListenerGetModele() {
                @Override
                public void reagirAuModele(Modele modele) {

                    listenerGetModele.reagirAuModele(modele);

                }
            });

        } else {

            //modele n'est pas null
            listenerGetModele.reagirAuModele(modele);

        }

    }
    private static void creerModeleEtChargerDonnees(final String nomModele,
                                                    final ListenerGetModele listenerGetModele) {
        /*
         * Aussi: mémoriser le modèle dans modelesEnMemoire
         */

        creerModeleSelonNom(nomModele, new ListenerGetModele() {
            @Override
            public void reagirAuModele(Modele modele) {

                modelesEnMemoire.put(nomModele,modele);

                chargerDonnees(modele, nomModele, listenerGetModele);

            }
        });



    }
    private static void chargerDonnees(Modele modele,String nomModele,
                                       ListenerGetModele listenerGetModele){

        chargementViaSequence( modele, nomModele,listenerGetModele,0);


        }


    private static void chargementViaSequence(Modele modele,
                                              String cheminDeSauvegarde,
                                              ListenerGetModele listenerGetModele,int indiceSourceCourante){

        if(indiceSourceCourante < sequenceDeChargement.length){

            chargementViaSourceCouranteOuSuivante(modele,cheminDeSauvegarde,listenerGetModele,indiceSourceCourante);

        }
        else{

            terminerChargement(modele,listenerGetModele);
        }

    }


    public static void sauvegarderModele(String nomModele) throws ErreurModele {

        for(SourceDeDonnees source : listeDeSauvegardes){

            sauvegarderModeleDansCetteSource(nomModele, source);

        }

    }


    private static void creerModeleSelonNom(String nomModele, final ListenerGetModele listenerGetModele) throws ErreurModele {

        if(nomModele.equals(MParametres.class.getSimpleName())){

            MParametres mParametres =  new MParametres();
            listenerGetModele.reagirAuModele(mParametres);

        }else if(nomModele.equals(MPartie.class.getSimpleName())){

             getModele(MParametres.class.getSimpleName(), new ListenerGetModele() {
                 @Override
                 public void reagirAuModele(Modele modele) {

                     MParametres mParametres = (MParametres) modele;

                     MPartie mPartie = new MPartie(mParametres.getParametresPartie().cloner());
                     listenerGetModele.reagirAuModele(mPartie);


                 }
             });



        }else{

            throw new ErreurModele("Modèle inconnu: " + nomModele);

        }
    }


    public static void detruireModele(String nomModele) {

        Modele modele = modelesEnMemoire.get(nomModele);

        if(modele != null){

            modelesEnMemoire.remove(nomModele);

            ControleurObservation.detruireObservation(modele);

            if(modele instanceof Fournisseur){

                ControleurAction.oublierFournisseur((Fournisseur) modele);

            }
        }
    }


    private static void chargementViaSourceCouranteOuSuivante(final Modele modele,
                final String cheminDeSauvegarde,
                final ListenerGetModele listenerGetModele,final int indiceSourceCourante) {

        sequenceDeChargement[indiceSourceCourante].chargerModele(cheminDeSauvegarde, new ListenerChargement() {

            @Override
            public void reagirSucces(Map<String, Object> objetJson) {

                terminerChargementAvecDonnees( objetJson, modele, listenerGetModele);

            }

            @Override
            public void reagirErreur(Exception e) {

                chargementViaSourceSuivante( modele,cheminDeSauvegarde,
                       listenerGetModele,indiceSourceCourante);

            }
        });
    }

    private static void terminerChargementAvecDonnees(Map<String, Object> objetJson,
                            Modele modele, ListenerGetModele listenerGetModele) {

        terminerChargement(modele,listenerGetModele);

    }

    private static void terminerChargement(Modele modele,
                                ListenerGetModele listenerGetModele) {

        listenerGetModele.reagirAuModele(modele);

    }

    private static void chargementViaSourceSuivante(Modele modele,
                                    String cheminDeSauvegarde,
                                    ListenerGetModele listenerGetModele,int indiceSourceCourante) {

        chargementViaSequence(modele,cheminDeSauvegarde,listenerGetModele,indiceSourceCourante);

    }

    /*
    private static Modele chargerViaSequenceDeChargement(final String nomModele){

        creerModeleSelonNom(nomModele, new ListenerGetModele() {
            @Override
            public void reagirAuModele(Modele modele) {

                modelesEnMemoire.put(nomModele, modele);


            }
        });

        for(SourceDeDonnees sourceDeDonnees : sequenceDeChargement){

            Map<String, Object> objetJson = sourceDeDonnees.chargerModele();

            if(objetJson != null){

                modele.aPartirObjetJson(objetJson);
                break;


            }

        }

        return modele;


    }
*/

}

