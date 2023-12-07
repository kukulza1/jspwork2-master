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
		  String sql = "insert into spmember(id,passwd,name,email,tel,address1,address2,address3,address4) "
		  		+ "values(?, ?, ?, ? , ? , ? , ? , ? , ?)" ; 
		pstmt =conn.prepareStatement(sql);
		pstmt.setString(1, m.getId());
		pstmt.setString(2, m.getPasswd());
		pstmt.setString(3, m.getName());
		pstmt.setString(4, m.getEmail());
		pstmt.setString(5, m.getTel());
		pstmt.setString(6, m.getAddress1());
		pstmt.setString(7, m.getAddress2());
		pstmt.setString(8, m.getAddress3());
		pstmt.setString(9, m.getAddress4());
		
		
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
		   String sql ="select * from spmember where id =? and passwd=? ";
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
