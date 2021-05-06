package test.study;

import java.util.Random;

public class Study06 {
	public static void main(String[] args) {
		String[] items= {"a","b","c","d","e","lotto"};
		Random ran=new Random();
		int[] nums=new int[3];
		for(int i=0; i<3; i++) {
			int ranNum=ran.nextInt(6);
			nums[i]=ranNum;
		}
		int a=nums[0];
		int b=nums[1];
		int c=nums[2];
		String line=items[a]+", "+items[b]+", "+items[c];
		System.out.println(line);
		
		int[] scores= {10,20,30,40,50,1000};
		if(nums[0]==nums[1] && nums[1]==nums[2]) {
			int score=scores[nums[0]];
			System.out.println(score+" is your score.");
		}else {
			System.out.println("0 score");
		}
		
		
	}
}
