package br.com.emissor.repository.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the produto database table.
 * 
 */
@Entity
@Table(name = "item")
public class Item implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 2426761950541579163L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, table="item")
	private int id;

	public Item() {
	}

	@Column
	private String dateCreate;

	@Column
	private String dateUpdate;

	@Column(length = 100)
	private String name;

	@Column(length = 100)
	private String ncm;
	
	@Column
	private String description;

	@Column
	private String brand;

	@Column
	private String category;

	@Column
	private String url;
	
	@Column
	private StatusProcess statusProcess;

	@Column(length = 45)
	private String price;

	@Column( length = 45)
	private String cost;

	@Column(length = 45)
	private String sku;

	@Column( length = 255)
	private String thumbnail;
/*	
	// bi-directional many-to-one association to Pedido
	@OneToMany(mappedBy = "item", fetch=FetchType.LAZY)
	private List<InvoiceItem> invoiceItems;*/

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	

	public String getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(String dateCreate) {
		this.dateCreate = dateCreate;
	}

	public String getDateUpdate() {
		return dateUpdate;
	}

	public void setDateUpdate(String dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNcm() {
		return ncm;
	}

	public void setNcm(String ncm) {
		this.ncm = ncm;
	}

	public StatusProcess getStatusProcess() {
		return statusProcess;
	}

	public void setStatusProcess(StatusProcess statusProcess) {
		this.statusProcess = statusProcess;
	}

/*	public List<InvoiceItem> getInvoiceItems() {
		return invoiceItems;
	}

	public void setInvoiceItems(List<InvoiceItem> invoiceItems) {
		this.invoiceItems = invoiceItems;
	}*/
	
}