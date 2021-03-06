package Route;

import java.util.ArrayList;
import java.util.Scanner;

public class Reseau 
{
	/////VARIABLES/////
	
	public static int vitesseMaxGlobale = 100; // vitesse de limitation sur les segments sans limiteur
	ArrayList<Segment> segments = new ArrayList<Segment>();
	ArrayList<Jonction> jonctions = new ArrayList<Jonction>();
	ArrayList<Voiture> voitures = new ArrayList<Voiture>();
	private int nbrIntervalles=0;
	
	public Reseau() {}


	/**
	 * Fonction qui deroule un intervalle de temps sur l'ensemble du reseau
	 */
	public void prochaineEtape()
	{
		System.out.println("||INTERVALLE DE TEMPS "+(nbrIntervalles++)+"||");
		//update feux
		for (Jonction j : jonctions)
		{
			j.getElementDeRegulation().updateFeuxCarrefour();
		}
		
		
		//update vitesse max courante sur chacun des segments
		for (Segment s : segments)
		{
			s.updateLimiteVitesse();
			for(Capteur c : s.getCapteurs())
			{
				c.reinitialiseCapteur();
			}
		}
		
		//les voitures avancent
		for (Voiture v : voitures)
		{
			v.avancerVoiture();
		}
		for (Segment s : segments)
		{
			for(Capteur c : s.getCapteurs())
			{
				System.out.println(c.getInformationPassage());
			}
		}
	}
	
	/**
	 * Cr�e les �l�ments de limitation apr�s cr�ation des jonctions
	 */
	public void creerElementDeRegulation()
	{
		for(Jonction j : jonctions)
		{
			// Lors de test on ne consid�re que des element des regulation complexe, c'est plus interessant
			if(Math.random()<0.5)
			{
				ElementDeRegulation e = new ElementDeRegulationSimpliste(j);
				j.setElementDeRegulation(e);
			}
			else
			{
				ElementDeRegulation e = new ElementDeRegulationComplexe(j);
				j.setElementDeRegulation(e);
			}
		}
	}
	
	/**
	 * Affiche l'ensemble des jonctions du r�seau et leurs segments attach�s (fonction de test)
	 */
	public void printJonctions()
	{
		for(Jonction j : jonctions)
		{
			j.printJonction();
		}
	}

	/**
	 * Fonction de test pour la cr�ation du r�seau
	 */
	public void testReseau()
	{
		
		//cr�ation des jonctions
		jonctions.add(new Jonction("Rond point de l'�toile"));
		jonctions.add(new Jonction("Rond point J�sus Christ"));
		jonctions.add(new Jonction("Rond point Alain Chabat"));
		jonctions.add(new Jonction("Rond point Zozime"));
		jonctions.add(new Jonction("Rond point 5"));
		
		//cr�ation des segments
		segments.add(new Segment("Coul�e Verte", 200));
		segments.add(new Segment("Rue Collin Mamet", 250));
		segments.add(new Segment("Boulevard mystique", 100));
		segments.add(new Segment("Rue Chaferfu Lancier", 100));
		segments.add(new Segment("Boulevard De La Voie Lact�e", 200));
		segments.add(new Segment("Rue De <Attention Radar>", 456));
		segments.add(new Segment("Route Infinie Vers Le Vide Eternel Et Vers De Terre", 100));
		
		
		//cr�ation de quelques s�maphores, les feux se cr�ent automatiquement lorsque l'on ajoute un segment � un carrefour
		segments.get(0).ajouterSemaphore(new Limiteur(50,Sens.Un));
		segments.get(2).ajouterSemaphore(new Limiteur(60,Sens.Un));
		segments.get(4).ajouterSemaphore(new Limiteur(70,Sens.Un));
		segments.get(6).ajouterSemaphore(new Limiteur(80,Sens.Un));
		segments.get(5).ajouterSemaphore(new Limiteur(50,Sens.Un));


		
		//liens segments (donc cr�ation des feux)
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
		
		
		//ajout de quelques capteurs
		segments.get(0).addCapteur(new CapteurVitesse(segments.get(0),Sens.Deux,150));
		segments.get(1).addCapteur(new CapteurVitesse(segments.get(1),Sens.Deux,150));
		segments.get(2).addCapteur(new Capteur(segments.get(2),Sens.Deux,150));
		segments.get(3).addCapteur(new Capteur(segments.get(3),Sens.Deux,150));
		
		
		//Cr�ation des �l�mnents de r�gulation en parcourant les jonctions.
		creerElementDeRegulation();
		
		//ajout des voitures
		voitures.add(new Voiture(segments.get(0), 400, Sens.Deux, 80));
		voitures.add(new Voiture(segments.get(0), 400, Sens.Deux, 80));
	}
	
	/**
	 * Fonction de test pour la cr�ation du r�seau
	 */
	public void testTriangle()
	{
		
		//cr�ation des jonctions
		jonctions.add(new Jonction("Rond point de l'�toile"));
		jonctions.add(new Jonction("Rond point J�sus Christ"));
		jonctions.add(new Jonction("Rond point Alain Chabat"));
		
		//cr�ation des segments
		segments.add(new Segment("Coul�e Verte", 200));
		segments.add(new Segment("Rue Collin Mamet", 250));
		segments.add(new Segment("Boulevard mystique", 100));

		
		
		//cr�ation de quelques s�maphores, les feux se cr�ent automatiquement lorsque l'on ajoute un segment � un carrefour
		segments.get(0).ajouterSemaphore(new Limiteur(50,Sens.Un));
		segments.get(2).ajouterSemaphore(new Limiteur(60,Sens.Un));


		//liens segments (donc cr�ation des feux)
		jonctions.get(0).joindre(segments.get(0)); 
		jonctions.get(0).joindre(segments.get(1)); 
		
		jonctions.get(1).joindre(segments.get(1));
		jonctions.get(1).joindre(segments.get(2));
		
		jonctions.get(2).joindre(segments.get(2));
		jonctions.get(2).joindre(segments.get(0));

		
		
		//ajout de quelques capteurs
		segments.get(0).addCapteur(new CapteurVitesse(segments.get(0),Sens.Deux,150));
		segments.get(1).addCapteur(new CapteurVitesse(segments.get(1),Sens.Deux,150));
		segments.get(2).addCapteur(new Capteur(segments.get(2),Sens.Deux,150));
		
		//Cr�ation des �l�mnents de r�gulation en parcourant les jonctions.
		creerElementDeRegulation();
		
		//ajout des voitures
		voitures.add(new Voiture(segments.get(0), 400, Sens.Deux, 80));
		voitures.add(new Voiture(segments.get(0), 400, Sens.Deux, 80));
	}
	
	
	public static void main(String[] args) 
	{
		Reseau r = new Reseau();
		r.testReseau();
		Scanner sc = new Scanner(System.in);
		boolean quitter=false;
		
		//Interface
		while(!quitter)
		{
			System.out.println("\n||INTERFACE|| Pour lancer un intervalle de temps, tapez 1, pour quitter tapez 2 ||INTERFACE||\n");
			String s = sc.next();
			if(s.equals("1"))
			{
				r.prochaineEtape();	
			}
			else if(s.equals("2"))
			{
				System.out.println("\nMerci d'�tre pass�, bonne journ�e ! \nDe la part de Mathias Bazin, Yassine Amraoui et Nathan Bonnard !");
				quitter=true;
			}
			else
			{
				System.out.println("\n||Attention|| Vous n'avez pas rentr� un commande qui existe ||Attention||");
			}	
		}
	}

}
