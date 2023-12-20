package buyend;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCUtil;

public class BuyendDAO {
	 Connection conn;
     PreparedStatement pstmt;
     ResultSet rs ;

     public List<BuyendVO> getlistAll(){
    	 conn=JDBCUtil.getConnection();
    	 List<BuyendVO> BA = new ArrayList<>();
    	 try {
    		 String sql = "select*from purchasedetail ";
			pstmt = conn.prepareStatement(sql);
			//pstmt.setString(1, id);
			rs= pstmt.executeQuery();
			
			while(rs.next()) {
				BuyendVO ss = new BuyendVO();
				ss.setProduct(rs.getString("product"));
				ss.setOrderdate(rs.getTimestamp("orderdate"));
				ss.setOrderNo(rs.getInt("orderNo"));
				ss.setPrice(rs.getInt("price"));
				
				
				BA.add(ss);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return BA;
    	 
     }
     public void insertbuyend(BuyendVO b) {
    	 conn=JDBCUtil.getConnection();
    	  
 		try {
 			String sql = " insert into purchasedetail(receipt, product, orderno, price, id) "
 					+ " values(?, ?, ?, ?,  ? )" ;
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, b.getReceipt());
			pstmt.setString(2, b.getProduct());
			pstmt.setInt(3, b.getOrderNo());
			pstmt.setInt(4, b.getPrice());
			pstmt.setString(5, b.getId());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt);
		}
    	 
    	
    	 
    	 
    	 
     }
}










