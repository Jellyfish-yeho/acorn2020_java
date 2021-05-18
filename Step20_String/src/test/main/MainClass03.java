package test.main;

import java.util.Scanner;

public class MainClass03 {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("Input your ID "
				+ "(must start with alphabet, "
				+ "special characters are not allowed)");
		String line=scan.nextLine();
		String reg="^[a-zA-Z][\\w]+$";
		//String 객체의 matches() 메소드를 이용하면 문자열을 정규표현식으로 
		//검증해서 매칭 여부를 알 수 있다. 
		boolean isMatch=line.matches(reg);
		if(isMatch) {
			System.out.println("Input correct");
		}else {
			System.out.println("Please check your ID matches the format.");
		}
	}
}
