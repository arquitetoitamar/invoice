package br.com.emissor.controller.response;

import java.io.Serializable;
import java.util.List;

import br.com.emissor.repository.entity.StatusProcess;

public class InvoiceVO implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3100890436455561569L;
	private int id;
	private String orderDate;
	private String orderStatus;
	private String datePayment;
	private String paymentStatus;
	private String shippingDate;
	private String shippingStatus;
	private String total;
	private String discount;
	private String sinal;
	private String cost;
	private StatusProcess statusProcess;
	private String totalTaxes;
	private CustomerVO customer;
	private CompanyVO company;
	private List<ItemInvoiceVO> items;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
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
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public StatusProcess getStatusProcess() {
		return statusProcess;
	}
	public void setStatusProcess(StatusProcess statusProcess) {
		this.statusProcess = statusProcess;
	}
	public String getTotalTaxes() {
		return totalTaxes;
	}
	public void setTotalTaxes(String totalTaxes) {
		this.totalTaxes = totalTaxes;
	}
	public CustomerVO getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerVO customer) {
		this.customer = customer;
	}
	public CompanyVO getCompany() {
		return company;
	}
	public void setCompany(CompanyVO company) {
		this.company = company;
	}
	public List<ItemInvoiceVO> getItems() {
		return items;
	}
	public void setItems(List<ItemInvoiceVO> items) {
		this.items = items;
	}
	
	
}
