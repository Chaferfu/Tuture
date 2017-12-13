package Route;

import java.util.Observable;
import java.util.Observer;

public class Capteur implements Observer
{
	private Segment segment;
	private Sens sens;
	private int distanceAvantFinRoute;
	private String informationPassage;
	private String informationCollision;
	private boolean uneVoitureEstPasseeIciMonGars;
	
	@Override
	public void update(Observable obs, Object obj) 
	{
		try
		{
			Voiture v = (Voiture)obs;		
			if(v.getDistanceAvantFinRoute()<distanceAvantFinRoute)
			{
				if(uneVoitureEstPasseeIciMonGars==true)
				{
					informationCollision = "|Risque COLLISION|";
				}
				else
				{
					uneVoitureEstPasseeIciMonGars = true;
					informationPassage="voiture passé devant capteur segment "+ segment.getId()+" : ";
				}
				informationPassage += " [" + v.getId() + "]";
				v.deleteObserver(this);
			}
		}catch(ClassCastException e)
		{
			System.out.println("oula qu'est-ce qu'il se passe");
		}
		
		
	}
	public void reinitialiseCapteur()
	{
		informationPassage = "";
		informationCollision = "";
		uneVoitureEstPasseeIciMonGars = false;
	}
	
	public Capteur(Segment s, Sens S, int p) 
	{
		segment = s;
		this.sens = S;
		this.distanceAvantFinRoute=p;
	}

	
	public String getInformationPassage() 
	{
		return informationCollision+" "+informationPassage;
	}
	public void setInformationPassage(String informationPassage) {
		this.informationPassage = informationPassage;
	}
	public boolean isUneVoitureEstPasseeIciMonGars() {
		return uneVoitureEstPasseeIciMonGars;
	}
	public void setUneVoitureEstPasseeIciMonGars(boolean uneVoitureEstPasseeIciMonGars) {
		this.uneVoitureEstPasseeIciMonGars = uneVoitureEstPasseeIciMonGars;
	}
	@Override
	public String toString() {
		return "Capteur " +  getClass() + " [segment=" + segment + ", sens=" + sens + ", position=" + distanceAvantFinRoute  + "]";
	}
	
	
	/**
	 * @return the sens
	 */
	public Sens getSens() {
		return sens;
	}


	/**
	 * @param sens the sens to set
	 */
	public void setSens(Sens sens) {
		this.sens = sens;
	}
	
}
