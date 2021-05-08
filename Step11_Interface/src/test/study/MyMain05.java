package test.study;

import test.mypac.Calculator;

public class MyMain05 {
	public static void main(String[] args) {
		Calculator add=(a,b)->a+b;
		Calculator sub=(a,b)->a-b;
		Calculator multi=(a,b)->a*b;
		Calculator divide=(a,b)->a/b;
		
		double result1=add.exec(1, 2);
		double result2=sub.exec(1, 2);
		double result3=multi.exec(1, 2);
		double result4=divide.exec(1, 2);
		
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		System.out.println(result4);
		
		useCalculator((a,b)->a+b);
		useCalculator((a,b)->a-b);
		useCalculator((a,b)->a*b);
		useCalculator((a,b)->a/b);
		
	}
	
	public static void useCalculator(Calculator c) {
		System.out.println(c.exec(10, 20));
	}
}
