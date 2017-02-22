package br.com.emissor.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import br.com.emissor.controller.response.CompanyVO;
import br.com.emissor.controller.response.CustomerVO;
import br.com.emissor.controller.response.InvoiceVO;
import br.com.emissor.repository.entity.Invoice;

@Component
public class InvoiceConverter {
	
	public InvoiceVO convertEntityToVO(Invoice invoice) {
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
}
