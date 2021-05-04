package test.study;

import test.mypac.Car;
import test.mypac.MyObject;
import test.mypac.Radio;
import test.mypac.Speaker;

public class MyMain {
	public static void main(String[] args) {
		MyObject o1=new MyObject();
		o1.walk();
		int num=o1.getNumber();
		String greet = o1.getGreeting();		
		/* 동일한 패키지 혹은 java.lang 패키지에 속한 클래스가 아니면
		 * 반드시 import 해야 사용할 수 있다. 
		 */
		Car car1=o1.getCar();
		car1.drive();
		//method를 호출하면서 적절한 type 데이터를 전달해야 호출 가능하다.
		o1.setNum(1000);
		int num1=99;
		//int type 데이터가 들어 있는 변수명으로 데이터를 전달할 수도 있다. 
		o1.setNum(num1);
		
		o1.setName("name");
		String name1="jellyfish";
		o1.setName(name1);
		
		o1.useCar(new Car());
		Car c1=new Car();
		o1.useCar(c1);
		
		o1.useSome("names", new Car());
		o1.useSome(name1, c1);
		
		o1.doSome(new Radio(), new Speaker());		
	}
}
