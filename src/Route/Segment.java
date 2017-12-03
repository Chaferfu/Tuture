package Route;

import java.util.ArrayList;



public class Segment extends Route 
{
	private Jonction jonction1;
	private Feu feu1;
	private Jonction jonction2;
	private Feu feu2;
	private ArrayList<Capteur> capteurs = new ArrayList<Capteur>();
	private ArrayList<Semaphore> semaphores = new ArrayList<Semaphore>();
	
	public Segment(String id) 
	{
		super(id);
	}
	
	public void ajouterSemaphore(Semaphore s)
	{
		s.setSegment(this);
		semaphores.add(s);
	}
	
	/*
	 * ajoute un semaphore au niveau de la jonction donnée
	 *  (le semaphore s'applique aux voitures allant dans le sens qui va VERS cette jonction
	 */
	public void ajouterSemaphore(Semaphore s, Jonction j)
	{
		s.setSegment(this);
		s.setSens(sensVersJonction(j));
		semaphores.add(s);
	}
	
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
			System.out.println("Attention le segment "+this.getId()+" n'est pas relié à la jonction "+jonction.getId());
			return null;
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
	
	@Override
	public void avancerVoitures(){
		for(Voiture voiture : this.getLvoitures()){
			if(voiture.getSens().equals(Sens.Un)){
				int distanceRestante = this.getLongueur() - voiture.getPosition(); //Distance entre la voiture et la fin du segment
				if(distanceRestante == 0){ // la voiture arrive sur la jointure 2
					this.getLvoitures().remove(voiture);
					voiture.setPosition(0);
					System.out.println("On a avancÃ© la voiture du pas de 1 :");
					System.out.println("Elle est maintenant Ã  la jonction" + this.getJonction2().getId());
				}
				else { // la voiture reste sur le segment
					voiture.setPosition(voiture.getPosition()+1);
				}
			}
			else if(voiture.getSens().equals(Sens.Deux)){
				if(voiture.getSens().equals(Sens.Un)){
					int distanceRestante = voiture.getPosition(); //Distance entre la voiture et la fin du segment
					if(distanceRestante == 0){ // la voiture arrive sur la jointure 1
						System.out.println("On a avancÃ© la voiture du pas de 1 :");
						System.out.println("Elle est maintenant Ã  la jonction" + this.getJonction1().getId());
					}
					else { // la voiture reste sur le segment
						voiture.setPosition(voiture.getPosition()-1);
					}
			}
		}
	}
	}
}
