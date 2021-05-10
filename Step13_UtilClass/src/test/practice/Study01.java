package test.practice;

import java.util.ArrayList;

public class Study01 {
	public static void main(String[] args) {
		ArrayList<String> names=new ArrayList<>();
		
		names.add("asdf");
		
		int size=names.size();
		
		String name1=names.get(0);
		
		names.set(0, "fdsa");
		
		names.remove(0);
		
		names.clear();
	}
}
