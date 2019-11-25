package com.uncc.ssdi.supermarket_management_system.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

public class TransactionsVo {
	
	public int transaction_id;
	
	public int product_id;
	
	public int cashier_id;
	
	public int quantity;
	
	public String price;
	
	public String unit;
	
	public Date date;
	
	public int totalprice;

	public TransactionsVo() {
		super();
	}


	public TransactionsVo(int transaction_id, int product_id, int cashier_id, int quantity, String price, String unit,
			Date date, int totalprice) {
		super();
		this.transaction_id = transaction_id;
		this.product_id = product_id;
		this.cashier_id = cashier_id;
		this.quantity = quantity;
		this.price = price;
		this.unit = unit;
		this.date = date;
		this.totalprice = totalprice;
	}



	public int getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getCashier_id() {
		return cashier_id;
	}

	public void setCashier_id(int cashier_id) {
		this.cashier_id = cashier_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	

	public String getPrice() {
		return price;
	}



	public void setPrice(String price) {
		this.price = price;
	}



	public String getUnit() {
		return unit;
	}



	public void setUnit(String unit) {
		this.unit = unit;
	}



	public int getTotalprice() {
		return totalprice;
	}



	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}



	@Override
	public String toString() {
		return "TransactionsVo [transaction_id=" + transaction_id + ", product_id=" + product_id + ", cashier_id="
				+ cashier_id + ", quantity=" + quantity + ", price=" + price + ", unit=" + unit + ", date=" + date
				+ ", totalprice=" + totalprice + "]";
	}
	
	

}
