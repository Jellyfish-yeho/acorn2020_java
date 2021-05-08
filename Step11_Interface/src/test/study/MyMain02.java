package test.study;

import test.mypac.Drill;
import test.mypac.MultiPlayer;
import test.mypac.Remocon;

public class MyMain02 {
	public static void main(String[] args) {
		MultiPlayer mp=new MultiPlayer();
		useRemocon(mp);
		useDrill(mp);
		useMultiPlayer(mp);
		
		Remocon r=mp;
		r.up();
		r.down();
		
		Drill d=mp;
		d.hole();		
	}
	
	public static void useRemocon(Remocon r) {
		r.up();
		r.down();
	}
	public static void useDrill(Drill d) {
		d.hole();
	}
	public static void useMultiPlayer(MultiPlayer mp) {
		mp.up();
		mp.down();
		mp.hole();
	}
	
	
	
}
