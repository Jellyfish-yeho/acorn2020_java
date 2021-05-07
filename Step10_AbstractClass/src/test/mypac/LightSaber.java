package test.mypac;

import java.util.Random;

public class LightSaber extends Weapon {

	@Override
	public void attack() {
		System.out.println("I am your father :p");		
	}
	@Override
	public void prepare() {
		super.prepare();
		System.out.println("광선검을 뽑습니다");
	}
	public void lightAttack() {
			System.out.println("3개의 검 중 하나를 뽑습니다...");
			Random ran=new Random();
			int sword=ran.nextInt(3);
			System.out.println(sword+"번째 검을 뽑았습니다");
		
	}

}
