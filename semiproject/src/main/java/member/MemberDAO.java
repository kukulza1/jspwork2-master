package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCUtil;

public class MemberDAO {
	 Connection conn;
     PreparedStatement pstmt;
     ResultSet rs ;
	
  public void insertmember(MemberVO m) {
	  conn=JDBCUtil.getConnection();
	  
	 
	  try {
		  String sql = "insert into member(id, passwd, name, email, phone, zip_code, address,detailAddress) "
		  		+ "values(?, ?, ?, ? , ? , ? , ? , ? , ?)" ; 
		pstmt =conn.prepareStatement(sql);
		pstmt.setString(1, m.getId());
		pstmt.setString(2, m.getPasswd());
		pstmt.setString(3, m.getName());
		pstmt.setString(4, m.getEmail());
		pstmt.setString(5, m.getPhone());
		pstmt.setTimestamp(6, m.getJoinDate());
		pstmt.setString(7, m.getZip_code());	
		pstmt.setString(8, m.getAddress());
		pstmt.setString(9, m.getDetailAddress());
		
		
		pstmt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		JDBCUtil.close(conn, pstmt);
	}
  }
  
  
  public boolean checklogin22(MemberVO mv) {
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
  
  
  
  
}
