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
		if(feux.size()>0)
		{
			if(!feuInit())
			{
				for(Feu f : feux)
				{
					f.setCouleurFeu(CouleurFeu.Rouge);
				}	
				feux.get(0).setCouleurFeu(CouleurFeu.Vert);
			}
			else
			{
				changeCouleurFeux();
			}
		}
		else
		{
			System.out.println("Attention, il n'y a pas de feux à la jonction "+ jonction);
		}
	}
	public boolean feuInit()
	{
		int nbrFeuVert=0;
		for(Feu f : feux)
		{
			if(f.getCouleurFeu().equals(CouleurFeu.Vert))
			{
				nbrFeuVert++;
			}
		}
		if(nbrFeuVert != 1)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	public void changeCouleurFeux()
	{
		//TODO
	}

}
