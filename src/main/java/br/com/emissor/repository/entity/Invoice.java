package br.com.emissor.repository.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The persistent class for the pedido database table.
 * 
 */
@Entity
@Table(name = "invoice")
public class Invoice implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6223834324815421413L;
	public Invoice() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, table="invoice")
	private int id;

	@Column
	private String orderDate;

	@Column(length = 45)
	private String orderStatus;

	@Column
	private String datePayment;

	@Column(length = 45)
	private String paymentStatus;

	@Column( length = 45)
	private String shippingDate;

	@Column( length = 45)
	private String shippingStatus;

	@Column
	private String total;

	@Column
	private String discount;

	@Column
	private String sinal;
	
	@Column
	private String cost;
	@Column
	private StatusProcess statusProcess;

	@Column
	private String totalTaxes;
	
	@JsonBackReference
	@JsonProperty
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "fk_cod_customer", nullable = false)
	private Customer customer;
	
	@JsonBackReference
	@JsonProperty
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "fk_cod_company", nullable = false)
	private Company company;
	
	@Transient
	@JsonManagedReference
	private List<InvoiceItem> items;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}


	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}


	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getDatePayment() {
		return datePayment;
	}

	public void setDatePayment(String datePayment) {
		this.datePayment = datePayment;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getShippingDate() {
		return shippingDate;
	}

	public void setShippingDate(String shippingDate) {
		this.shippingDate = shippingDate;
	}

	public String getShippingStatus() {
		return shippingStatus;
	}

	public void setShippingStatus(String shippingStatus) {
		this.shippingStatus = shippingStatus;
	}

	

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getSinal() {
		return sinal;
	}

	public void setSinal(String sinal) {
		this.sinal = sinal;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public String getTotalTaxes() {
		return totalTaxes;
	}

	public void setTotalTaxes(String totalTaxes) {
		this.totalTaxes = totalTaxes;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<InvoiceItem> getItems() {
		return items;
	}

	public void setItems(List<InvoiceItem> items) {
		this.items = items;
	}

	public StatusProcess getStatusProcess() {
		return statusProcess;
	}

	public void setStatusProcess(StatusProcess statusProcess) {
		this.statusProcess = statusProcess;
	}

}