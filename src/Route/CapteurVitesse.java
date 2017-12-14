package Route;

import java.util.Observable;

public class CapteurVitesse extends Capteur 
{
	public CapteurVitesse(Segment s, Sens S, int p) 
	{
		super(s, S, p);
	}
	
	/**
	 * redéfinition de update pour rajouter de l'information d'affichage.
	 */
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
			System.out.println("Il y a un observable n'étant pas une voiture qui a été repéré par un capteur");
		}
		
		
	}

}
