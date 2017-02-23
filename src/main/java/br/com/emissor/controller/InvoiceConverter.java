package br.com.emissor.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import br.com.emissor.controller.response.CompanyVO;
import br.com.emissor.controller.response.CustomerVO;
import br.com.emissor.controller.response.InvoiceVO;
import br.com.emissor.controller.response.ItemVO;
import br.com.emissor.repository.entity.Company;
import br.com.emissor.repository.entity.Customer;
import br.com.emissor.repository.entity.Invoice;
import br.com.emissor.repository.entity.Item;

@Component
public class InvoiceConverter {
	
	public InvoiceVO convert(Invoice invoice) {
		InvoiceVO target = new InvoiceVO();
		BeanUtils.copyProperties(invoice, target);
		
		CustomerVO customerVO = new CustomerVO();
		invoice.getCustomer().setInvoices(null);
		BeanUtils.copyProperties(invoice.getCustomer(), customerVO);
		target.setCustomer(customerVO);
		
		CompanyVO companyVO = new CompanyVO();
		invoice.getCompany().setInvoices(null);
		BeanUtils.copyProperties(invoice.getCompany(), companyVO);
		target.setCompany(companyVO);
		return target;
	}
	public Invoice convert(InvoiceVO invoice) {
		Invoice target = new Invoice();
		BeanUtils.copyProperties(invoice, target);
		
		Customer customer = new Customer();
		invoice.getCustomer().setInvoices(null);
		BeanUtils.copyProperties(invoice.getCustomer(), customer);
		target.setCustomer(customer);
		
		Company company = new Company();
		invoice.getCompany().setInvoices(null);
		BeanUtils.copyProperties(invoice.getCompany(), company);
		target.setCompany(company);

		return target;
	}
	
	public ItemVO convert(Item item) {
		ItemVO target = new ItemVO();
		BeanUtils.copyProperties(item, target);
		return target;
		
	}
	public Item convert(ItemVO item) {
		Item target = new Item();
		BeanUtils.copyProperties(item, target);
		return target;
		
	}
}
