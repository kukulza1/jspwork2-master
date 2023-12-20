package notice;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import common.JDBCUtil;

public class NoticeDAO {
	Connection conn;
    PreparedStatement pstmt;
    ResultSet rs ;
    
    public void noticewrite(NoticeVO n) {
    	conn=JDBCUtil.getConnection();
    	 
 		try {
 			String sql = "insert into notice (nno, ntitle, ncontent, nname, filename) "
 					+ "values(seq_nno.nextVal, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, n.getNtitle());
			pstmt.setString(2, n.getNcontent());
			pstmt.setString(3, n.getNname());	
			pstmt.setString(4, n.getFilename());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt);
		}
    }
    
    
    public List<NoticeVO> getnoticelist(int page) {
    	conn=JDBCUtil.getConnection();
		List<NoticeVO> nl= new ArrayList<>();
	   try {
		   String sql = "select * "
		   		+ " from (select rownum as RN, noti.* from(select * from notice order by nno desc) noti) "
		   		+ " where RN >= ? and RN <= ? ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, (page-1)*10+1);
		pstmt.setInt(2, page*10);
		rs= pstmt.executeQuery();
		while(rs.next()) {
			NoticeVO nv = new NoticeVO();
			nv.setNno(rs.getInt("nno"));
			nv.setNtitle(rs.getString("ntitle"));
			nv.setNcontent(rs.getString("ncontent"));
			nv.setNname(rs.getString("nname"));
			nv.setNdate(rs.getTimestamp("ndate"));
			nl.add(nv);
		}						
		
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		JDBCUtil.close(conn, pstmt, rs);
	}
    	
		return nl;
    }
    
    public List<NoticeVO> getnoticelist(String field, String kw, int page) {
    	conn=JDBCUtil.getConnection();
		List<NoticeVO> nl= new ArrayList<>();
	   try {
		   String sql = "select * "
		   		+ " from (select rownum as RN, noti.* "
		   		+ "	from(select * from notice "
		   		+ " where  " + field +  " like ?  order by nno desc) noti) "
		   		+ " where RN >= ? and RN <= ? ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "%" +kw + "%");
		pstmt.setInt(2, (page-1)*10+1);
		pstmt.setInt(3, page*10);
		rs= pstmt.executeQuery();
		while(rs.next()) {
			NoticeVO nv = new NoticeVO();
			nv.setNno(rs.getInt("nno"));
			nv.setNtitle(rs.getString("ntitle"));
			nv.setNcontent(rs.getString("ncontent"));
			nv.setNname(rs.getString("nname"));
			nv.setNdate(rs.getTimestamp("ndate"));
			nl.add(nv);
		}						
		
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		JDBCUtil.close(conn, pstmt, rs);
	}
    	
		return nl;
    }
    
    
    public void deleteboard(int nno) {
    	conn=JDBCUtil.getConnection();
    	
    	try {
    		String sql = "delete from notice where nno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, nno);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt);
		}
    }
    
    public void updatenotice(NoticeVO n) {
    	Timestamp now = new Timestamp(System.currentTimeMillis());
    	conn=JDBCUtil.getConnection();
    		   	
    	try {
    	String sql = "update notice set ntitle=?, ncontent=? , ndate=? , filename=? "
    	                  + " where nno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, n.getNtitle());
			pstmt.setString(2, n.getNcontent());
			pstmt.setString(3, n.getFilename());
		
			pstmt.setTimestamp(4, now);
			pstmt.setInt(5, n.getNno());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt);
		}
    }
    
    public NoticeVO getnotice(int nno) {
    	conn=JDBCUtil.getConnection();
    	NoticeVO nv= new NoticeVO(); 	
    	try {
    		String sql = "select*from board where bno = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, nno);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				nv.setNno(rs.getInt("nno"));
				nv.setNtitle(rs.getString("ntitle"));
				nv.setNcontent(rs.getString("ncontent"));
				nv.setNname(rs.getString("nname"));
				nv.setNdate(rs.getTimestamp("ndate"));
				nv.setNhit(rs.getInt("nhit"));
				nv.setFilename(rs.getString("filename"));
				
				sql="update notice set hit= hit+1  where nno=?";
				pstmt = conn.prepareStatement(sql);			
				pstmt.setInt(1, nno);
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
    	return nv;
    }
    
    public int getnoticecount() {
    	int total=0;
    		
	   try {
		   conn=JDBCUtil.getConnection();
		   String sql = "select count(*) as total from notice ";
		pstmt = conn.prepareStatement(sql);
		rs= pstmt.executeQuery();
		if(rs.next()) {
			total = rs.getInt("total");
		}						
		
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		JDBCUtil.close(conn, pstmt, rs);
	}
    	
		return total;
    }

}
