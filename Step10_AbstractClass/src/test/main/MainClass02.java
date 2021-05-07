package test.main;

import test.mypac.Gun;
import test.mypac.LightSaber;
import test.mypac.Weapon;

public class MainClass02 {
	public static void main(String[] args) {
		//여러분이 직접 클래스를 만들고 객체 생성을 해서 
		//아래의 useWeapon() 메소드를 호출해 보세요.
		
		LightSaber s=new LightSaber();
		MainClass02.useWeapon(s);
		
	}
	
	public static void useWeapon(Weapon w) {
		w.prepare();
		LightSaber w1=new LightSaber();
		w1.lightAttack();
		w.attack();
	}
}





