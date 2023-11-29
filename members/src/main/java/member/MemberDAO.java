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
       
       public List<Member> getAllmember() {
    	   conn=JDBCUtil.getConnection();
    		List<Member> mm= new ArrayList<>();
    	   try {
    		   String sql = "select*from member order by mno";
			pstmt = conn.prepareStatement(sql);
			rs= pstmt.executeQuery();
			while(rs.next()) {
				Member ss =new Member();
				ss.setMno(rs.getInt("mno"));
				ss.setMemid(rs.getString("memid"));
				ss.setPw(rs.getString("pw"));
				ss.setName(rs.getString("name"));
				ss.setEmail(rs.getString("email"));
				ss.setGender(rs.getString("gender"));	
				ss.setJoinDate(rs.getTimestamp("joindate"));
				mm.add(ss);
			}						
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
    	   return mm;
       }
       //회원가입
       public void insertmember(Member m) {
    	   conn=JDBCUtil.getConnection();
    	   
    	   try {
    		   String sql = "insert into member(mno,memid,pw,name,email,gender)  "
    	    	   		+ "  values(seq_mno.nextVal, ? , ? , ? , ? , ?)" ; 
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, m.getMemid());
			pstmt.setString(2, m.getPw());
			pstmt.setString(3, m.getName());
			pstmt.setString(4, m.getEmail());
			pstmt.setString(5, m.getGender());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt);
		}
       }
}
















