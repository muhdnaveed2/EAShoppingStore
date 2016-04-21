package edu.mum.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.domain.Customer;
import edu.mum.service.CustomerService;

@Controller
@RequestMapping(value="/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	
	//Add Customer Form
	@RequestMapping(value="/addCustomer", method=RequestMethod.GET)	
    public String showForm(@ModelAttribute("customerAdd") Customer customer, Model model){
    	
        return "newCustomer";
    }

	//Saving Customer
	@RequestMapping(value="/addCustomer", method=RequestMethod.POST)	
    public String processForm(@Valid @ModelAttribute("customerAdd") Customer customer, BindingResult bindingResult, Model model, 
    		RedirectAttributes redirectAttributes, HttpServletRequest request)
    {
    	if (bindingResult.hasErrors()) {
			return "newCustomer";
		}
 
    	String[] suppressedFields = bindingResult.getSuppressedFields();
		if (suppressedFields.length > 0) {
			throw new RuntimeException("Attempt to bind fields that haven't been allowed in initBinder(): " + StringUtils.addStringToArray(suppressedFields, ", "));
		}
		
		customerService.save(customer);
//			redirectAttributes.addFlashAttribute("customer", customer);
		return "redirect:/product/showProducts";
	}
	
	//Redirecting after saving Customer
	@RequestMapping(value="/customerSaved", method=RequestMethod.GET)	
    public String customerSaved(Model model)
    {
		return "showProducts";
	}
	
	//Ending Customer Session
	@RequestMapping(value="/customerLogout", method=RequestMethod.GET)	
    public String customerLogout(SessionStatus status)
    {
		status.setComplete();
		return "redirect:/product/showProducts";
	}

    @InitBinder
    public void initBinder(WebDataBinder binder) {
 //       binder.setDisallowedFields(new String[]{"firstName"});
      }
}
