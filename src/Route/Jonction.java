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

}
