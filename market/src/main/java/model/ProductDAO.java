package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCUtil;

public class ProductDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public List<Product> getProductlist(){
		List<Product> plist = new ArrayList<>();
		
		try {
			//db연결
			conn = JDBCUtil.getConnection();	
			//sql처리
			String sql = "select*from product";
			pstmt=conn.prepareStatement(sql);
			rs= pstmt.executeQuery();
			
			while(rs.next()) {
				Product p = new Product();
				p.setPno(rs.getInt("pno"));
				p.setPid(rs.getString("pid"));
				p.setPname(rs.getString("pname"));
				p.setPrice(rs.getInt("price"));
				p.setDescription(rs.getString("p_description"));
				p.setCategory(rs.getString("p_category"));
				p.setStock(rs.getLong("p_stock"));
				p.setCondition(rs.getString("p_condition"));
				p.setPimage(rs.getString("p_image"));
				p.setRegDate(rs.getTimestamp("regdate"));
				p.setUpdateDate(rs.getTimestamp("updatedate"));
				plist.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		
		//db종료
		
		
		return plist;
	}

	public void insertproduct(Product p) {
		conn = JDBCUtil.getConnection();
		
		try {
			String sql = "insert into product(pid, pname, price, p_description, p_category, p_stock, p_condition, p_image) "
					+ " Values(?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, p.getPid());
			pstmt.setString(2, p.getPname());
			pstmt.setInt(3, p.getPrice());
			pstmt.setString(4, p.getDescription());
			pstmt.setString(5, p.getCategory());
			pstmt.setLong(6, p.getStock());
			pstmt.setString(7, p.getCondition());
			pstmt.setString(8, p.getPimage());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt);
		}
	}

	public Product getoneproduct(String pid){
		Product p = new Product();
		
		try {
			//db연결
			conn = JDBCUtil.getConnection();	
			//sql처리
			String sql = "select*from product where pid = ? ";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, pid);
			rs= pstmt.executeQuery();
			
			if(rs.next()) {					
				p.setPno(rs.getInt("pno"));
				p.setPid(rs.getString("pid"));
				p.setPname(rs.getString("pname"));
				p.setPrice(rs.getInt("price"));
				p.setDescription(rs.getString("p_description"));
				p.setCategory(rs.getString("p_category"));
				p.setStock(rs.getLong("p_stock"));
				p.setCondition(rs.getString("p_condition"));
				p.setPimage(rs.getString("p_image"));
				p.setRegDate(rs.getTimestamp("regdate"));
				p.setUpdateDate(rs.getTimestamp("updatedate"));	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt, rs);
		}				
		return p;
	}
	
    public void deleteproduct(String pid) {
    	conn = JDBCUtil.getConnection();
    	
    	String sql = "delete from product where pid= ? ";
		try {
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, pid);				
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt);
		}	
		
		
    }

	public void updatep(Product p) {
    conn = JDBCUtil.getConnection();

    	String sql = "update  product set  pname = ?, price = ? , p_description = ? , p_category = ?,"
    			+ " p_stock = ? , p_condition = ? , p_image = ? "
    			+ " where pid= ? ";
		try {
			
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, p.getPname());
			pstmt.setInt(2, p.getPrice());
			pstmt.setString(3, p.getDescription());
			pstmt.setString(4, p.getCategory());
			pstmt.setLong(5, p.getStock());
			pstmt.setString(6, p.getCondition());
			pstmt.setString(7, p.getPimage());
			pstmt.setString(8, p.getPid());				
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt);
		}	
		
	}
	
	public void updatepNoimg(Product p) {
		conn = JDBCUtil.getConnection();

		    	String sql = "update  product set  pname = ?, price = ? , p_description = ? , p_category = ?,"
		    			+ " p_stock = ? , p_condition = ? "
		    			+ " where pid= ? ";
				try {
					
					pstmt=conn.prepareStatement(sql);
					
				
					pstmt.setString(1, p.getPname());
					pstmt.setInt(2, p.getPrice());
					pstmt.setString(3, p.getDescription());
					pstmt.setString(4, p.getCategory());
					pstmt.setLong(5, p.getStock());
					pstmt.setString(6, p.getCondition());
				
					pstmt.setString(7, p.getPid());				
					pstmt.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					JDBCUtil.close(conn, pstmt);
				}	
				
			}

}
