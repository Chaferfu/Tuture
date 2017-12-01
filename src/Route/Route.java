package Route;

import java.util.ArrayList;

public abstract class Route 
{
	public void avancerVoitures() {};
	protected int longueur;
	protected ArrayList<Voiture> lvoitures = new ArrayList<Voiture>();
	
	
	public Route() 
	{
		// TODO Auto-generated constructor stub
	}


	public ArrayList<Voiture> getlVoitures() {
		return lvoitures;
	}


	public void setlVoitures(ArrayList<Voiture> lvoitures) {
		this.lvoitures = lvoitures;
	}

	
}
