package test.study;

import study.mypac.MarineTest;

public class Practice111 {
	public static void main(String[] args) {
		MarineTest m1=new MarineTest();
		m1.move();
		m1.attack();
		m1.showEnergy();
		System.out.println("---m1---");
		
		MarineTest m2=new MarineTest();
		m2.move();
		m2.attack();
		m2.showEnergy();
		System.out.println("---m2---");
		//marine 전체의 공격력 올리기
		MarineTest.attackPower +=1;
		m1.attack();
		m2.attack();
		
		//m1의 에너지 감소
		m1.energy-=10;
		m1.showEnergy();
		m2.showEnergy();
		
	}
}
