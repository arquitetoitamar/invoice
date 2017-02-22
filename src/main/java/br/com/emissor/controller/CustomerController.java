package br.com.bliss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController extends GenericController {

	@RequestMapping("/home")
	public String home() {
		return getModule() +"/index";
	}
	@RequestMapping("/editForm")
	public String editForm() {
		return getModule() +"/editForm";
	}
	@RequestMapping("/form")
	public String form() {
		return getModule() +"/form";
	}

	public String getModule() {
		return "customer";
	}

}
