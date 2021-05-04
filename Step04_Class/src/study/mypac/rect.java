package study.mypac;
//사각형의 정보를 담을수 있는 Rect 클래스 
public class rect {
	//non static 필드  
	public int width;
	//폭
	public int height;
	//높이
	
	public int getArea() {
		int result=this.height * this.width;
		return result;
	}
	//사각형의 면적을 리턴해주는 non static 메소드 
}
