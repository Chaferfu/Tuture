package Route;

import java.util.ArrayList;

public class Reseau 
{

	ArrayList<Segment> segments = new ArrayList<Segment>();
	ArrayList<Jonction> jonctions = new ArrayList<Jonction>();
	
	public Reseau() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Fonction qui dÃ©roule un inetrvalle de temps sur l'ensemble du rÃ©seau
	 */
	public void prochaineEtape()
	{
		//TODO
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
		segments.add(new Segment("Coulée Verte"));
		segments.add(new Segment("Route Collin Mamet"));
		segments.add(new Segment("Boulevard mystique"));
		segments.add(new Segment("Rue Chaferfu Lancier"));
		segments.add(new Segment("Boulevard De La Voie Lactée"));
		segments.add(new Segment("Rue De <Attention Radar>"));
		segments.add(new Segment("Route Infinie Vers Le Vide Eternel Et Vers De Terre"));
		
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

	}
	public static void main(String[] args) 
	{
		Reseau r = new Reseau();
		r.testReseau();
		r.printJonctions();

	}

}
