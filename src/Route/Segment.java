package Route;

import java.util.ArrayList;



public class Segment extends Route 
{
	private Jonction jonction1;
	private Feu feu1;
	private Jonction jonction2;
	private Feu feu2;
	private int vMaxSens1;
	private int vMaxSens2;
	private ArrayList<Capteur> capteurs = new ArrayList<Capteur>();
	private ArrayList<Semaphore> semaphores = new ArrayList<Semaphore>();
	
	public Segment(String id, int l) 
	{
		super(id, l);
	}
	
	public void ajouterSemaphore(Semaphore s)
	{
		s.setSegment(this);
		semaphores.add(s);
	}
	
	/*
	 * ajoute un semaphore au niveau de la jonction donn�e
	 *  (le semaphore s'applique aux voitures allant dans le sens qui va VERS cette jonction
	 */
	public void ajouterSemaphore(Semaphore s, Jonction j)
	{
		s.setSegment(this);
		s.setSens(sensVersJonction(j));
		semaphores.add(s);
	}
	
	/**
	 * d�fini le sens du segment pour aller vers une jonction donn�e
	 * @param jonction
	 * @return
	 */
	public Sens sensVersJonction(Jonction jonction)
	{
		if(jonction == jonction1)
		{
			return Sens.Deux;
		}
		else if(jonction == jonction2)
		{
			return Sens.Un;
		}
		else
		{	
			System.out.println("Attention le segment "+this.getId()+" n'est pas reli� � la jonction "+jonction.getId());
			return null;
		}
	}
	
	@Override
	public void addObserverCapteur(Voiture v)
	{
		for(Capteur c : capteurs)
		{
			if(c.getSens().equals(v.getSens()))
			{
				v.addObserver(c);	
			}
		}
	}
	
	/**
	 * renvoie la prochaine route disponible pour une voiture donn�e
	 */
	@Override
	public Route prochaineRoute(Voiture v)
	{
		if(v.getSens().equals(Sens.Un))
		{
			if(jonction2!=null)
			{
				return jonction2;
			}
			else
			{
				v.setSens(Sens.Deux);
				return this;
			}
		}
		else
		{
			if(jonction1!=null)
			{
				return jonction1;
			}
			else
			{
				v.setSens(Sens.Un);
				return this;
			}
		}
	}
	
	/**
	 * renvoie la couleur d'un feu en lien avec une voiture donn�e (n�cessit� d'un boolean pour l'affichage quand n�cessaire)
	 */
	@Override
	public CouleurFeu couleurFeu(Voiture v,boolean affichage)
	{
		if(v.getSens().equals(Sens.Un))
		{
			if(feu1 != null)
			{
				if(affichage)System.out.println("||La voiture est sur un segment dont le feu est de couleur : "+ feu1.couleurFeu+"||");
				return feu1.couleurFeu;

			}
		}
		else
		{
			if(feu2!=null)
			{
				if(affichage)System.out.println("||La voiture est sur un segment dont le feu est de couleur : "+ feu2.couleurFeu+"||");
				return feu2.couleurFeu;
			}
		}
		return null;
	}
	
	/**
	 * fonction qui est appel� � tous les d�buts d'intervalles de temps pour red�finir la vitesse maximum d'un segment
	 */
	public void updateLimiteVitesse()
	{
		vMaxSens1 = Reseau.vitesseMaxGlobale;
		vMaxSens2 = Reseau.vitesseMaxGlobale;
		
		for(Semaphore s : semaphores)
		{
			s.limiterVitesse();
		}
		if(feu1 != null)
		{
			this.feu1.limiterVitesse();
		}
		if(feu2 != null)
		{
			this.feu2.limiterVitesse();
		}
		
	}
	
	///// Getters & Setters & ToString
	@Override
	public int getvmax(Sens s)
	{
		if(s.equals(Sens.Un))
		{
			return vMaxSens1;
		}
		else
		{
			return vMaxSens2;
		}
	}
	

	public ArrayList<Semaphore> getSemaphores() {
		return semaphores;
	}



	public Feu getFeu1() {
		return feu1;
	}

	public void setFeu1(Feu feu1) {
		this.feu1 = feu1;
	}

	public Feu getFeu2() {
		return feu2;
	}
	

	public void setFeu2(Feu feu2) {
		this.feu2 = feu2;
	}

	@Override
	public String toString() {
		return super.toString() + " [jonction1=" + jonction1.getId() + ", jonction2=" + jonction2.getId() + ", capteurs=" + capteurs + ", semaphores :" + semaphores + "]";
	}


	/**
	 * @return the capteurs
	 */
	public ArrayList<Capteur> getCapteurs() {
		return capteurs;
	}

	/**
	 * @return the jonction1
	 */
	public Jonction getJonction1() {
		return jonction1;
	}

	
	/**
	 * @return the jonction2
	 */
	public Jonction getJonction2() {
		return jonction2;
	}

	/**
	 * @param jonction1 the jonction1 to set
	 */
	public void setJonction1(Jonction jonction1) {
		this.jonction1 = jonction1;
	}

	/**
	 * @param jonction2 the jonction2 to set
	 */
	public void setJonction2(Jonction jonction2) {
		this.jonction2 = jonction2;
	}
	
	/**
	 * 
	 * @param capteur to add
	 */
	public void addCapteur(Capteur capteur) {	
		this.capteurs.add(capteur);
	}
	
	public int getvMaxSens1() {
		return vMaxSens1;
	}
	
	public void setvMaxSens2(int vMaxSens2) {
		this.vMaxSens2 = vMaxSens2;
	}

	public void setCapteurs(ArrayList<Capteur> capteurs) {
		this.capteurs = capteurs;
	}

	public void setSemaphores(ArrayList<Semaphore> semaphores) {
		this.semaphores = semaphores;
	}
	
	/**
	 * @return the vMaxSens2
	 */
	public int getvMaxSens2() {
		return vMaxSens2;
	}

	/**
	 * @param vMaxSens1 the vMaxSens1 to set
	 */
	public void setvMaxSens1(int vMaxSens1) {
		this.vMaxSens1 = vMaxSens1;
	}

	

}

	

