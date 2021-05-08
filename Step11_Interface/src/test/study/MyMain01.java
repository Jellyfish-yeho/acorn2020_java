package test.study;

import test.mypac.MyRemocon;
import test.mypac.Remocon;


public class MyMain01 {
	static Remocon r3=new Remocon() {
		public void up() {
			System.out.println("d");
		}
		public void down() {
			System.out.println("dd");
		}
	};
	public static void main(String[] args) {
		useRemocon(r3);
		
		Remocon r1=new Remocon() {

			@Override
			public void up() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void down() {
				// TODO Auto-generated method stub
				
			}
			
		};
		useRemocon(r1);
		
		useRemocon(new Remocon() {
			public void up() {
				System.out.println("dd");
			}
			public void down() {
				System.out.println("ee");
			}
		});
		
	}
	
	
	
	
	public static void useRemocon(Remocon r) {
		r.up();
		r.down();
	}
	
}
