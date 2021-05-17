package test.study01;

public class FoodDto {
	private int num;
	private String name;
	private String regdate;
	
	public FoodDto(){}

	public FoodDto(int num, String name, String regdate) {
		super();
		this.num = num;
		this.name = name;
		this.regdate = regdate;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	

}
