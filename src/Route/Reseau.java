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
	 * Fonction qui déroule un inetrvalle de temps sur l'ensemble du réseau
	 */
	public void prochaineEtape()
	{
		//TODO
	}
	
	public void testReseau()
	{
		
		//cr�ation des jonctions
		jonctions.add(new Jonction("Rond point de l'�toile"));
		jonctions.add(new Jonction("Rond point J�sus Christ"));
		jonctions.add(new Jonction("Rond point Alain Chabat"));
		jonctions.add(new Jonction("Rond point Zozime"));
		jonctions.add(new Jonction("Rond point 5"));
		
		//cr�ation des segments
		segments.add(new Segment("Coul�e Verte"));
		segments.add(new Segment("Route Collin Mamet"));
		segments.add(new Segment("Boulevard mystique"));
		segments.add(new Segment("Rue Chaferfu Lancier"));
		segments.add(new Segment("Boulevard De La Voie Lact�e"));
		segments.add(new Segment("Rue De <Attention Radar>"));
		segments.add(new Segment("Route Infinie Vers Le Vide Eternel Et Vers De Terre"));
		
		//liens segments
		
	}
	public static void main(String[] args) 
	{
		

	}

}
