package test.study;

import test.auto.Car;
import test.auto.Engine;
import test.auto.Truck;

public class MyMain02 {
	public static void main(String[] args) {
		// Car 객체를 생성해서 참조값을 c1이라는 지역변수에 담기
		Car c1= new Car(new Engine());
		Truck t1=new Truck(new Engine());
		t1.dump();
	}
}
