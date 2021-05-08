package test.study;

import test.mypac.Drill;

public class MyMain03 {
	public static void main(String[] args) {
		useDrill(new Drill() {

			@Override
			public void hole() {
				System.out.println("dd");				
			}
			
		});
		Drill d1=()->{
			System.out.println("ddd");
		};
		
		useDrill(d1);
		useDrill(()->{
			System.out.println("ddd");
		});
		
	}
	
	
	public static void useDrill(Drill d) {
		d.hole();
	}
}
