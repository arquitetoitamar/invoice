package br.com.emissor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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
import br.com.emissor.repository.InvoiceRepository;
import br.com.emissor.repository.entity.Invoice;
import br.com.emissor.service.InvoiceService;

@Controller
public class InvoiceRestController {

	@Autowired
	private InvoiceRepository invoiceRepository;

	@Autowired
	private InvoiceService invoiceService;

	@RequestMapping(value="invoice", method=RequestMethod.GET)
	public @ResponseBody ResponseEntity<?>  get(
			   @RequestParam (name="companyName", required=false) String name, @RequestParam (name="page", required=false)  Pageable pageable) throws BusinessException {
		if (name != null) {
			return new ResponseEntity<>( invoiceRepository.findByCompanyName(name, pageable), HttpStatus.OK);
		}
		return new ResponseEntity<>( invoiceRepository.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value="invoice/{id}", method=RequestMethod.GET, produces="application/json")
	public @ResponseBody  ResponseEntity<Invoice>  findOne(@PathVariable("id") Integer id) throws BusinessException{
		return new ResponseEntity<Invoice>( invoiceRepository.findOne(id), HttpStatus.OK);
	}
	
	@RequestMapping(value="invoice", method= RequestMethod.PUT)
	public @ResponseBody  ResponseEntity<Invoice>  put(@RequestBody Invoice invoice) throws BusinessException{
		Invoice result = invoiceRepository.save(invoice);
		if(result == null) 
			throw new BusinessException("Não foram encontrado dadoos");
		return new ResponseEntity<Invoice>( result, HttpStatus.OK);
	}
	@RequestMapping(value="invoice", method= RequestMethod.POST)
	@Transactional(propagation=Propagation.REQUIRED)
	public @ResponseBody  ResponseEntity<InvoiceIssuerResponse>  post(@RequestBody Invoice invoice) throws BusinessException{
		invoiceService.send(invoice);
		return new ResponseEntity<InvoiceIssuerResponse>( new InvoiceIssuerResponse(2, "Enviado para fila"), HttpStatus.OK);
	}

	@RequestMapping(value="invoice/{id}", method=RequestMethod.DELETE)
	public @ResponseBody  ResponseEntity<InvoiceIssuerResponse>  delete(@PathVariable("id") Integer id) throws BusinessException {
		invoiceRepository.delete(invoiceRepository.findOne(id));
		return new ResponseEntity<InvoiceIssuerResponse>( new InvoiceIssuerResponse(0, "EXCLUIDO COM SUCESSO!"), HttpStatus.OK);
	}
}
