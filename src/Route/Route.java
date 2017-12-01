package Route;

import java.util.ArrayList;

public abstract class Route 
{

	

	public void avancerVoitures() {};
	private int longueur;
	private ArrayList<Voiture> lvoitures = new ArrayList<Voiture>();
	private String id;

	
	public Route(String id) 
	{
		this.id=id;
	}


	public ArrayList<Voiture> getlVoitures() {
		return lvoitures;
	}


	public void setlVoitures(ArrayList<Voiture> lvoitures) {
		this.lvoitures = lvoitures;
	}

	
}
