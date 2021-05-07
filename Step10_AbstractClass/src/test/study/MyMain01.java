package test.study;

import test.mypac.Weapon;

public class MyMain01 {
	public static class YourWeapon extends Weapon{
		@Override
	public void attack() {
		System.out.println("dd");
	}
	}
	
	
	public static void main(String[] args) {
		
		Weapon w1=new YourWeapon();
		useWeapon(w1);
		
		class OurWeapon extends Weapon{
			public void attack() {
				System.out.println("d");
			}
		}
		Weapon w2=new OurWeapon();
		useWeapon(w2);	
		
	}
	
	
	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();
	}

		
	}
	
	

