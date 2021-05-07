package test.study;

import test.mypac.Weapon;

public class MyMain02 {
	
	public static void main(String[] args) {
		
	
	
	Weapon w1=new Weapon() {
		public void attack() {
			System.out.println("dddd");
		}
	};
	
	useWeapon(w1);
	
	useWeapon(new Weapon() {
		public void attack() {
			System.out.println("dd");
		}
	});
	
	
	
	}
	
	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();
	}
}
