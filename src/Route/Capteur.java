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
