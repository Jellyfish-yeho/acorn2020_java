package test.study;

import java.util.List;

public class MyMain01 {
	public static void main(String[] args) {
		MemoDao dao=MemoDao.getInstance();
		List<MemoDto> list=dao.getList();
		
		
		
		for(int i=0; i<list.size(); i++) {
			MemoDto tmp=list.get(i);
			System.out.println(tmp.getNum()+", "
					+tmp.getContent()+", "+tmp.getRegdate());
		}
		
	}

}
