package product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCUtil;

public class ProductDAO {
	Connection conn;
    PreparedStatement pstmt;
    ResultSet rs ;
    
    public List<ProductVO> getnoticelist(int pno) {
    	conn=JDBCUtil.getConnection();
		List<ProductVO> pl= new ArrayList<>();
	   try {
		   String sql = "select *  from product where pno= ? ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pno);
	
		rs= pstmt.executeQuery();
		while(rs.next()) {
			ProductVO pv = new ProductVO();
			
			pv.setPname(rs.getString("pname"));
			pv.setPrice(rs.getInt("price"));
			
			pl.add(pv);
			
			
		}						
		
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		JDBCUtil.close(conn, pstmt, rs);
	}
    	
		return pl;
    }
	

}
