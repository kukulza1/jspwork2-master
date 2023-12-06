package buyend;

import java.io.Serializable;
import java.sql.Timestamp;

public class BuyendVO implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private String product;
	private Timestamp orderdate;
	private int ordernum;
	private int price ;
	private String id;
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public Timestamp getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Timestamp orderdate) {
		this.orderdate = orderdate;
	}
	public int getOrdernum() {
		return ordernum;
	}
	public void setOrdernum(int ordernum) {
		this.ordernum = ordernum;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	
}
