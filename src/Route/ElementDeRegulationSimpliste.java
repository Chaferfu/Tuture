package Route;

public class ElementDeRegulationSimpliste extends ElementDeRegulation 
{
	public ElementDeRegulationSimpliste(Jonction jonction) 
	{
		super(jonction);
	}
	
	@Override
	public void updateFeuxCarrefour()
	{
		for(Feu f : feux)
		{
			if(f.getCouleurFeu().equals(CouleurFeu.Orange))
			{
				f.updateCouleur();
			}
		}
		for(int i=0;i<feux.size();i++)
		{
			if(feux.get(i).getCouleurFeu().equals(CouleurFeu.Vert))
			{
				feux.get(i).updateCouleur();
				if(++i != feux.size())
				{
					feux.get(i).updateCouleur();
				}
				else
				{
					feux.get(0).updateCouleur();
				}
			}
		}
		boolean unVert=false;;
		for(Feu f : feux)
		{
			if(f.getCouleurFeu().equals(CouleurFeu.Vert))
			{
				unVert=true;
			}
		}
		if(!unVert) feux.get(((int)Math.random())*feux.size()).updateCouleur();
	}


}
