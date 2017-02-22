package br.com.emissor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.emissor.exceptions.BusinessException;
import br.com.emissor.repository.CompanyRepository;
import br.com.emissor.repository.CustomerRepository;
import br.com.emissor.repository.InvoiceItemRepository;
import br.com.emissor.repository.InvoiceRepository;
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
	public void process(Invoice invoice) throws BusinessException {
		if (invoice.getCompany() != null) {
			invoice.setCompany(companyRepository.findOne(invoice.getCompany().getId() ));
		}
		if (invoice.getCustomer() != null) {
			invoice.setCustomer(customerRepository.findOne(invoice.getCustomer().getId()));
		}
		
		Invoice result = invoiceRepository.save(invoice);
		if(invoice.getItems() != null){
			for(InvoiceItem invoiceItem : invoice.getItems()){
				invoiceItem.getId().setOrderId(result.getId());
				invoiceItemRepository.save(invoiceItem);
			}
		}
		invoice.setStatusProcess(StatusProcess.PROCESSED);
		if(result == null) 
			throw new BusinessException("Não foram encontrado dadoos");
		;
	}

}
