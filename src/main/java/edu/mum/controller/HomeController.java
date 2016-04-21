package edu.mum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
  
@Controller
public class HomeController {


	@RequestMapping(value={"/","/Home"})
	public String welcome(Model model) {
		
		model.addAttribute("greeting", "Welcome to U-Store!!");
		
		return "Home";
	}
 
	/*@RequestMapping("/newOwner")
	public String ownerRegistration(Model model) {
		
		return "redirect:/owner/addOwner";
	}*/
}
