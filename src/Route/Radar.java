package Route;

public class Radar extends Semaphore {

	private int limite;
	
	public Radar(int l, Sens sens) 
	{
		super(sens);
		limite = l;
	}
	
	@Override
	public void limiterVitesse(){}

}
