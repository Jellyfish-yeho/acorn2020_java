package test.study;

import java.util.Random;

public class Study05 {
	public static void main(String[] args) {
		/*   
		 *   String[] items={"cherry", "apple", "banana", "melon", "7"};
		 *   1. cherry, apple, banana, melon, 7
		 *      5개의 문자열 중에서 1개가 랜덤하게 출력되게 해 보세요.
		 *   2. 5개의 문자열 중에서 3개가 한줄에 한번에 랜덤하게 출력되게 해 보세요.
		 *      예)  cherry | apple | cherry
		 *           7 | apple | melon
		 *           7 | 7 | 7
		 */
		//렌덤하게 출력할 문자열을 미리 배열에 담아 놓는다. 
		//렌덤한 숫자를 얻어내기 위한 객체
		//0~4 사이의 렌덤한 정수 얻어내기
		
		//렌덤하게 얻어낸 3개의 정수를 저장할 배열
		//렌덤한 정수를 얻어내서 
		//배열에 저장한다 
		//렌덤한 정수 3개 참조
		//출력할 문자열 구성하기
		//출력하기 
		
		Random ran=new Random();
		String[] slotM= {"w","a","s","d"};
		
		int ranNum=ran.nextInt(3);
		System.out.println(slotM[ranNum]);
		
		
		int[] nums=new int[2];
		for(int i=0; i<nums.length; i++) {
			int ranNum1=ran.nextInt(4);
			nums[i]=ranNum1;
		}
		int a=nums[0];
		int b=nums[1];
		String system=slotM[a]+", "+slotM[b]+"!!";
		System.out.println(system);
		
		
		
		
		
		
	}
}
