package model;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
@Getter  @Setter //@-어노테이션(라이브러리주입)di 
public class Product implements Serializable{
	private static final long serialVersionUID = 144L;
	private int pno;
	private String pid;
	private String pname;
	private int price;
	private String description;
	private String category;
	private long stock;
	private String condition;
	private String pimage;
	private Timestamp regDate;
	private Timestamp updateDate;
	private int quantity; //장바구니에 담은 품목수량
	

}
