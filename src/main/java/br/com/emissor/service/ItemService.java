package br.com.emissor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.emissor.repository.ItemRepository;
import br.com.emissor.repository.entity.Item;
import br.com.emissor.repository.entity.StatusProcess;

@Service
public class ItemService {
	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private ProducerService producerService;

	@Transactional(propagation=Propagation.REQUIRED)
	public void process(Item item) {
		try{
			Item entity = itemRepository.save(item);
			entity.setStatusProcess(StatusProcess.PROCESSED);
			itemRepository.save(entity);//atualizastatus
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	public void send(Item item){
		producerService.send(item);
	}
}
