package test.study;

import test.mypac.Apple;
import test.mypac.Banana;
import test.mypac.Orange;
import test.mypac.Package;

public class Study01 {
	public static void main(String[] args) {
		Package<Apple> box1=new Package<Apple>();
		Package<Banana> box2=new Package<>();
		Package<Orange> box3=new Package<>();
		
		box1.push(new Apple());
		box2.push(new Banana());
		box3.push(new Orange());
		
		Apple result1=box1.pull();
		System.out.println(result1);
	}
}
