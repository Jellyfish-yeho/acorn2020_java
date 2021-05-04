package test.study;

import test.mypac.Random;

public class study05 {
	public static void main(String[] args) {
	      Random r = new Random();
		  String[] array= {"빨강","노랑","초록","파랑","보라","분홍","흰색","검은색"};
		  System.out.println("오늘 당신의 행운의 색깔은?"+array[r.newRan()]);
		}
}
