package buyend;

import java.io.Serializable;
import java.sql.Timestamp;

public class BuyendVO implements Serializable{

	
	private static final long serialVersionUID = 117L;
	
	private String receipt;
	
	private String product;
	
	private Timestamp orderdate;
	
	private int orderNo;
	
	private int price ;
	
	private String id;
	
	

	
	
	public String getReceipt() {
		return receipt;
	}

	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}

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

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
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
