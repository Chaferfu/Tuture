package Route;

import java.util.ArrayList;

public class Jonction extends Route 
{
	private ArrayList<Segment> segments = new ArrayList<Segment>();
	private ArrayList<Sens> sens = new ArrayList<Sens>();
	
	private ElementDeRegulation elementderegulation;
	
	public Jonction() 
	{
		super();
	}

	public void joindre(Segment s) 
	{
		segments.add(s);
		if (s.getJonction1() == null)
		{
			s.setJonction1(this);
		}
		else if (s.getJonction2() == null)
		{
			s.setJonction2(this);
		}
		else
		{
			System.out.println("Erreur : le segment est déja collé à " +  s.getJonction1().toString() + " et "  + s.getJonction2().toString());
		}
	}
}
