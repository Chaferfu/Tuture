package Route;

public class FeuBicolore extends Feu 
{
	
	public FeuBicolore(Segment segment, Sens sens) 
	{
		super(segment, sens);
		this.couleurFeu = CouleurFeu.Vert;
	}
	
	@Override
	public void limiterVitesse() {
		if(this.getSens().equals(Sens.Un)){
			modifierVitesse1();
		}
		else {
			modifierVitesse2();
		}
	}
	
	public void modifierVitesse1(){
		if(this.couleurFeu.equals(CouleurFeu.Rouge)){
			this.getSegment().setvMaxSens1(0); 
		}
	}
	
	public void modifierVitesse2(){
		if(this.couleurFeu.equals(CouleurFeu.Rouge)){
			this.getSegment().setvMaxSens2(0); 
		}
	}
	


}
