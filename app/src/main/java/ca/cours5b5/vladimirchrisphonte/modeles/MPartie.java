package ca.cours5b5.vladimirchrisphonte.modeles;

public class MPartie extends Modele{
	
	
	//serialisations - instances
	@AttributSerialisable
    public MParametresPartie parametres ;
	private final String __parametres ="parametres";
	
	
	
	//Le constructeur
	//accesseurs
	//mutateurs
	  
	  
	 
	//méthodes	  
	  public MPartie(MParametresPartie parametres){}
	  
	  public MParametresPartie getParametres(){}
	  
	  @Override
	  public Map<String, Object> enObjetJson() throws ErreurSerialisation{ //not use for now	  }
}
