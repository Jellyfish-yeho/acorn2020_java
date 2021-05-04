package test.pack;

public class Computer {
	//필드
	public Cpu cpu;
	//기본 생성자(인자로 아무것도 전달 받지 않는 생성자)
	public Computer() {
		System.out.println("기본 생성자 호출");
	}
	//생성자
	public Computer(Cpu cpu) {
		this.cpu=cpu;
	}	
	//메소드
	public void doGame() {
		if(this.cpu==null) {
			System.out.println("cpu가 없어서 동작하지 않는다");
			return;
		}
		System.out.println("pc로 게임을 합니다~!");
	}

	
	//메소드 끝내기
	
	
	
	
}
