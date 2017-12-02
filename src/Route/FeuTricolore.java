package Route;

public class FeuTricolore extends Feu {

	@Override
	public void limiteVitesse()
	{
		//TODO
	}


	public FeuTricolore(Segment segment, Sens sens) {
		super(segment, sens);
		this.couleurFeu = CouleurFeu.Vert;

	}

}
