package Route;

import java.util.ArrayList;

public class Reseau 
{
	public static int vitesseMaxGlobale = 100;
	ArrayList<Segment> segments = new ArrayList<Segment>();
	ArrayList<Jonction> jonctions = new ArrayList<Jonction>();
	ArrayList<Voiture> voitures = new ArrayList<Voiture>();
	
	public Reseau() 
	{
		// TODO Auto-generated constructor stub
	}

	/**
	 * Fonction qui d√©roule un inetrvalle de temps sur l'ensemble du r√©seau
	 */
	public void prochaineEtape()
	{
		//TODO
		//update feux
		for (Jonction j : jonctions)
		{
			j.getElementDeRegulation().updateFeuxCarrefour();
		}
		
		
		//update vitesse max courante sur chacun des segments
		for (Segment s : segments)
		{
			s.updateLimiteVitesse();
		}
		
		//les voitures avancent
		for (Voiture v : voitures)
		{
			v.avancerVoiture();
		}
		
	
	}
	
	public void creerElementDeRegulation()
	{
		for(Jonction j : jonctions)
		{
			if(Math.random()<1)
			{
				ElementDeRegulation e = new ElementDeRegulationSimpliste(j);
				j.setElementDeRegulation(e);
			}
			else
			{
				//TODO crÈation Element de regulation compliquÈ
			}
		}
	}
	public void printJonctions()
	{
		for(Jonction j : jonctions)
		{
			j.printJonction();
		}
	}
	public void testReseau()
	{
		
		//crÈation des jonctions
		jonctions.add(new Jonction("Rond point de l'Ètoile"));
		jonctions.add(new Jonction("Rond point JÈsus Christ"));
		jonctions.add(new Jonction("Rond point Alain Chabat"));
		jonctions.add(new Jonction("Rond point Zozime"));
		jonctions.add(new Jonction("Rond point 5"));
		
		//crÈation des segments
		segments.add(new Segment("CoulÈe Verte"));
		segments.add(new Segment("Rue Collin Mamet"));
		segments.add(new Segment("Boulevard mystique"));
		segments.add(new Segment("Rue Chaferfu Lancier"));
		segments.add(new Segment("Boulevard De La Voie LactÈe"));
		segments.add(new Segment("Rue De <Attention Radar>"));
		segments.add(new Segment("Route Infinie Vers Le Vide Eternel Et Vers De Terre"));
		
		segments.get(0).ajouterSemaphore(new Limiteur(50,Sens.Un));
		segments.get(2).ajouterSemaphore(new Limiteur(60,Sens.Un));
		segments.get(4).ajouterSemaphore(new Limiteur(70,Sens.Un));
		segments.get(6).ajouterSemaphore(new Limiteur(80,Sens.Un));
		segments.get(5).ajouterSemaphore(new Radar(50,Sens.Un));


		
		//liens segments
		jonctions.get(0).joindre(segments.get(0)); 
		jonctions.get(0).joindre(segments.get(5)); 
		jonctions.get(0).joindre(segments.get(4));
		
		jonctions.get(1).joindre(segments.get(0));
		jonctions.get(1).joindre(segments.get(1));
		
		jonctions.get(2).joindre(segments.get(1));
		jonctions.get(2).joindre(segments.get(2));
		jonctions.get(2).joindre(segments.get(4));
		
		jonctions.get(3).joindre(segments.get(2));
		jonctions.get(3).joindre(segments.get(3));
		
		jonctions.get(4).joindre(segments.get(6));
		jonctions.get(4).joindre(segments.get(3));
		jonctions.get(4).joindre(segments.get(5));
		
		creerElementDeRegulation();

	}
	public static void main(String[] args) 
	{
		Reseau r = new Reseau();
		r.testReseau();
		r.printJonctions();
		System.out.println(r.segments.get(2).toString());

	}

}
