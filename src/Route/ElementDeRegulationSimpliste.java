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
	 * Très simpliste, met un Feu vert aléatoire 
	 */
	public void updateFeuxCarrefour()
	{
		for(Feu f : feux)
		{
			f.updateCouleur();
		}
	}


}
