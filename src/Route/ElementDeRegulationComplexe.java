package Route;

public class ElementDeRegulationComplexe extends ElementDeRegulation 
{

	public ElementDeRegulationComplexe(Jonction jonction) 
	{
		super(jonction);
	}
	
	
	/**
	 * Algorithme qui va changer la couleur des feux en fonction des détéctions des capteurs
	 */
	@Override
	public void updateFeuxCarrefour()
	{
		if(capteurs.size()>0)
		{
			Capteur temp=null;
			for(Capteur c : capteurs)
			{
				if(temp!=null)
				{
					if(temp.getNbrVoiture()<c.getNbrVoiture())
					{
						temp=c;
					}
				}
				else
				{
					temp =c;
				}
			}

			if(temp.getNbrVoiture()!=0)
			{
				for(Feu f : feux)
				{
					if(f.getCouleurFeu().equals(CouleurFeu.Orange))
					{
						f.updateCouleur();
					}
				}
				temp.getFeu().setCouleurFeu(CouleurFeu.Vert);
				System.out.println("||ATTENTION FEU VERT INTELLIGENT|| "+temp.getSegment().getId());
			}
			else
			{
				updateSimpliste();
			}
			
		}
		else
		{
			updateSimpliste();
		}
		
	}
	
	/**
	 * algorithme simpliste utilisé s'il n'y a pas de capteurs présents
	 */
	public void updateSimpliste()
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
