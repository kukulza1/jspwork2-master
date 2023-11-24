package addressbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCUtil;

//addrBook자료형을 이용하여 주소를 생성 검색 수정 삭제하는클래스
public class AddrBookDAO {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null; 
    
	//주소추가
	public void addadr(AddrBook a1) {
		//연결
		conn = JDBCUtil.getConnection();
		//sql
		try {
			String sql="insert into addrbook(bnum,username,tel,email,gender)  "
					+ "  values(seq_bnum.NextVal,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			//폼에 입력된자료를 가져와서 db에 저장
			pstmt.setString(1,a1.getUsername());
			pstmt.setString(2,a1.getTel());
			pstmt.setString(3,a1.getEmail());
			pstmt.setString(4,a1.getGender());
			//sql실행
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt);
		}
	}
	//주소 전체목록
	
	public List<AddrBook> getall(){
		conn = JDBCUtil.getConnection();
		List<AddrBook> a3 = new ArrayList<>();
		try {
			String sql="select*from addrbook order by bnum";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();		
			while(rs.next()) {
				AddrBook a2= new AddrBook();
				a2.setBnum(rs.getInt("bnum"));
				a2.setUsername(rs.getString("username"));
				a2.setTel(rs.getString("tel"));
				a2.setEmail(rs.getString("email"));
				a2.setGender(rs.getString("gender"));
				a2.setRegdate(rs.getTimestamp("regdate"));
				
				a3.add(a2);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt,rs);
		}
		return a3;	
	}
	public AddrBook getone(int bnum) {
		conn = JDBCUtil.getConnection();
		AddrBook a2= new AddrBook();
		try {
			String sql="select*from addrbook where bnum=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,bnum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				a2.setBnum(rs.getInt("bnum"));
				a2.setUsername(rs.getString("username"));
				a2.setTel(rs.getString("tel"));
				a2.setEmail(rs.getString("email"));
				a2.setGender(rs.getString("gender"));
				a2.setRegdate(rs.getTimestamp("regdate"));
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt,rs);
		}
		return a2;
	}
	//로그인 체크
	public boolean checkLogin(String email) {
		conn=JDBCUtil.getConnection();
		try {
			String sql = "select email from addrbook "+" where email=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs=pstmt.executeQuery();
			if(rs.next()) { //검색한 이메일이 있으면
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt,rs);
		}
		return false;
	}
	
	
	public void delete(int bnum) {
		conn = JDBCUtil.getConnection();
		
		try {
			String sql="delete from addrbook where bnum=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,bnum);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}






















