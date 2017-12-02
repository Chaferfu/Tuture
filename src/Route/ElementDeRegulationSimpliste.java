package Route;

public class ElementDeRegulationSimpliste extends ElementDeRegulation 
{
	private int tempsFeuVert;
	
	public ElementDeRegulationSimpliste(Jonction jonction, int t) 
	{
		super(jonction);
		this.tempsFeuVert = t;
	}
	
	public void updateFeuxCarrefour()
	{
		
	}

}
