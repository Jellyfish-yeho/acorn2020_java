package test.study;

import test.auto.Car;
import test.auto.Engine;
import test.auto.MyCar;
import test.auto.SportsCar;
import test.auto.Truck;

public class Study01 {
	public static void main(String[] args) {
		MyCar c1=new MyCar(new Engine());
		
		Study01.useCar(c1);
	}
	public static void useCar(Car car) {
		car.drive();
	}
}
