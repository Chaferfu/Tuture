package Route;

import java.util.ArrayList;
import java.util.Random;

public class Jonction extends Route 
{
	private ArrayList<Segment> segments = new ArrayList<Segment>();
	private ElementDeRegulation elementDeRegulation;
	
	public Jonction(String id) 
	{
		super(id);
	}
	public void printJonction()
	{
		System.out.println(this.getId()+" est attachï¿½ ï¿½ :");
		for(Segment s : segments)
		{
			System.out.println("\t- "+s.getId());
		}
	}
	
	/**
	 * joins le segment ga la jonction et met un feu aleatoire sur le segment coté jonction
	 * @param s
	 */
	public void joindre(Segment s) 
	{
		Random rand = new Random();
		
		if (s.getJonction1() == null)
		{
			segments.add(s);
			s.setJonction1(this);
			if (rand.nextBoolean())
			{
				s.setFeu1(new FeuTricolore(s, Sens.Deux));

			}
			else 
			{
				s.setFeu1(new FeuBicolore(s, Sens.Deux));
			}
		}
		else if (s.getJonction2() == null)
		{
			segments.add(s);
			s.setJonction2(this);
			if (rand.nextBoolean())
			{
				s.setFeu2(new FeuTricolore(s, Sens.Un));

			}
			else 
			{
				s.setFeu2(new FeuBicolore(s, Sens.Un));
			}
		}
		else
		{
			System.out.println("Erreur : le segment est deja colle aï¿½ " +  s.getJonction1().toString() + " et "  + s.getJonction2().toString());
		}
	}

	/**
	 * @return the segments
	 */
	public ArrayList<Segment> getSegments() {
		return segments;
	}
	

	@Override
	public String toString() {
		return "Jonction [segments=" + segments + ", elementDeRegulation=" + elementDeRegulation + "]";
	}
	
	

}
