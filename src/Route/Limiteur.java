package Route;

public class Limiteur extends Semaphore 
{
	private int limite;
	
	@Override
	public void limiteVitesse()
	{
		//TODO
	}
	

	public Limiteur(int l,Sens sens) 
	{
		super(sens);
		limite = l;
	}
	
	

}
