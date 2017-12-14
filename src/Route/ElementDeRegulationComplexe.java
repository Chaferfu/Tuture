package Route;

public class ElementDeRegulationComplexe extends ElementDeRegulation 
{

	public ElementDeRegulationComplexe(Jonction jonction) 
	{
		super(jonction);
	}

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
	}

}
