package br.com.emissor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.emissor.controller.response.InvoiceIssuerResponse;
import br.com.emissor.exceptions.BusinessException;
import br.com.emissor.repository.ItemRepository;
import br.com.emissor.repository.entity.Invoice;
import br.com.emissor.repository.entity.Item;
import br.com.emissor.service.ItemService;

@Controller
public class ItemRestController {
	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private ItemService itemService;

	@RequestMapping(value="item", method=RequestMethod.GET)
	public @ResponseBody ResponseEntity<?>  get(
		   @RequestParam (name="nome",required=false) String nome) throws BusinessException {
		if (nome != null) {
			return new ResponseEntity<>( itemRepository.findByName(nome), HttpStatus.OK);
		}
		return new ResponseEntity<>( itemRepository.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value="item/{id}", method=RequestMethod.GET, produces="application/json")
	public @ResponseBody  ResponseEntity<Item>  findOne(@PathVariable("id") Integer id) throws BusinessException{
		return new ResponseEntity<Item>( itemRepository.findOne(id), HttpStatus.OK);
	}
	
	@RequestMapping(value="item", method= RequestMethod.PUT)
	public @ResponseBody  ResponseEntity<Item>  put(@RequestBody Item item) throws BusinessException{
		Item result = itemRepository.save(item);
		if(result == null) 
			throw new BusinessException("Não foram encontrado dadoos");
		return new ResponseEntity<Item>( result, HttpStatus.OK);
	}
	
	@RequestMapping(value="item", method= RequestMethod.POST)
	@Transactional(propagation=Propagation.REQUIRED)
	public @ResponseBody  ResponseEntity<InvoiceIssuerResponse>  post(@RequestBody Item item) throws BusinessException{
		
		itemService.send(item);
		
		return new ResponseEntity<InvoiceIssuerResponse>( new InvoiceIssuerResponse(2, "Enviado para fila"), HttpStatus.OK);
	}

	@RequestMapping(value="item/{id}", method=RequestMethod.DELETE)
	public @ResponseBody  ResponseEntity<InvoiceIssuerResponse>  delete(@PathVariable("id") Integer id) throws BusinessException {
		itemRepository.delete(itemRepository.findOne(id));
		return new ResponseEntity<InvoiceIssuerResponse>( new InvoiceIssuerResponse(0, "EXCLUIDO COM SUCESSO!"), HttpStatus.OK);
	}
}
