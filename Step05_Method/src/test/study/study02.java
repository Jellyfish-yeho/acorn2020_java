package test.study;

import test.mypac.Figure;

public class study02 {
	public static void main(String[] args) {
		
		Figure triangle1=new Figure();
		triangle1.height=20;
		triangle1.width=20;
		double area=triangle1.rightTriangle();
		triangle1.showArea();
		
		Figure circle1=new Figure();
		circle1.radius=7;
		double round=circle1.round();
		circle1.showArea();
		System.out.println("원의 둘레:"+round);}
}
