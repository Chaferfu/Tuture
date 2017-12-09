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

	@Override
	public String toString() {
		return "Feu [couleurFeu=" + couleurFeu + ", type=" + getClass() + "]";
	}
	
	/**
	 * Passe a la prochaine couleur ( rouge > vert >orange > rouge etc ou  rouge > vert > rouge ... pour les bicolores)
	 */
	public abstract void updateCouleur();

	

}
