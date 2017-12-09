package Route;

public class ElementDeRegulationSimpliste extends ElementDeRegulation 
{
	private int tempsFeuVert;
	
	public ElementDeRegulationSimpliste(Jonction jonction, int t) 
	{
		super(jonction);
		this.tempsFeuVert = t;
	}
	
	/**
	 * Tr�s simpliste, met un Feu vert al�atoire 
	 */
	public void updateFeuxCarrefour()
	{
		for(Feu f : feux)
		{
			f.updateCouleur();
		}
	}


}
