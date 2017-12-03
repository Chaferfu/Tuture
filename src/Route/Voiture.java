package Route;

public class Voiture 
{
	public static int compteur = 0;
	
	private int id;
	private int position;  //Position sur route actuelle;
	private Sens sens;
	private int vitesseCourante;
	private int vitesseMax;
	private Route routeCourante;
	private boolean aAvance;
	
	

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
		position = pos;
		}
		this.sens=sens;
		vitesseCourante = vitesse;
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
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
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

	public boolean isaAvance() {
		return aAvance;
	}

	public void setaAvance(boolean aAvance) {
		this.aAvance = aAvance;
	}

	public void setRouteCourante(Route routeCourante) {
		this.routeCourante = routeCourante;
	}

	public void avancerVoiture() {
		if(this.getSens().equals(Sens.Un)){
			this.setVitesseCourante(min(this.getVitesseMax(),((Segment)(this.getRouteCourante())).getvMaxSens1()));
		}
		else {
			this.setVitesseCourante(min(this.getVitesseMax(),((Segment)(this.getRouteCourante())).getvMaxSens2()));
		}
		int positionMaxAtteignable = this.position + this.vitesseCourante;		
	}
	

	public int min(int i1, int i2) {
		if (i1 <= i2) return i1;
		else return i2;
	}
	
}
