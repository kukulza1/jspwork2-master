package voter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCUtil;

public class VoterDAO {
	Connection conn;
    PreparedStatement pstmt;
    ResultSet rs ;
    
    //좋아요 추가
    public void insertvote(Voter v) {
    	conn=JDBCUtil.getConnection();
		try {
			String sql = "insert into voter(vno, bno, mid) "
					+ " Values(seq_vno.nextVal, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, v.getBno());
			pstmt.setString(2, v.getMid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt);
		}
    }
    //좋아요삭제

	public void deletevote(Voter v) {
		conn=JDBCUtil.getConnection();
		
		try {
			String sql = "delete from voter where bno = ? and mid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, v.getBno());
			pstmt.setString(2, v.getMid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt);
		}
		
	}

	
    
    //좋아요 저장 유무 확인체크 -세션아이디 글번호가 일치
	public int checkvoter(int bno, String id) {
		conn=JDBCUtil.getConnection();
			
		try {
			String sql = " select count(*)as result from voter "
					+ "where bno = ? and mid = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			pstmt.setString(2, id);
			rs=pstmt.executeQuery();
			if(rs.next()) { //카운트한 값이 있으면 숫자반환
				return rs.getInt("result"); //일치시 1반환
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return 0; //불일치시 0반환
		
	}

    
    //좋아요 총개수
public int votecount(int bno) {
	conn=JDBCUtil.getConnection();
	
	
	try {
		String sql = " select count(*)as total from voter where bno = ? ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bno);
		rs=pstmt.executeQuery();
		if(rs.next()) { //카운트한 값이 있으면 숫자반환
			return rs.getInt("total");
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		JDBCUtil.close(conn, pstmt, rs);
	}
	return 0; //카운트값이없으면 0반환
	}

}
