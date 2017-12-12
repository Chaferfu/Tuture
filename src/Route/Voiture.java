package Route;

import java.util.Observable;

public class Voiture extends Observable
{
	public static int compteur = 0;
	
	private int id;
	private int distanceAvantFinRoute;  //Position sur route actuelle;
	private Sens sens;
	private int vitesseCourante;
	private int vitesseMax;
	private Route routeCourante;
	private Capteur capteur;
	
	

	public Voiture() 
	{
		this.id = compteur;
		compteur++;
	}
	
	public Voiture(Route route, int pos, Sens sens, int vitesse) 
	{
		this.id = compteur;
		compteur++;
		routeCourante = route;
		if(routeCourante.getLongueur() >= pos){
		setDistanceAvantFinRoute(pos);
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
	

	public Capteur getCapteur() {
		return capteur;
	}

	public void setCapteur(Capteur capteur) {
		this.capteur = capteur;
	}

	

	public int getDistanceAvantFinRoute() 
	{
		return distanceAvantFinRoute;
	}

	public void setDistanceAvantFinRoute(int distanceAvantFinRoute) 
	{
		this.distanceAvantFinRoute = distanceAvantFinRoute;
		setChanged();
		notifyObservers(distanceAvantFinRoute);
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
		System.out.println("Voiture "+ id);
		routeCourante.couleurFeu(this);
		while(vitesseCourante > 0)
		{
			System.out.println("\t"+toString());
			
			if(distanceAvantFinRoute == 0)
			{
				vitesseCourante--;
				routeCourante = routeCourante.prochaineRoute(this);
				vitesseCourante = Math.min(vitesseCourante,routeCourante.getvmax(sens));
				setDistanceAvantFinRoute(routeCourante.getLongueur());
				routeCourante.couleurFeu(this);
			}
			else
			{
				if(vitesseCourante < distanceAvantFinRoute)
				{
					setDistanceAvantFinRoute(distanceAvantFinRoute-vitesseCourante);
					vitesseCourante=0;
				}
				else
				{
					
					vitesseCourante -= distanceAvantFinRoute;
					setDistanceAvantFinRoute(0);
				}
			}
			
		}
	}
	

}
