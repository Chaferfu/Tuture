package Route;

public class Limiteur extends Semaphore 
{
	private int limite;
	
	@Override
	public void limiteVitesse()
	{
		//TODO
	}
	
	public Limiteur(int limite) 
	{
		this.limite = limite;
	}

}
