package test.study;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class MemoDao {
		private static MemoDao dao;
		private MemoDao() {}
		public static MemoDao getInstance() {
			if(dao==null) {
				dao=new MemoDao();
				System.out.println("최초로 사용될 때 MemoDao 객체를 생성했습니다.");
			}
			return dao;
		}
		//select
	public MemoDto getData(int num) {
		MemoDto dto=null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = new DBConnect().getConn();
			//실행할 SELECT 문
			String sql = "SELECT content, regdate"
						+" FROM memo"
						+" WHERE num=?";
			pstmt = conn.prepareStatement(sql);
			//? 에 바인딩할 내용은 여기서 바인딩한다.
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				//SELECT 된 결과를 여기서 추출해서 객체에 담는다. 
				dto=new MemoDto();
				dto.setNum(num);
				dto.setContent(rs.getString("content"));
				dto.setRegdate(rs.getString("regdate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)rs.close();
				if (pstmt != null)pstmt.close();
				if (conn != null)conn.close();
			} catch (Exception e) {
			}
		}
		return dto;
	}
	//list 
	public List<MemoDto> getList(){
		List<MemoDto> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn=new DBConnect().getConn();
			String sql="SELECT num, content,to_char(regdate,'yyyy\"년\"mm\"월\"dd\"일\" am HH:mi') as regdate"
						+" FROM memo"
						+" order by num ASC";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int num=rs.getInt("num");
				String content=rs.getString("content");
				String regdate=rs.getString("regdate");
				MemoDto dto=new MemoDto();
				dto.setNum(num);
				dto.setContent(content);
				dto.setRegdate(regdate);
				list.add(dto);
			}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(rs!=null)rs.close();
					if(pstmt!=null)pstmt.close();
					if(conn!=null)conn.close();
				}catch(Exception e) {}
			}
		return list;
	}
	//delete
	public boolean delete(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			conn = new DBConnect().getConn();
			//실행할 sql (Insert, update, delete) 작성
			String sql = "DELETE from memo"
						+" where num=?";
			pstmt = conn.prepareStatement(sql);
			// ? 에 바인딩할 내용이 있으면 여기서 한다.
			pstmt.setInt(1, num);
			flag = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		if (flag > 0) {
			return true;
		} else {
			return false;
		}
	}
	public boolean insert(MemoDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			conn = new DBConnect().getConn();
			//실행할 sql (Insert, update, delete) 작성
			String sql = "insert into memo"
						+" (num,content, regdate)"
						+" values(member_seq.nextval,?,sysdate)";
			pstmt = conn.prepareStatement(sql);
			// ? 에 바인딩할 내용이 있으면 여기서 한다.
			pstmt.setString(1, dto.getContent());
			flag = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		if (flag > 0) {
			return true;
		} else {
			return false;
		}	
	}
	//update
	public boolean update(MemoDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			conn = new DBConnect().getConn();
			//실행할 sql (Insert, update, delete) 작성
			String sql = "update memo"
						+" set content=?, regdate=?"
						+" where num=?";
			pstmt = conn.prepareStatement(sql);
			// ? 에 바인딩할 내용이 있으면 여기서 한다.
			pstmt.setString(1, dto.getContent());
			pstmt.setString(2, dto.getRegdate());
			pstmt.setInt(3, dto.getNum());
			flag = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		if (flag > 0) {
			return true;
		} else {
			return false;
		}
	}
}
