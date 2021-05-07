package test.study;

import test.mypac.Weapon;

public class MyMain03 {

	static Weapon w1=new Weapon() {
		public void attack() {
			System.out.println("d");
		}
	};
	
	public static void main(String[] args) {
		useWeapon(w1);
	}
	
	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
