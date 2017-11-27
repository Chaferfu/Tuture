package Route;

public abstract class Semaphore 
{
	
	private ElementDeRegulation elementDeRegulation;
	private Segment segment;
	private Sens sens;
	
	/**
	 * fonction qui détermine la vitesse des voitures sur un segment 
	 * en fonction du sens du sémaphore et du type de semaphore.
	 */
	public void limiteVitesse()
	{
		//TODO
		//redefinition dans chacune des sous-classes ? 
	}
	
	public Semaphore(ElementDeRegulation e, Segment s, Sens sens) 
	{
		elementDeRegulation = e;
		segment = s;
		this.sens = sens;
	}
}
