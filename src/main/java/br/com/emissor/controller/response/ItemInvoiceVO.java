package br.com.emissor.controller.response;

import java.io.Serializable;

public class ItemInvoiceVO  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3922402544252129969L;
	public int id;
	public int quantity = 1;
	public int itemId;
	public String name;
	public String price;
	
	public ItemInvoiceVO() {
		super();
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
