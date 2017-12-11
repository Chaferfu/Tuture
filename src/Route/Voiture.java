package Route;

public class Voiture 
{
	public static int compteur = 0;
	
	private int id;
	private int distanceAvantFinRoute;  //Position sur route actuelle;
	private Sens sens;
	private int vitesseCourante;
	private int vitesseMax;
	private Route routeCourante;
	
	

	public Voiture() 
	{
		this.id = compteur;
		compteur++;
		// TODO Auto-generated constructor stub
	}
	
	public Voiture(Route route, int pos, Sens sens, int vitesse) 
	{
		this.id = compteur;
		compteur++;
		routeCourante = route;
		if(routeCourante.getLongueur() >= pos){
		distanceAvantFinRoute = pos;
		}
		this.sens=sens;
		vitesseMax = vitesse;
	}

	
	@Override
	public String toString() {
		return "Voiture [id=" + id + ", distance à parcourir sur la route actuelle=" + distanceAvantFinRoute + ", sens=" + sens + ", vitesseCourante="
				+ vitesseCourante + ", vitesseMax=" + vitesseMax + ", routeCourante=" + routeCourante.getId() 
				+ "]";
	}

	public static int getCompteur() {
		return compteur;
	}

	public static void setCompteur(int compteur) {
		Voiture.compteur = compteur;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPosition() {
		return distanceAvantFinRoute;
	}

	public void setPosition(int position) {
		this.distanceAvantFinRoute = position;
	}

	public Sens getSens() {
		return sens;
	}

	public void setSens(Sens sens) {
		this.sens = sens;
	}

	public int getVitesseCourante() {
		return vitesseCourante;
	}

	public void setVitesseCourante(int vitesseCourante) {
		this.vitesseCourante = vitesseCourante;
	}

	public Route getRouteCourante() {
		return routeCourante;
	}
	
	

	public int getVitesseMax() {
		return vitesseMax;
	}

	public void setVitesseMax(int vitesseMax) {
		this.vitesseMax = vitesseMax;
	}


	public void setRouteCourante(Route routeCourante) {
		this.routeCourante = routeCourante;
	}
	
	public void avancerVoiture()
	{
		vitesseCourante = Math.min(vitesseMax,routeCourante.getvmax(sens));
		System.out.println("Deplacement Voiture "+ id);
		while(vitesseCourante > 0)
		{
			System.out.println("\t"+toString());
			if(distanceAvantFinRoute == 0)
			{
				vitesseCourante--;
				routeCourante = routeCourante.prochaineRoute(this);
				vitesseCourante = Math.min(vitesseCourante,routeCourante.getvmax(sens));
				distanceAvantFinRoute = routeCourante.getLongueur();
			}
			else
			{
				if(vitesseCourante < distanceAvantFinRoute)
				{
					distanceAvantFinRoute -= vitesseCourante;
					vitesseCourante=0;
				}
				else
				{
					
					vitesseCourante -= distanceAvantFinRoute;
					distanceAvantFinRoute = 0;
				}
			}
		}
	}
	
	
	/*public void avancerVoiture() {
		if(this.getSens().equals(Sens.Un)){
			this.setVitesseCourante(Math.min(this.getVitesseMax(),((Segment)(this.getRouteCourante())).getvMaxSens1()));
			int positionMaxAtteignable = this.position + this.vitesseCourante;
			if(positionMaxAtteignable >= this.getRouteCourante().getLongueur()){
				this.setPosition(this.getRouteCourante().getLongueur());
				this.setVitesseCourante(positionMaxAtteignable-this.getRouteCourante().getLongueur());
				this.setRouteCourante(((Segment) routeCourante).getJonction2().choixSegmentRandom());
				if(this.getVitesseCourante()>((Segment)this.getRouteCourante()).getvMaxSens1()){
					this.setVitesseCourante(((Segment)this.getRouteCourante()).getvMaxSens1());		
				}
				if(this.getVitesseCourante() < ((Segment) this.getRouteCourante()).getLongueur()){
					this.setPosition(this.getVitesseCourante());	
				}
				else {
					avancerVoiture();
				}
			}
			else{
				this.setPosition(positionMaxAtteignable);		
			}
		}
		else {
			this.setVitesseCourante(Math.min(this.getVitesseMax(),((Segment)(this.getRouteCourante())).getvMaxSens2()));
			int positionMaxAtteignable = this.position - this.vitesseCourante;	
			if(positionMaxAtteignable <= 0){
				this.setPosition(0);
				this.setVitesseCourante(this.getVitesseCourante()-this.getPosition());
				this.setRouteCourante(((Segment) routeCourante).getJonction1().choixSegmentRandom());
				if(this.getVitesseCourante()>((Segment)this.getRouteCourante()).getvMaxSens1()){
					this.setVitesseCourante(((Segment)this.getRouteCourante()).getvMaxSens1());		
				}
				if(this.getVitesseCourante() < ((Segment) this.getRouteCourante()).getLongueur()){
					this.setPosition(this.getVitesseCourante());	
				}
				else {
					avancerVoiture();
				}
			}
			else{
				this.setPosition(positionMaxAtteignable);		
			}
		}
				
	}*/
	

}
