package edu.mum.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.mum.domain.Authority;
import edu.mum.domain.Customer;
import edu.mum.service.CustomerService;
import edu.mum.service.WelcomeService;

@Controller
@SessionAttributes("customerSession")
public class WelcomeController {
	
	@Autowired
	private WelcomeService welcomeService;
	
	@Autowired
	private CustomerService customerService;
	
	/*@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcomePage(Model model, Principal principal){
		Authority authority = welcomeService.getRole(principal.getName());
		System.out.println(customerService.getCustomer(principal.getName()).getName());
		model.addAttribute("customerSession", customerService.getCustomer(principal.getName()));
		model.addAttribute("username", principal.getName());
		
		return "redirect:/product/showProducts";
	}*/
}