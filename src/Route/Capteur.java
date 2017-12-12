package Route;

import java.util.Observable;
import java.util.Observer;

public class Capteur implements Observer
{
	private Segment segment;
	private Sens sens;
	private int distanceAvantFinRoute;
	private String informationPassage;
	private boolean uneVoitureEstPasseeIciMonGars;
	
	public void update(Observable obs, Object obj) 
	{
		System.out.println("hey");
		try
		{
			
			Voiture v = (Voiture)obs;
			if(uneVoitureEstPasseeIciMonGars==true)
			{
				informationPassage = "il y a un risque de collision entre "+ informationPassage;
			}
			else
			{
				uneVoitureEstPasseeIciMonGars = true;
				informationPassage="voiture passé devant capteur segment "+ segment.getId()+" : ";
			}
			if(v.getDistanceAvantFinRoute()<distanceAvantFinRoute)
			{
				informationPassage += " [" + v.getId() + "]";
			}
		}catch(ClassCastException e)
		{
			System.out.println("oula qu'est-ce qu'il se passe");
		}
		
		
	}
	public void reinitialiseCapteur()
	{
		informationPassage = "";
		uneVoitureEstPasseeIciMonGars = false;
	}
	
	public Capteur(Segment s, Sens S, int p) 
	{
		segment = s;
		this.sens = S;
	}

	
	public String getInformationPassage() {
		return informationPassage;
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
