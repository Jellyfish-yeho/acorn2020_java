package test.main;

import java.util.Random;

import test.exception.DoNotKnowException;
import test.exception.HungryException;

public class MainClass {
	public static void main(String[] args) {
		//노는 메소드 호출
		play();
		try {
			study();
		} catch (DoNotKnowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("구라쌤한테 질문해야지");
		}
		System.out.println("메인 메소드 정상 종료");
		
	}
	//노는 메소드
	public static void play() {
		Random ran=new Random();
		int ranNum=ran.nextInt(3);
		if(ranNum==0) {
			throw new HungryException("아 배고파!!!!");
		}
		System.out.println("다 놀았습니다");
	}
	//공부하는 메소드
	public static void study() throws DoNotKnowException {
		Random ran=new Random();
		int ranNum=ran.nextInt(3);
		if(ranNum==0) {
			throw new DoNotKnowException("너무 어렵다...");
		}
		System.out.println("공부를 마쳤습니다");
	}
}
