package Route;

public class FeuBicolore extends Feu 
{

	@Override
	public void limiteVitesse()
	{
		//TODO
	}
	
	public FeuBicolore(ElementDeRegulation elementDeRegulation,Segment segment, Sens sens) 
	{
		super(elementDeRegulation, segment, sens);
		this.couleurFeu = CouleurFeu.Vert;
	}

}
