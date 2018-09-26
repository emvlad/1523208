package ca.cours5b5.vladimirchrisphonte.modeles;


import java.util.Map;

import ca.cours5b5.vladimirchrisphonte.exceptions.ErreurSerialisation;
import ca.cours5b5.vladimirchrisphonte.serialisation.AttributSerialisable;

public class MParametresPartie extends Modele {

 //serialisation - instances
    @AttributSerialisable
    public Integer hauteur;
    protected final String __hauteur = "hauteur";

    @AttributSerialisable
    public Integer largeur;
    protected final String __largeur = "largeur";

    @AttributSerialisable
    public Integer pourGagner;
    protected final String __pourGagner = "pourGagner";

	
	//constructeur
	public MParametresPartie(){
		super();
	}
	
	
	//accesseurs
    public Integer getHauteur() {
        return hauteur;
    }

    public Integer getLargeur() {
        return largeur;
    }

    public Integer getPourGagner() {
        return pourGagner;
    }


	//mutateurs
	  public void setHauteur(int hauteur) {
        this.hauteur = hauteur;

    }

	
	public void setLargeur(int largeur) {
        this.largeur = largeur;
    }
	
    public void setPourGagner(int pourGagner) {
        this.pourGagner = pourGagner;
    }

    
//méthodes
    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) throws ErreurSerialisation {

    }

    @Override
    public Map<String, Object> enObjetJson() throws ErreurSerialisation {
        return null;
    }
	
	
	
	//?????????? MIcMAC ????
    public static PartirMParametres(MParametres mParametres) {
  
	//MParametresPartie instance = MParametresPartie();
        return instance;
		
		 /*
   Retourne une instance de MParametresPartie   
   avec les mêmes hauteur/largeur/pourGagner
   que le parameètre reçu en argument
   
   */
    }
}

