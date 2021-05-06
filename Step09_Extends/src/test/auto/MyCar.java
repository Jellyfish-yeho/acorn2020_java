package test.auto;

public class MyCar extends Car{

	public MyCar(Engine engine) {
		super(engine);
		// TODO Auto-generated constructor stub
		
	}
	public void run() {
		System.out.println("run run run");
	}
	@Override 
	public void drive() {
		System.out.println("drive too fast that you went to the moon");
	}
}
