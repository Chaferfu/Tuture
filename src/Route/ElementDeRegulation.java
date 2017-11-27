package Route;

import java.util.ArrayList;

public class ElementDeRegulation 
{
	private ArrayList<Capteur> capteurs = new ArrayList<Capteur>();
	private Jonction jonction;
	private ArrayList<Semaphore> semaphores = new ArrayList<Semaphore>();
	
	public ElementDeRegulation(Jonction jonction) 
	{
		this.jonction = jonction;
	}

}
