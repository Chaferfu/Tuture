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
		this.setLongueur(0); 
	}

	public void printJonction()
	{
		System.out.println(this.getId()+" est attach� � :");
		for(Segment s : segments)
		{
			System.out.println("\t- "+s.getId());
		}
	}
	
	@Override
	public void addObserverCapteur(Voiture v) {}

	
	@Override
	public CouleurFeu couleurFeu(Voiture v,boolean affichage) {return null;}

	/**
	 * joins le segment ga la jonction et met un feu aleatoire sur le segment cot� jonction
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
				s.setFeu2(new FeuTricolore(s, Sens.Deux));

			}
			else 
			{
				s.setFeu2(new FeuBicolore(s, Sens.Deux));
			}
		}
		else if (s.getJonction2() == null)
		{
			segments.add(s);
			s.setJonction2(this);
			if (rand.nextBoolean())
			{
				s.setFeu1(new FeuTricolore(s, Sens.Un));

			}
			else 
			{
				s.setFeu1(new FeuBicolore(s, Sens.Un));
			}
		}
		else
		{
			System.out.println("Erreur : le segment est deja colle a� " +  s.getJonction1().toString() + " et "  + s.getJonction2().toString());
		}
	}
	/**
	 * renvoie la prochaine route disponible pour une voiture donn�e
	 */
	@Override
	public Route prochaineRoute(Voiture v)
	{
		Random r = new Random();
		Segment seg = segments.get(r.nextInt(segments.size()));
		if(seg.sensVersJonction(this).equals(Sens.Un))
		{
			v.setSens(Sens.Deux);
		}
		else
		{
			v.setSens(Sens.Un);
		}
		return seg;
	}

	@Override
	public int getvmax(Sens s)
	{
		return Reseau.vitesseMaxGlobale;
	}
	

	/**
	 * @param elementDeRegulation the elementDeRegulation to set
	 */
	public void setElementDeRegulation(ElementDeRegulation elementDeRegulation) {
		this.elementDeRegulation = elementDeRegulation;
	}
	/**
	 * @return the segments
	 */
	public ArrayList<Segment> getSegments() {
		return segments;
	}
	
	

	public ElementDeRegulation getElementDeRegulation() {
		return elementDeRegulation;
	}
	@Override
	public String toString() {
		return "Jonction [segments=" + segments + ", elementDeRegulation=" + elementDeRegulation + "]";
	}
	
	

}
