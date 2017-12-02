package Route;

import java.util.ArrayList;

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
		System.out.println(this.getId()+" est attaché à :");
		for(Segment s : segments)
		{
			System.out.println("\t- "+s.getId());
		}
	}
	public void joindre(Segment s) 
	{
		
		if (s.getJonction1() == null)
		{
			segments.add(s);
			s.setJonction1(this);
		}
		else if (s.getJonction2() == null)
		{
			segments.add(s);
			s.setJonction2(this);
		}
		else
		{
			System.out.println("Erreur : le segment est deja colle a  " +  s.getJonction1().toString() + " et "  + s.getJonction2().toString());
		}
	}
	@Override
	public void avancerVoitures() {
		// TODO Auto-generated method stub
		
	}
}
