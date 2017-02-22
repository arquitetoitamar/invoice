package br.com.emissor.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.emissor.controller.response.InvoiceIssuerResponse;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

	@ResponseStatus(HttpStatus.BAD_GATEWAY)
	@ExceptionHandler(value = Exception.class)
	public String handleException(Exception e) {
		return e.getMessage();
	}
	
	@ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public InvoiceIssuerResponse handle(BusinessException e) {
        return new InvoiceIssuerResponse(HttpStatus.SERVICE_UNAVAILABLE.ordinal(), e.getMessage()); // use message from the original exception
    }
}
