package br.com.emissor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import br.com.emissor.controller.response.InvoiceVO;
import br.com.emissor.exceptions.BusinessException;
import br.com.emissor.repository.entity.Item;
import br.com.emissor.repository.entity.StatusProcess;

@Component
public class ConsumerService {
	@Autowired
	private InvoiceService invoiceService;
	@Autowired
	private ItemService itemService;
	
	@JmsListener(destination = "invoice.queue")
	public void receiveQueue(InvoiceVO invoice) {
		System.out.println("invoice process");
		try {
			invoice.setStatusProcess(StatusProcess.PROCESSING);
			invoiceService.process(invoice);
			
		} catch (BusinessException e) {
			e.printStackTrace();
		}
	}
	@JmsListener(destination = "item.queue")
	public void receiveQueue(Item item) {
		System.out.println("item process");
		itemService.process(item);
	}
}
