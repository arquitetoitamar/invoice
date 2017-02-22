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
import br.com.emissor.repository.CompanyRepository;
import br.com.emissor.repository.entity.Company;

@Controller
public class CompanyRestController {
	
	@Autowired
	private CompanyRepository companyRepository;

	@RequestMapping(value="company", method=RequestMethod.GET)
	public @ResponseBody ResponseEntity<?>  get(
		   @RequestParam (name="nome",required=false) String nome) throws BusinessException {
		if (nome != null) {
			return new ResponseEntity<>( companyRepository.findByName(nome), HttpStatus.OK);
		}
		return new ResponseEntity<>( companyRepository.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value="company/{id}", method=RequestMethod.GET, produces="application/json")
	public @ResponseBody  ResponseEntity<Company>  findOne(@PathVariable("id") Integer id) throws BusinessException{
		return new ResponseEntity<Company>( companyRepository.findOne(id), HttpStatus.OK);
	}
	
	@RequestMapping(value="company", method= RequestMethod.PUT)
	public @ResponseBody  ResponseEntity<Company>  put(@RequestBody Company company) throws BusinessException{
		Company result = companyRepository.save(company);
		if(result == null) 
			throw new BusinessException("Não foram encontrado dadoos");
		return new ResponseEntity<Company>( result, HttpStatus.OK);
	}
	@RequestMapping(value="company", method= RequestMethod.POST)
	@Transactional(propagation=Propagation.REQUIRED)
	public @ResponseBody  ResponseEntity<Company>  post(@RequestBody Company company) throws BusinessException{
//		if (church.getEndereco() != null) {
//			companyRepository.save(church.getEndereco());
//		}
		Company result = companyRepository.save(company);
		if(result == null) 
			throw new BusinessException("Não foram encontrado dadoos");
		return new ResponseEntity<Company>( result, HttpStatus.OK);
	}

	@RequestMapping(value="company/{id}", method=RequestMethod.DELETE)
	public @ResponseBody  ResponseEntity<InvoiceIssuerResponse>  delete(@PathVariable("id") Integer id) throws BusinessException {
		companyRepository.delete(companyRepository.findOne(id));
		return new ResponseEntity<InvoiceIssuerResponse>( new InvoiceIssuerResponse(0, "EXCLUIDO COM SUCESSO!"), HttpStatus.OK);
	}

}
