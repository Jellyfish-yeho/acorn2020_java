package test.exception;

public class DoNotKnowException extends Exception{
	//생성자
	public DoNotKnowException(String msg) {
		//생성자의 인자로 전달받은 예외 메시지를 부모 생성자에 전달하기
		super(msg);
	}
}
