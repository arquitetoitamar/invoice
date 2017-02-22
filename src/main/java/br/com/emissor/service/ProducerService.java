package br.com.emissor.service;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import br.com.emissor.repository.entity.Invoice;
import br.com.emissor.repository.entity.Item;

@Component
public class ProducerService {
	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;

	@Autowired
	private Queue queueInvoice;
	@Autowired
	private Queue queueItem;


	public void send(Invoice invoice) {
		this.jmsMessagingTemplate.convertAndSend(this.queueInvoice, invoice);
	}
	public void send(Item item) {
		this.jmsMessagingTemplate.convertAndSend(this.queueItem, item);
	}
}
