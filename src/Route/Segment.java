package Route;

import java.util.ArrayList;



public class Segment extends Route 
{
	private Jonction jonction1;
	private Jonction jonction2;
	private ArrayList<Capteur> capteurs = new ArrayList<Capteur>();
	
	public Segment(String id) 
	{
		super(id);
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
		/*for(Voiture voiture : this.getlVoitures()){
			
		}*/
	}
}
