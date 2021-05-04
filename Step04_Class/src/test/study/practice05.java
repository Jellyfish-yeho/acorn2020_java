package test.study;

import study.mypac.rect;

public class practice05 {
	public static void main(String[] args) {
		//Rect 객체 생성해서 참조값을 r1 이라는 지역 변수에 담기 
		rect r1=new rect();
		//Rect 객체의 필드에 값 대입하기
		r1.height=100;
		r1.width=50;
		//Rect 객체의 메소드를 호출해서 리턴되는 int 값을 a 라는 지역변수에 담기 
		int a = r1.getArea();
		System.out.println(a);
		//rect2 도 만들어 보기
		rect r2=new rect();
		r2.height=10;
		r2.width=10;
		int b=r2.getArea();
		System.out.println(b);
		
	}
}
