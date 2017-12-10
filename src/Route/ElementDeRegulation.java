package Route;

import java.util.ArrayList;

public abstract class ElementDeRegulation 
{
	protected ArrayList<Capteur> capteurs = new ArrayList<Capteur>();
	protected Jonction jonction;
	protected ArrayList<Feu> feux = new ArrayList<Feu>();
	
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
			if(temp.equals(Sens.Un))
			{
				feux.add(s.getFeu1());
			}
			else
			{
				feux.add(s.getFeu2());
			}
			for(Capteur c : s.getCapteurs())
			{
				if(c.getSens().equals(temp))
				{
					capteurs.add(c);
				}
			}
		}
		initFeux();
	}
	public void initFeux()
	{
		for(Feu f : feux)
		{
			f.setCouleurFeu(CouleurFeu.Rouge);
		}	
		feux.get(0).setCouleurFeu(CouleurFeu.Vert);
	}
	abstract public void updateFeuxCarrefour();

	
	@Override
	public String toString() {
		return "ElementDeRegulation " + getClass() + " [capteurs=" + capteurs + ", jonction=" + jonction + ", feux=" + feux + "]";
	}
	
	
	


}
