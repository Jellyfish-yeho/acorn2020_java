package test.study01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.util.DBConnect;

public class FoodDao {
	private static FoodDao dao;
	private FoodDao() {}
	public static FoodDao getInstance() {
		if(dao==null) {
			dao=new FoodDao();
		}return dao;
	}

	//name, regdate insert - insert into ~ num name regdate values(seq ~)
	public boolean insert(FoodDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			conn = new DBConnect().getConn();
			//실행할 sql (Insert, update, delete) 작성
			String sql = "insert into foodie"
						+" (num, name, regdate)"
						+" values(foodie_seq.nextval,?,sysdate)";
			pstmt = conn.prepareStatement(sql);
			// ? 에 바인딩할 내용이 있으면 여기서 한다.
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getRegdate());
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
	
	//name, regdate update - update ~ set name ~ regdate where num~
	public boolean update(FoodDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			conn = new DBConnect().getConn();
			//실행할 sql (Insert, update, delete) 작성
			String sql = "update foodie"
						+" set name=?, regdate=?"
						+" where num=?";
			pstmt = conn.prepareStatement(sql);
			// ? 에 바인딩할 내용이 있으면 여기서 한다.
			pstmt.setString(1, dto.getName());
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
	
	//delete - delete from ~ where ~ 
	public boolean delete(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			conn = new DBConnect().getConn();
			//실행할 sql (Insert, update, delete) 작성
			String sql = "delete from foodie"
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
	
	//1명 select - select name regdate from ~ where num~
	public FoodDto getData(int num) {
		FoodDto dto=null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = new DBConnect().getConn();
			//실행할 SELECT 문
			String sql = "select name,regdate"
						+" from foodie"
						+" where num=?";						
			pstmt = conn.prepareStatement(sql);
			//? 에 바인딩할 내용은 여기서 바인딩한다
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				//SELECT 된 결과를 여기서 추출해서 객체에 담는다. 
				dto=new FoodDto();
				dto.setNum(num);
				dto.setName(rs.getString("name"));
				dto.setRegdate(rs.getString("regdate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		return dto;
	}
	
	//list select - select name regdate from ~ order by num asc
	public List<FoodDto> getList(){
		List<FoodDto> list=new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = new DBConnect().getConn();
			//실행할 SELECT 문
			String sql = "select num, name, regdate"
						+" from foodie"
						+" order by num asc";
			pstmt = conn.prepareStatement(sql);
			//? 에 바인딩할 내용은 여기서 바인딩한다.
			rs = pstmt.executeQuery();
			while (rs.next()) {
				//SELECT 된 결과를 여기서 추출해서 객체에 담는다. 
				int num=rs.getInt("num");
				String name=rs.getString("name");
				String regdate=rs.getString("regdate");
				FoodDto dto=new FoodDto();
				dto=new FoodDto();
				dto.setNum(num);
				dto.setName(name);
				dto.setRegdate(regdate);
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}return list;
	}
	
}

	

