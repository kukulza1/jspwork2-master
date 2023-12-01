package reply;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCUtil;

//댓글을 추가,수정,삭제,검색하는 클래스
public class ReplyDAO {
	Connection conn;
    PreparedStatement pstmt;
    ResultSet rs ;
    
    public List<Reply> getreplylist(int bno){
    	conn=JDBCUtil.getConnection();
    	List<Reply> rr = new ArrayList<>();
    	try {
    		String sql="select*from reply where bno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Reply rp = new Reply();
				rp.setRno(rs.getInt("rno"));
				rp.setBno(rs.getInt("bno"));
				rp.setRcontent(rs.getString("rcontent"));
				rp.setReplyer(rs.getString("replyer"));
				rp.setRdate(rs.getTimestamp("rdate"));
				rp.setRupdate(rs.getTimestamp("rupdate"));
				rr.add(rp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return rr;	
    }
    public void insertreply(Reply r) {
    	conn=JDBCUtil.getConnection();
    	try {
    		String sql="insert into reply(rno, rcontent, replyer, bno) "
    				+ " values(seq_ss.nextVal , ? , ? , ?) ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, r.getRcontent());
			pstmt.setString(2, r.getReplyer());
			pstmt.setInt(3, r.getBno());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt);
		}
    }
    
    public void deletereply(int rno) {
    	conn=JDBCUtil.getConnection();
    	try {
    		String sql="delete from reply where rno=?";
			pstmt = conn.prepareStatement(sql);
		    pstmt.setInt(1, rno);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt);
		}
    }
    
    
    
    
    
    
    
    
    
    
    
}
