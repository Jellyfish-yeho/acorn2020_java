package test.exception;

public class HungryException extends RuntimeException{
	//생성자
	public HungryException(String msg) {
		//생성자의 인자로 전달받은 예외 메시지를 부모 생성자에 전달하기
		super(msg);
	}
}
