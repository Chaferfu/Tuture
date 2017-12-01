package Route;

import java.util.ArrayList;

public abstract class Route 
{
	public static void intervalleTemps() {};
	private int longueur;
	private ArrayList<Voiture> voitures = new ArrayList<Voiture>();
	private String id;
	
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
	
	

}
