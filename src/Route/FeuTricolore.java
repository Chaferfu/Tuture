package Route;

public class FeuTricolore extends Feu {


	public FeuTricolore(Segment segment, Sens sens) {
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
			this.getSegment().setvMaxSens1(0);;
		}
		else if(this.couleurFeu.equals(CouleurFeu.Orange)){
			this.getSegment().setvMaxSens1((int)this.getSegment().getvMaxSens1()/2);
		}
	}
	
	public void modifierVitesse2(){
		if(this.couleurFeu.equals(CouleurFeu.Rouge)){
			this.getSegment().setvMaxSens2(0);;
		}
		else if(this.couleurFeu.equals(CouleurFeu.Orange)){
			this.getSegment().setvMaxSens2((int)this.getSegment().getvMaxSens2()/2);
		}
	}


}
