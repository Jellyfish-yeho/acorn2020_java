package test.study;

import java.util.Scanner;

public class Study03 {
	public static void main(String[] args) {
		/*
		 *  1. Scanner 객체를 이용해서 문자열을 5번 입력 받는다.
		 *     입력 받은 문자열은 차례대로 배열에 저장 되어야 한다.
		 *     모두다 입력 받은후 for 문을 이용해서 배열에 저장된 
		 *     모든 문자열을 콘솔창에 순서대로 출력하는 코드를 작성해 보세요.
		 */
		//Scanner 객체를 생성해서 참조값을 지역 변수에 담기
		//문자열(String) 5개를 담을수 있는 배열 객체 생성해서 참조값을 지역변수에 담기
		//5번 문자열을 입력 받기 위해 for 문을 구성한다. 
		//입력받은 문자열의 참조값을 배열에 순서대로 저장하기
		
		//i번째 방에 있는 String  객체의 참조값을 불러온다.
		//콘솔에 출력한다.

		Scanner scan=new Scanner(System.in);
		String[] msgs=new String[5];
		for (int i=0; i<5; i++) {
			System.out.println("Enter any word : ");
			String str=scan.nextLine();
			msgs[i]=str;
		}
		for (int i=0; i<msgs.length; i++) {
			System.out.println(msgs[i]);
		}
		
		
		
	}
}
