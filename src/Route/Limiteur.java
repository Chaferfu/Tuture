package Route;

public class Limiteur extends Semaphore 
{
	private int limite;
	
	
	public Limiteur(int l,Sens sens) 
	{
		super(sens);
		limite = l;
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
		if(this.limite < this.getSegment().getvMaxSens1()){
			this.getSegment().setvMaxSens1(limite);
		}
	}
	
	public void modifierVitesse2(){
		if(this.limite < this.getSegment().getvMaxSens2()){
			this.getSegment().setvMaxSens2(limite);
		}
	}



}
