package Route;

public class Radar extends Semaphore {

	
	public Radar(Segment s, Sens sens) 
	{
		super(s, sens);
	}
	
	@Override
	public void limiterVitesse(){}

}
