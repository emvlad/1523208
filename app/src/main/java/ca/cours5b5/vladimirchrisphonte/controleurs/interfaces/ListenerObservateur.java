package ca.cours5b5.vladimirchrisphonte.controleurs.interfaces;

import ca.cours5b5.vladimirchrisphonte.modeles.Modele;

public abstract class ListenerObservateur {

    public void reagirNouveauModele(Modele modele){
        //implantation par défaut est d'appeler reagirChangementAuModele


        reagirChangementAuModele(modele);
    }

        public abstract  void reagirChangementAuModele(Modele modele);



}
