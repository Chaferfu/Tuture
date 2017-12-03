package Route;

import java.util.ArrayList;

public abstract class ElementDeRegulation 
{
	private ArrayList<Capteur> capteurs = new ArrayList<Capteur>();
	private Jonction jonction;
	private ArrayList<Feu> feux = new ArrayList<Feu>();
	
	/**
	 * Constructeur à appeler après création des feux sur les segments attaché à une jonction.
	 * @param jonction
	 */
	public ElementDeRegulation(Jonction jonction) 
	{
		this.jonction = jonction;
		
		for(Segment s: jonction.getSegments())
		{
			Sens temp = s.sensVersJonction(jonction);
			for(Semaphore f : s.getSemaphores())
			{
				
			}
		}
	}
	public void updateFeuxCarrefour()
	{
		
	}


}
