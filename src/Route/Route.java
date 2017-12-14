package Route;

import java.util.ArrayList;

public abstract class Route 
{
	private String id;
	private int longueur;
	private ArrayList<Voiture> lvoitures = new ArrayList<Voiture>();
	
	
	@Override
	public String toString() {
		return id + " : longueur=" + longueur + ", contient les voitures :" + lvoitures + " ";
	}

	public Route(String id) 
	{
		this.id=id;
	}
	
	public Route(String id, int l) 
	{
		this.id=id;
		longueur = l;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public int getLongueur() {
		return longueur;
	}


	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}


	public ArrayList<Voiture> getLvoitures() {
		return lvoitures;
	}


	public void setLvoitures(ArrayList<Voiture> lvoitures) {
		this.lvoitures = lvoitures;
	}
	

	public Route prochaineRoute(Voiture v) {
		return null;
	}
	public abstract CouleurFeu couleurFeu(Voiture v,boolean affichage);
	public abstract void addObserverCapteur(Voiture v);
	



	public int getvmax(Sens s) 
	{

		return 0;
	}
	

}
