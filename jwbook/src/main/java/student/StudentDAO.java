package student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCUtil;

//Student 자료형으로 추가,목록을 보여줄 클래스
public class StudentDAO {
	Connection conn= null;
	PreparedStatement pstmt = null;
	ResultSet rs= null; //검색한데이터셋
	
	public List<Student> getStudentList() {
		conn=JDBCUtil.getConnection();
		List<Student> s=new ArrayList<>();
		
		try {
			String sql = "Select*from student order by sid";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Student s1= new Student();
			 
			   s1.setUsername(rs.getString("username"));
			   s1.setUniv(rs.getString("univ"));
			   s1.setBirth(rs.getString("birth"));
			   s1.setEmail(rs.getString("email"));
			   s.add(s1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}
	public void inserstu(Student s) {
		conn=JDBCUtil.getConnection();
		
		try {
			String sql="insert into student(username,univ,birth,email) "+
					"  values(?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1,s.getUsername());
			pstmt.setString(2,s.getUniv());
			pstmt.setString(3,s.getBirth());
			pstmt.setString(4,s.getEmail());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt);
		}
		
	}

}














