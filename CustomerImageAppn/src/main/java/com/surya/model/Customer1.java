package com.surya.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table
public class Customer1 {
	@Id
	private Integer cid;
	private String cname;
	private String productName;
	private Integer qty;
	private Integer price;
	private Integer total;
	private Integer discount;
	private Integer bill;
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String prodImage;
	public Customer1() {
		super();
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getDiscount() {
		return discount;
	}
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}
	public Integer getBill() {
		return bill;
	}
	public void setBill(Integer bill) {
		this.bill = bill;
	}
	public String getProdImage() {
		return prodImage;
	}
	public void setProdImage(String prodImage) {
		this.prodImage = prodImage;
	}
	public Customer1(Integer cid, String cname, String productName, Integer qty, Integer price, Integer total,
			Integer discount, Integer bill, String prodImage) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.productName = productName;
		this.qty = qty;
		this.price = price;
		this.total = total;
		this.discount = discount;
		this.bill = bill;
		this.prodImage = prodImage;
	}
	@Override
	public String toString() {
		return "Customer1 [cid=" + cid + ", cname=" + cname + ", productName=" + productName + ", qty=" + qty
				+ ", price=" + price + ", total=" + total + ", discount=" + discount + ", bill=" + bill + ", prodImage="
				+ prodImage + "]";
	}
	
	
	

}
