package Route;

import java.util.ArrayList;

public abstract class ElementDeRegulation 
{
	private ArrayList<Capteur> capteurs = new ArrayList<Capteur>();
	private Jonction jonction;
	private ArrayList<Feu> feux = new ArrayList<Feu>();
	
	/**
	 * Constructeur � appeler apr�s cr�ation des feux sur les segments attach� � une jonction.
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
