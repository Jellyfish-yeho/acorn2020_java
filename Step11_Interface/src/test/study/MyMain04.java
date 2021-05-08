package test.study;

import test.mypac.Joinner;

public class MyMain04 {
	public static void main(String[] args) {
		Joinner j1=new Joinner() {

			@Override
			public String join(String first, String second) {
				return first + second;
			}
		};
		String result1=j1.join("rk", "sksek");
		
		Joinner j2=(first, second)->{
			return first+second;
		};
		String result2=j2.join("dd", "ee");
		
		Joinner j3=(first,second)->first+second;
		String result3=j3.join("ddd", "eee");
		
		
	}
}
