package Route;

import java.util.Observable;
import java.util.Observer;

public class Capteur implements Observer
{
	protected Segment segment;
	protected Sens sens;
	protected int distanceAvantFinRoute;
	protected String informationPassage;
	protected String informationCollision;
	protected boolean uneVoitureEstPasseeIciMonGars;
	protected int nbrVoiture=0;
	
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
				nbrVoiture++;
				v.deleteObserver(this);
			}
		}catch(ClassCastException e)
		{
			System.out.println("Il y a un observable n'étant pas une voiture qui a été repéré par un capteur");
		}
		
		
	}
	public void reinitialiseCapteur()
	{
		informationPassage = "";
		informationCollision = "";
		uneVoitureEstPasseeIciMonGars = false;
		nbrVoiture=0;
	}
	
	public Capteur(Segment s, Sens S, int p) 
	{
		segment = s;
		this.sens = S;
		this.distanceAvantFinRoute=p;
	}
	public Feu getFeu()
	{
		if(sens.equals(Sens.Un))
		{
			return segment.getFeu1();
		}
		else
		{
			return segment.getFeu2();
		}
	}
	
	public int getNbrVoiture() {
		return nbrVoiture;
	}
	public void setNbrVoiture(int nbrVoiture) {
		this.nbrVoiture = nbrVoiture;
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
	
	
	public Segment getSegment() {
		return segment;
	}
	public void setSegment(Segment segment) {
		this.segment = segment;
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
