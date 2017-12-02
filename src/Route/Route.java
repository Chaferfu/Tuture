package Route;

import java.util.ArrayList;

public abstract class Route 
{
	private String id;
	private int longueur;
	private ArrayList<Voiture> lvoitures = new ArrayList<Voiture>();

	public abstract void avancerVoitures();
	
	
	@Override
	public String toString() {
		return id + " : longueur=" + longueur + ", contient les voitures :" + lvoitures + " ";
	}

	public Route(String id) 
	{
		this.id=id;
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

	
}
