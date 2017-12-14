package Route;

import java.util.Observable;

public class CapteurVitesse extends Capteur 
{
	public CapteurVitesse(Segment s, Sens S, int p) 
	{
		super(s, S, p);
	}

	@Override
	public void update(Observable obs, Object obj) 
	{
		super.update(obs,obj);
		try
		{
			Voiture v = (Voiture)obs;		
			if(v.getDistanceAvantFinRoute()<distanceAvantFinRoute)
			{
				informationPassage += " [VITESSE : " + v.getVitesseCourante() + "]";
				v.deleteObserver(this);
			}
		}catch(ClassCastException e)
		{
			System.out.println("Il y a un observable n'�tant pas une voiture qui a �t� rep�r� par un capteur");
		}
		
		
	}

}
