package test.study;

	import test.mypac.Car;
import test.mypac.Messenger;
import test.mypac.MyObject;
	import test.mypac.Radio;
	import test.mypac.Speaker;
	
public class study01 {
	public static void main(String[] args) {
		//MyObject 클래스에 정의된 3개의 메소드를 
		//차례로 호출하는 code 를 작성해 보세요.
		MyObject o1=new MyObject();
		o1.getNumber();
		o1.walk();
		o1.getGreeting();		
		//메소드가 리턴해주는 데이터를 지역 변수에 담아보기
		int a=o1.getNumber();
		String b=o1.getGreeting();
		//getCar() 메소드가 리턴해주는 참조값을 지역변수에 담아보기
		Car c=o1.getCar();		
		//지역변수에 담긴 객체 사용하기
		c.drive();
		// .setNum(), .setName(), .useCar()  메소드를 호출해 보세요. 
		o1.setNum(5);
		o1.setName("name");
		o1.useCar(new Car());
		int d=10;
		String e="111";
		Car f=new Car();
		o1.setNum(d);
		o1.setName(e);
		o1.useCar(f);		
		//지역변수에 담긴 값을 이용해서 메소드 
		//호출하면서 전달 할수도 있다.
		
		//useSome() 메소드를 호출해 보세요.
		o1.useSome(e, f);
		Radio r = new Radio();
		Speaker s = new Speaker();
		//doSome() 메소드를 호출해 보세요.
		o1.doSome(r, s);
		
		//Messenger 클래스의 static 메소드 3개를 하나씩 호출해 보세요.
		Messenger.sendMessage("123");
		String aq="1234";
		Messenger.sendMessage(aq);
		
		String bq=Messenger.getMessage();
		
		Messenger.useCar(f);
		
		
		

		}
}
