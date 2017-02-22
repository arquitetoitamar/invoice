package br.com.emissor.repository.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * The persistent class for the item_pedido database table.
 * 
 */
@Entity
@Table(name="invoice_item")
public class InvoiceItem implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -5220813482054361915L;

	@EmbeddedId
	private InvoiceItemPK id;
	
/*	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "item_id", nullable = false, insertable=false,updatable=false)
	private Item item;*/

	private int quantity;

	public InvoiceItem() {
	}

	public InvoiceItem(InvoiceItemPK id, int quantity) {
		super();
		this.id = id;
		this.quantity = quantity;
	}

	public InvoiceItemPK getId() {
		return this.id;
	}

	public void setId(InvoiceItemPK id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
/*
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}*/
	
}