package test.study;

import test.pack.Car;
import test.pack.Student;

public class study01 {
	//Student 객체를 생성해서 참조값을 s1  이라는 변수에 담기
	public static void main(String[] args) {
		Student s1=new Student();
		s1.study();
		s1.goSchool();
		//Car 클래스로 객체를 생성해서 참조값을 c1 이라는 이름의 변수에 담아보세요.
		Car c1=new Car("teslar");
		//c1 에 담겨 있는 참조값을 이용해서 .drive()  메소드를 호출해 보세요.
		c1.drive();
	}
	
	
	
}
