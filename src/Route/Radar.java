package Route;

public class Radar extends Semaphore {

	@Override
	public void limiteVitesse()
	{
		//TODO
	}
	
	public Radar(ElementDeRegulation e, Segment s, Sens sens) 
	{
		super(e, s, sens);
	}

}
