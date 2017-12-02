package Route;

public class Radar extends Semaphore {

	@Override
	public void limiteVitesse()
	{
		//TODO
	}
	
	public Radar(Segment s, Sens sens) 
	{
		super(s, sens);
	}

}
