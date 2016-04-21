package edu.mum.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.domain.Address;
import edu.mum.domain.BillingInfo;
import edu.mum.domain.Customer;
import edu.mum.domain.Product;
import edu.mum.domain.ShoppingOrder;
import edu.mum.service.AddressService;
import edu.mum.service.BillingInfoService;
import edu.mum.service.CustomerService;

@Controller
// @RequestMapping(value="/order")
@SessionAttributes(value={"items","totalPrice","address","billingInfo"})
public class OrderController {
	/*private static final String SERVER_URI = "http://localhost:8080/EAShoppingStore";
	@Autowired
	private AddressService addressService;
	@Autowired
	private BillingInfoService billingInfoService;
	
	@Autowired
	private CustomerService customerService;
	

	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public String showForm(@ModelAttribute("checkoutProducts") ArrayList<Product> checkoutProducts,Model model) { 
		model.addAttribute("shippingAdress", customer.getShippingAddress());
		model.addAttribute("billingInfo", customer.getBillingInfo());
		List<Product> checkoutProducts11 = (List<Product>)model.asMap().get("checkoutProducts");
		System.out.println("checkoutProducts.size(): " + checkoutProducts.size());
		System.out.println("checkoutProducts11.size(): " + checkoutProducts11.size());
		double sum = 0;
		for(Product product:checkoutProducts)
			sum += product.getPrice();
		model.addAttribute("items", checkoutProducts.size());
		System.out.println("totalPrice: " + sum);
		model.addAttribute("totalPrice", sum);
		
		return "checkout";
	}

	@PreAuthorize("hasRole('ROLE_USER')")
	@RequestMapping(value = "/checkout", method = RequestMethod.POST)
	public String processPlaceOrder(@Valid @ModelAttribute("placeOrderAdd") ShoppingOrder shoppingOrder,
			BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes,@ModelAttribute("customerSession") Customer customer,
			HttpServletRequest request) {
		if (bindingResult.hasErrors()) {
			return "checkout";
		}
		String[] suppressedFields = bindingResult.getSuppressedFields();
		if (suppressedFields.length > 0) {
			throw new RuntimeException("Attempt to bind fields that haven't been allowed in initBinder(): "
					+ StringUtils.addStringToArray(suppressedFields, ", "));
		}
		
		customer.addShoppingOrder(shoppingOrder);
		customerService.save(customer);
//		model.addAttribute("orderNo", shoppingOrder.getOrderNo());
		return "orderConfirmation";
	}
	
	@RequestMapping(value = "/addShippingAddress", method = RequestMethod.GET)
	public String showFormShippingAddress(@ModelAttribute("shippingAddressAdd") Address address, Model model) {
		return "addShippingAddress";
	}

	@RequestMapping(value = "/addShippingAddress", method = RequestMethod.POST)
	public String processShippingAddress(@Valid @ModelAttribute("shippingAddressAdd") Address address,
			BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes,@ModelAttribute("customerSession") Customer customer,
			HttpServletRequest request) {
		if (bindingResult.hasErrors()) {
			return "addShippingAddress";
		}
		String[] suppressedFields = bindingResult.getSuppressedFields();
		if (suppressedFields.length > 0) {
			throw new RuntimeException("Attempt to bind fields that haven't been allowed in initBinder(): "
					+ StringUtils.addStringToArray(suppressedFields, ", "));
		}
//		Customer customer = (Customer) model.asMap().get("customerSession");

		addressService.save(address);
		customer.setShippingAddress(address);
		model.addAttribute("address",address);
		return "checkout";
	}

	@RequestMapping(value = "/addBillingInfo", method = RequestMethod.GET)
	public String showFormBillingInfo(@ModelAttribute("billingInfoAdd") BillingInfo billingInfo, Model model) {
		return "addBillingInfo";
	}

	@RequestMapping(value = "/addBillingInfo", method = RequestMethod.POST)
	public String processBillingInfo(@Valid @ModelAttribute("billingInfoAdd") BillingInfo billingInfo,
			BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes,@ModelAttribute("customerSession") Customer customer,
			HttpServletRequest request)
	{	
		//WebService call to validate the Card Number
		RestTemplate restTemplate = new RestTemplate();
//		Boolean response = restTemplate.postForObject(SERVER_URI+"/rest/authenticate",billingInfo, Boolean.class);
		Boolean response = restTemplate.getForObject(SERVER_URI+"/rest/authenticate/creditcard?cardnumber=" + billingInfo.getCardNumber() + "&cardname=" + billingInfo.getCardName() + "&cardexpiry=" + billingInfo.getCardExpiry() + "&cardpin=" + billingInfo.getCardPin(), 
				Boolean.class);
		
		if (bindingResult.hasErrors()) {
			return "addBillingInfo";
		}
		
		if(!response)
		{
			model.addAttribute("message","Card Not validated!");
			return "addBillingInfo";
		}
		
		String[] suppressedFields = bindingResult.getSuppressedFields();
		if (suppressedFields.length > 0) {
			throw new RuntimeException("Attempt to bind fields that haven't been allowed in initBinder(): "
					+ StringUtils.addStringToArray(suppressedFields, ", "));
		}
		
		billingInfoService.save(billingInfo);
//		Customer customer = (Customer) model.asMap().get("customerSession");
		customer.setBillingInfo(billingInfo);
		model.addAttribute("billingInfo",billingInfo);
		return "checkout";
	}*/
}