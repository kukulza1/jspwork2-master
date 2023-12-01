package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import common.JDBCUtil;


public class BoardDAO {
	Connection conn;
    PreparedStatement pstmt;
    ResultSet rs ;
    public List<Board> getblist() {
    	conn=JDBCUtil.getConnection();
		List<Board> bl= new ArrayList<>();
	   try {
		   String sql = "select*from board  order by createdate desc";
		pstmt = conn.prepareStatement(sql);
		rs= pstmt.executeQuery();
		while(rs.next()) {
			Board board =new Board();
			board.setBno(rs.getInt("bno"));
			board.setTitle(rs.getString("title"));
			board.setContent(rs.getString("content"));
			board.setCreatedate(rs.getTimestamp("createdate"));
			board.setModifydate(rs.getTimestamp("modifydate"));
			board.setHit(rs.getInt("hit"));
			board.setFilename(rs.getString("filename"));
			board.setMemid(rs.getString("memid"));
			bl.add(board);
		}						
		
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		JDBCUtil.close(conn, pstmt, rs);
	}
    	
		return bl;
    }
    public void insertwrite(Board bb) {
    	conn=JDBCUtil.getConnection();
    	 
 		try {
 			String sql = "insert into board(bno, title, content, memid)  "
 					+ "  values(seq_bno.nextval, ? , ? , ?) ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bb.getTitle());
			pstmt.setString(2, bb.getContent());
			pstmt.setString(3, bb.getMemid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt);
		}
    }
    public Board getboard(int bno) {
    	conn=JDBCUtil.getConnection();
    	Board b= new Board();  	
    	try {
    		String sql = "select*from board where bno = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				b.setBno(rs.getInt("bno"));
				b.setTitle(rs.getString("title"));
				b.setContent(rs.getString("content"));
				b.setCreatedate(rs.getTimestamp("createdate"));
				b.setModifydate(rs.getTimestamp("modifydate"));
				b.setHit(rs.getInt("hit"));
				b.setFilename(rs.getString("filename"));
				b.setMemid(rs.getString("memid"));
				
				//조회수 1증가
				
				sql="update board set hit= hit+1  where bno=?";
				pstmt = conn.prepareStatement(sql);			
				pstmt.setInt(1, bno);
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
    	return b;
    }
    public void deleteboard(int bno) {
    	conn=JDBCUtil.getConnection();
    	
    	try {
    		String sql = "delete from board where bno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt);
		}
    }
    public void updateboard(Board b) {
    	Timestamp now = new Timestamp(System.currentTimeMillis());
    	conn=JDBCUtil.getConnection();
    		   	
    	try {
    	String sql = "update board set title=?, content=? , modifydate=? "
    	                  + " where bno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getContent());
		
			pstmt.setTimestamp(3, now);
			pstmt.setInt(4, b.getBno());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt);
		}
    }

}
