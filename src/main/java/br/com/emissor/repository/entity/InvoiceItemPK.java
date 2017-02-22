package br.com.emissor.repository.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the item_pedido database table.
 * 
 */
@Embeddable
public class InvoiceItemPK implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -4675924769688117637L;

	@Column(name="invoice_id", insertable=false, updatable=false, nullable=false)
	private int orderId;

	@Column(name="item_id", insertable=false, updatable=false, nullable=false)
	private int itemId;

	public InvoiceItemPK() {
	}
	

	public InvoiceItemPK(int orderId, int itemId) {
		super();
		this.orderId = orderId;
		this.itemId = itemId;
	}


	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public int getItemId() {
		return itemId;
	}


	public void setItemId(int itemId) {
		this.itemId = itemId;
	}


}