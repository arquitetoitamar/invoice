package br.com.emissor.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.emissor.exceptions.BusinessException;
import br.com.emissor.repository.CompanyRepository;
import br.com.emissor.repository.CustomerRepository;
import br.com.emissor.repository.InvoiceItemRepository;
import br.com.emissor.repository.InvoiceRepository;
import br.com.emissor.repository.entity.Company;
import br.com.emissor.repository.entity.Customer;
import br.com.emissor.repository.entity.Invoice;
import br.com.emissor.repository.entity.InvoiceItem;
import br.com.emissor.repository.entity.StatusProcess;

@Service
public class InvoiceService {
	@Autowired
	private InvoiceItemRepository invoiceItemRepository;
	@Autowired
	private CompanyRepository companyRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private ProducerService producerService;
	
	@Autowired
	private InvoiceRepository invoiceRepository;

	public void send(Invoice invoice){
		invoice.setStatusProcess(StatusProcess.SEND_TO_QUEUE);
		producerService.send(invoice);
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public void process(Invoice invoice) throws BusinessException {
		List<InvoiceItem> invoiceItems = new ArrayList<>();
		
		if(invoice.getItems() != null){
			for(InvoiceItem invoiceItem : invoice.getItems()){
				invoiceItems.add(invoiceItem);
			}
		}
		if (invoice.getCompany() != null) {
			Company company = companyRepository.findOne(invoice.getCompany().getId() );
			if (company == null) {
				 invoice.setCompany(companyRepository.save(invoice.getCompany()));
			} else 
			   invoice.setCompany(company);
		}
		if (invoice.getCustomer() != null) {
			Customer customer = customerRepository.findOne(invoice.getCustomer().getId() );
			if (customer == null) {
				invoice.setCustomer(customerRepository.save(invoice.getCustomer()));
			} else 
			   invoice.setCustomer(customer);
		}
		invoice.setItems(null);
		Invoice result = invoiceRepository.save(invoice);
		
		if (result == null) 
			throw new BusinessException("Ocorreu erro ao salvar nota");
		//update invoice with items
		invoiceItems.forEach(invoiceItem -> {
			invoiceItem.getId().setOrderId(result.getId());
			invoiceItemRepository.save(invoiceItem);
		});
		invoice.setStatusProcess(StatusProcess.PROCESSED);
	}

}
