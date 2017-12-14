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
	
	public Reseau() 
	{
		// TODO Auto-generated constructor stub
	}

	/**
	 * Fonction qui deroule un intervalle de temps sur l'ensemble du reseau
	 */
	public void prochaineEtape()
	{
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
	
	public void creerElementDeRegulation()
	{
		for(Jonction j : jonctions)
		{
			// Lors de test on ne considère que des element des regulation complexe, c'est plus interessant
			if(Math.random()<0)
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
	public void printJonctions()
	{
		for(Jonction j : jonctions)
		{
			j.printJonction();
		}
	}


	public void testReseau()
	{
		
		//création des jonctions
		jonctions.add(new Jonction("Rond point de l'étoile"));
		jonctions.add(new Jonction("Rond point Jésus Christ"));
		jonctions.add(new Jonction("Rond point Alain Chabat"));
		jonctions.add(new Jonction("Rond point Zozime"));
		jonctions.add(new Jonction("Rond point 5"));
		
		//création des segments
		segments.add(new Segment("Coulée Verte", 500));
		segments.add(new Segment("Rue Collin Mamet", 250));
		segments.add(new Segment("Boulevard mystique", 100));
		segments.add(new Segment("Rue Chaferfu Lancier", 1000));
		segments.add(new Segment("Boulevard De La Voie Lactée", 1300));
		segments.add(new Segment("Rue De <Attention Radar>", 456));
		segments.add(new Segment("Route Infinie Vers Le Vide Eternel Et Vers De Terre", 100000));
		
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
		
		segments.get(0).addCapteur(new Capteur(segments.get(0),Sens.Deux,150));
		segments.get(1).addCapteur(new Capteur(segments.get(1),Sens.Deux,150));
		segments.get(2).addCapteur(new Capteur(segments.get(2),Sens.Deux,150));
		segments.get(3).addCapteur(new Capteur(segments.get(3),Sens.Deux,150));
		
		creerElementDeRegulation();
		
		voitures.add(new Voiture(segments.get(0), 400, Sens.Deux, 80));
		voitures.add(new Voiture(segments.get(0), 400, Sens.Deux, 80));

	}
	public static void main(String[] args) 
	{
		Reseau r = new Reseau();
		r.testReseau();
		Scanner sc = new Scanner(System.in);
		boolean quitter=false;
		
		while(!quitter)
		{
			System.out.println("||INTERFACE|| Pour ||INTERFACE||");
			String s = sc.next();
			if(s.equals("1"))
			{
				r.prochaineEtape();	
			}
			else if(s.equals("2"))
			{
				System.out.println("\nMerci d'être passé, bonne journée ! \nDe la part de Mathias Bazin, Yassine Amraoui et Nathan Bonnard !");
				quitter=true;
			}
			else
			{
				System.out.println("\n||Attention|| Vous n'avez pas rentrer un commande qui existe ||Attention||");
			}
				
		}
		
		

	}

}
