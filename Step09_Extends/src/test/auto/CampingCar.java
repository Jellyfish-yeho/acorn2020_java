package test.auto;

public class CampingCar extends Car{
	//constructor
	public CampingCar(Engine engine) {
		super(engine);
	}
	//method
	public void doCamping() {
		//부모 객체의 method 사용 가능, this.생략 가능
		this.drive();
		drive();
		//부모 객체의 field 참조 가능, this.생략 가능
		Engine e=this.engine;
		Engine e1=engine;
	}
}
