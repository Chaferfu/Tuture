package Route;

public abstract class Semaphore 
{
	
	private Segment segment;
	private Sens sens;
	
	/**
	 * fonction qui détermine la vitesse des voitures sur un segment 
	 * en fonction du sens du sémaphore et du type de semaphore.
	 */
	
	public Semaphore(Segment s, Sens sens) 
	{
		segment = s;
		this.sens = sens;
	}
	
	
	
	public Sens getSens() {
		return sens;
	}

	public void setSens(Sens sens) {
		this.sens = sens;
	}

	public Semaphore(Sens sens) 
	{
		this.sens = sens;
	}

	public void setSegment(Segment segment) {
		this.segment = segment;
	}
	
	
	public Segment getSegment() {
		return segment;
	}



	abstract public void limiterVitesse();



	@Override
	public String toString() {
		return "Semaphore " + getClass() + " [segment=" + segment.getId()+ ", sens=" + sens + "]";
	}
	
	
	
	
}
