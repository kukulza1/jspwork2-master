package member;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCUtil;



public class MemberDAO {
	 Connection conn;
     PreparedStatement pstmt;
     ResultSet rs ;
	
  public void insertmember(Member m) {
	  conn=JDBCUtil.getConnection(); 
	  try {
		  String sql = "insert into member(id, passwd, name, email, phone, zip_code, address, detailAddress) "
		  		+ "values(?, ?, ?, ? , ? , ? , ? , ? )" ; 
		pstmt =conn.prepareStatement(sql);
		pstmt.setString(1, m.getId());
		pstmt.setString(2, m.getPasswd());
		pstmt.setString(3, m.getName());
		pstmt.setString(4, m.getEmail());
		pstmt.setString(5, m.getPhone());		
		pstmt.setString(6, m.getZip_code());	
		pstmt.setString(7, m.getAddress());
		pstmt.setString(8, m.getDetailAddress());
		
		
		pstmt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		JDBCUtil.close(conn, pstmt);
	}
  }
  
  
  public boolean checklogin22(Member mv) {
	   conn=JDBCUtil.getConnection();
	 
	   try {
		   String sql ="select * from member where id =? and passwd=? ";
		pstmt =conn.prepareStatement(sql);
		pstmt.setString(1, mv.getId());
		pstmt.setString(2, mv.getPasswd());
   	rs =pstmt.executeQuery();
   	if(rs.next()) {
   		
   	return true;
   	}
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		JDBCUtil.close(conn, pstmt, rs);
	}
	   
	   return false;
  }
  
  
  public List<Member> getAllmember(){
	  conn=JDBCUtil.getConnection();
		List<Member> ml= new ArrayList<>();
		try {
			String sql = "select*from member order by id";
			pstmt = conn.prepareStatement(sql);
			rs= pstmt.executeQuery();
			while(rs.next()) {
				Member mv =new Member();
				mv.setId(rs.getString("id"));
				mv.setPasswd(rs.getString("passwd"));
				mv.setName(rs.getString("name"));
				mv.setEmail(rs.getString("email"));
				mv.setPhone(rs.getString("phone"));
				mv.setJoinDate(rs.getTimestamp("joindate"));
				mv.setAddress(rs.getString("address"));
				
				ml.add(mv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
	return ml;
	  
  }
  public void updateMember(String id, Member m) {
		
		try {
			conn = JDBCUtil.getConnection();
			String sql = "update member set name = ? , email = ?, phone = ? , zip_code = ? , address = ? , detailaddress = ? "
					+ "  where id = ?           ";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getName());
			pstmt.setString(2, m.getEmail());
			pstmt.setString(3, m.getPhone());
			pstmt.setString(4, m.getZip_code());
			pstmt.setString(5, m.getAddress());
			pstmt.setString(6, m.getDetailAddress());
			pstmt.setString(7, id);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
	}

//회원정보 삭제DAO메서드
public void deleteMember(String id) {
	
		try {
			conn = JDBCUtil.getConnection();
			String sql = "delete from member where id = ? ";
			pstmt = conn.prepareStatement(sql);		
			pstmt.setString(1, id);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
	}
  
  
  
  
}
