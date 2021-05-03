package test.study;

import test.mypac.Car;

public class MyMain01 {
	public static void main(String[] args) {
		System.out.println("main method 가 시작되었습니다.");
		Car c1=new Car();
		Car c2=new Car();
		c1.name = "마세라티";
		String carName=c1.name;
		System.out.println(carName);
		c2.drive();		
	}
}
