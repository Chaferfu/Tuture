package Route;

public class FeuBicolore extends Feu 
{

	@Override
	public void limiteVitesse()
	{
		//TODO
	}
	
	public FeuBicolore(Segment segment, Sens sens) 
	{
		super(segment, sens);
		this.couleurFeu = CouleurFeu.Vert;
	}

}
