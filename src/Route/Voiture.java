package Route;

public class Voiture 
{
	public static int compteur = 0;
	
	private int id;
	private int position;  //Position sur route actuelle;
	private Sens sens;
	private int vitesseCourante;
	
	private Route routeCourante;
	
	

	public Voiture() 
	{
		this.id = compteur;
		compteur++;
		// TODO Auto-generated constructor stub
	}

}
