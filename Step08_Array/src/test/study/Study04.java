package test.study;

import java.util.Random;

public class Study04 {
	public static void main(String[] args) {
		/*
		 * 2. Random 객체를 이용해서 로또 번호를 6개 렌덤하게 얻어내서
		 *    배열에 저장한다.
		 *    모두다 저장이 되면 for 문을 이용해서 배열에 저장된 모든 로또 번호를
		 *    콘솔창에 순서대로 출력하는 코드를 작성해 보세요.
		 */
		//로또 번호를 저장할수 있는 방 6개짜리 배열 객체 생성하기 
		//반복문 돌면서 로또번호 6개를 얻어낸다.
		//순서대로 저장하기
		Random ran=new Random();
		int[] nums=new int[6];
		for(int i=0; i<6; i++) {
			int ranNum=ran.nextInt(45)+1;
			nums[i]=ranNum;
		}
		for(int i=0; i<nums.length; i++) {
			System.out.println(nums[i]);
		}
		
		
		
	}
}
