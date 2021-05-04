package test.study;

import java.io.PrintStream;

import test.mypac.Car;

public class MyMain02 {
	public static void main(String[] args) {
		System.out.println("배고파");
		
		PrintStream a=System.out;
		a.println("흑흑");
		a.println("졸려");
		
		long current =System.currentTimeMillis();
		a.println(current);
		
		String str="hi";
		String str1=new String("hiloo");
		a.println(str);
		a.println(str1);
		
		Car c1=new Car();
		a.println(c1);
		
	}
}
