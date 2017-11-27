package Route;

public abstract class Capteur 
{
	private Segment segment;
	private ElementDeRegulation elementDeRegulation;
	
	public Capteur(Segment s, ElementDeRegulation e) 
	{
		segment = s;
		elementDeRegulation = e;
	}

}
