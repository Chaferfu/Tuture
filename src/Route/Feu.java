package Route;

public abstract class Feu extends Semaphore 
{


	
	private CouleurFeu couleurFeu;
	
	@Override
	public void limiteVitesse()
	{
		//TODO
	}
	
	public Feu(ElementDeRegulation elementDeRegulation,Segment segment,  Sens sens) 
	{
		super(elementDeRegulation, segment, sens);
	}

}
