package Route;

import java.util.ArrayList;

public class Segment extends Route 
{
	private static int compteur = 0;
	private int id;
	
	private Jonction[] jonctions = new Jonction[2];
	private ArrayList<Capteur> capteurs = new ArrayList<Capteur>();
	
	public Segment() 
	{
		this.id=compteur;
		compteur++;
		// TODO Auto-generated constructor stub
	}
	

}
