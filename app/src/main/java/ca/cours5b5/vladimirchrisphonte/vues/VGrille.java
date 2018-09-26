package ca.cours5b5.vladimirchrisphonte.vues;

public class VGrille extends GridLayout{
	
	
	//instances
	private nombreRangees;
	
	//Glance!
	private class Colonne extends ArrayList<VCase>{}
	
	private List<Colonne> colonnesDeCases;
	private List<VEntete> entetes;
	
	
	//le(s) constructeur(s)
		
	public VGrille (Context context){}
	
	public VGrille (Context context, AttributeSet attrs){}
	
	public VGrille (Context context, AttributeSet attrs, int defStyleAttr){}
	
	
	//les méthodes
	@Override
	protected void onFinishInflate(){}
	
	private void initialiser(){}
	
	private void creerGrille(int hauteur, int largeur){}
	private void initialiserColonnes(int largeur){}
	
	private void ajouterEntetes(int largeur)
	
	private LayoutParams getMiseEnPageEntete(int colonne){}
	private void ajouterCases(int hauteur, int largeur){}
	
	private LayoutParams getMiseEnPageCase(int rangee, int colonne){}
	
	
	
	
	
	
}
