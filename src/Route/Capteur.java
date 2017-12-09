package Route;

public abstract class Capteur 
{
	private Segment segment;
	private ElementDeRegulation elementDeRegulation;
	private Sens sens;
	private int position;
	
	
	public Capteur(Segment s, ElementDeRegulation e, Sens S, int p) 
	{
		segment = s;
		elementDeRegulation = e;
		this.sens = S;
		position=p;
	}


	@Override
	public String toString() {
		return "Capteur " +  getClass() + " [segment=" + segment + ", sens=" + sens + ", position=" + position  + "]";
	}
	
	
	
	
}
