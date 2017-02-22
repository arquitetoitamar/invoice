package br.com.emissor.repository.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the item_pedido database table.
 * 
 */
@Embeddable
public class InvoiceItemPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

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


	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof InvoiceItemPK)) {
			return false;
		}
		InvoiceItemPK castOther = (InvoiceItemPK)other;
		return 
			(this.orderId == castOther.orderId)
			&& (this.itemId == castOther.itemId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.orderId;
		hash = hash * prime + this.itemId;
		return hash;
	}
}