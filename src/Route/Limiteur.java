package Route;

public class Limiteur extends Semaphore 
{
	private int limite;
	
	@Override
	public void limiteVitesse()
	{
		//TODO
	}
	

	public Limiteur(int l,ElementDeRegulation elementDeRegulation,Segment segment,Sens sens) 
	{
		super(elementDeRegulation, segment, sens);
		this.limite = limite;
		
		limite = l;

	}

}
