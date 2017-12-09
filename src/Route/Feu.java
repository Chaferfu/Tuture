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

	public CouleurFeu getCouleurFeu() {
		return couleurFeu;
	}

	public void setCouleurFeu(CouleurFeu couleurFeu) {
		this.couleurFeu = couleurFeu;
	}
	
	public abstract void updateCouleur();

	

}
