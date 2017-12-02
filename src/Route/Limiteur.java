package Route;

public class Limiteur extends Semaphore 
{
	private int limite;
	
	@Override
	public void limiteVitesse()
	{
		//TODO
	}
	

	public Limiteur(int l,Segment segment,Sens sens) 
	{
		super(segment, sens);
		limite = l;
	}

}
