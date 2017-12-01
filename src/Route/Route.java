package Route;

import java.util.ArrayList;

public abstract class Route 
{
	private int longueur;
	private ArrayList<Voiture> voitures = new ArrayList<Voiture>();
	private String id;
	
	public Route(String id) 
	{
		this.id=id;
	}

}
