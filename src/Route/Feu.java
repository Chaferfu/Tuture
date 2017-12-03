package Route;

public abstract class Feu extends Semaphore 
{

	protected CouleurFeu couleurFeu;
	
	@Override
	public void limiterVitesse() {}
	
	public Feu(Segment segment,  Sens sens) 
	{

		super(segment, sens);
	}

}
