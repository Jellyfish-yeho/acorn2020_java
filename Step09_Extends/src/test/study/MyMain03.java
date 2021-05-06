package test.study;

import test.human.Blood;
import test.human.Men;
import test.human.Person;
import test.human.Woman;

public class MyMain03 {
	public static void main(String[] args) {
		
		//프로그래밍의 목적이 걷는 것이다. 어떻게 걸을 수 있을까?
		//=person 객체의 walk를 호출
		Blood b=new Blood("+","B 형");
		Person p1=new Person(b);
		p1.walk();
		//프로그래밍의 목적이 영화를 보는 것이다
		Men p2=new Men(b);
		p2.seeMovie();
		//프로그래밍의 목적이 독서를 하는 것이다
		Woman p3=new Woman(b);
		p3.reading();
		//부모의 메소드 호출
		p3.walk();
		p3.study();
		//다형성 확인
		Person p4=p3;
		Object p5=p3;
	}
}
