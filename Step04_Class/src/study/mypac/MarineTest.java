package study.mypac;

public class MarineTest {
	//공격력을 저장하고 있는 static 필드 
	public static int attackPower=5;
	//에너지를 저장하고 있는 non static 필드
	public int energy=40;
	//움직이는 메소드
	public void move() {
		System.out.println("marine moves");
	}
	//공격하는 메소드
	public void attack() {
		System.out.println("attacks with "+this.attackPower);
	}	
	//현재 에너지를 출력하는 메소드
	public void showEnergy() {
		System.out.println("current Energy : "+this.energy);
	}
	
}
