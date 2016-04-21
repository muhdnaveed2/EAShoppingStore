package edu.mum.controller;

import java.io.File;
import java.security.Principal;
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
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.domain.Address;
import edu.mum.domain.Authority;
import edu.mum.domain.BillingInfo;
import edu.mum.domain.Customer;
import edu.mum.domain.GenderLine;
import edu.mum.domain.Product;
import edu.mum.domain.ShoppingCart;
import edu.mum.domain.ShoppingOrder;
import edu.mum.service.AddressService;
import edu.mum.service.BillingInfoService;
import edu.mum.service.CustomerService;
import edu.mum.service.ProductService;
import edu.mum.service.WelcomeService;

@Controller
@RequestMapping(value="/product")
@SessionAttributes(value={"checkoutProducts","product","items","totalPrice","address","billingInfo","customerSession"})
public class ProductController {

	@Autowired
	private ProductService productService;
	
	private List<Product> checkoutProducts = new ArrayList();
	
	private static final String SERVER_URI = "http://localhost:8080/EAShoppingStore";
	@Autowired
	private AddressService addressService;
	@Autowired
	private BillingInfoService billingInfoService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private WelcomeService welcomeService;
	
	//Add Product Show Form
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value="/addProduct", method=RequestMethod.GET)	
    public String showForm(@ModelAttribute("productAdd") Product product, Model model)
	{
		model.addAttribute("genderEnum", GenderLine.values());
        return "newProduct";
    }

	//Add Product
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value="/addProduct", method=RequestMethod.POST)
    public String processForm(@Valid @ModelAttribute("productAdd") Product product, BindingResult bindingResult, Model model, 
    		RedirectAttributes redirectAttributes, HttpServletRequest request)
    {
    	if (bindingResult.hasErrors()) {
			return "newProduct";
		}
 
    	String[] suppressedFields = bindingResult.getSuppressedFields();
		if (suppressedFields.length > 0) {
			throw new RuntimeException("Attempt to bind fields that haven't been allowed in initBinder(): " + StringUtils.addStringToArray(suppressedFields, ", "));
		}
		
		MultipartFile productImage = product.getProductImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		
		if (productImage!=null && !productImage.isEmpty()) {
		       try {
		    	   productImage.transferTo(new File(rootDirectory+"\\resources\\images\\"+ product.getName() + ".jpg"));
		       } catch (Exception e) {
				throw new RuntimeException("Product Image saving failed", e);
		   }
		}
		
		productService.save(product);
		redirectAttributes.addFlashAttribute("product", product);
		return "redirect:/product/productSaved";
	
	}
	
	//Product Saved
	@RequestMapping(value="/productSaved", method=RequestMethod.GET)	
    public String productSaved(Model model)
    {		
		return "saveProduct";
	}
	
	//Show All Products
	@RequestMapping(value="/showProducts", method=RequestMethod.GET)
    public String showAllProducts(Model model)
	{
    	model.addAttribute("products", productService.getAllProducts());
        return "showProducts";
    }

	//Get Product Details
	@RequestMapping(value="/getProductDetail", method=RequestMethod.GET)	
    public String getProductDetail(@RequestParam("product_id") long id, Model model)
	{
		model.addAttribute("product",productService.getProduct(id));
        return "productDetail";
    }
	
	//Product Checkout
	@PreAuthorize("hasRole('ROLE_USER')")
	@RequestMapping(value="/addToCart", method=RequestMethod.POST)	
	public String addToCart(@ModelAttribute("cartAdd") ShoppingCart shoppingCart, BindingResult bindingResult, Model model, 
    		RedirectAttributes redirectAttributes)		
    {
    	if (bindingResult.hasErrors()) {
			return "showProducts";
		}
 
    	String[] suppressedFields = bindingResult.getSuppressedFields();
		if (suppressedFields.length > 0) {
			throw new RuntimeException("Attempt to bind fields that haven't been allowed in initBinder(): " + StringUtils.addStringToArray(suppressedFields, ", "));
		}
		
//		Product product = (Product)model.asMap().get("product");
//		checkoutProducts.add(productService.getProduct(id));
		Product product = (Product)model.asMap().get("product");
		System.out.println("------product.getName()---------" + product.getName());
		checkoutProducts.add(product);
		System.out.println("---------checkoutProducts.size():--------" + checkoutProducts.size());
		model.addAttribute("checkoutProducts", checkoutProducts);
		return "redirect:/product/showProducts";
	
	}
	
	/*
	 * Checkout product
	 */
	@PreAuthorize("hasRole('ROLE_USER')")
	@RequestMapping(value = "/checkout", method = RequestMethod.GET) 
	public String showForm(Model model) {
		List<Product> checkoutProducts11 = (List<Product>)model.asMap().get("checkoutProducts");

		double sum = 0;
		for(Product product:checkoutProducts)
			sum += product.getPrice();
		model.addAttribute("items", checkoutProducts.size());
		model.addAttribute("totalPrice", sum);
		
		return "checkout";
	}

	@PreAuthorize("hasRole('ROLE_USER')")
	@RequestMapping(value = "/checkout", method = RequestMethod.POST)
	public String processPlaceOrder(@Valid @ModelAttribute("placeOrderAdd") ShoppingOrder shoppingOrder,
			BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes,HttpServletRequest request) {
	if (bindingResult.hasErrors()) {
			return "checkout";
		}
		String[] suppressedFields = bindingResult.getSuppressedFields();
		if (suppressedFields.length > 0) {
			throw new RuntimeException("Attempt to bind fields that haven't been allowed in initBinder(): "
					+ StringUtils.addStringToArray(suppressedFields, ", "));
		}
		
		Customer customer = (Customer)model.asMap().get("customerSession");
		customer.addShoppingOrder(shoppingOrder);
		customerService.saveOrderInfo(customer);
		String orderNo = customer.getOrders().get(customer.getOrders().size()-1).getOrderNo();
		
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
		
		customer.setBillingInfo(billingInfo);
		model.addAttribute("billingInfo",billingInfo);
		return "checkout";
	}
	
	//Welcome page
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcomePage(Model model, Principal principal){
		Authority authority = welcomeService.getRole(principal.getName());
		System.out.println(customerService.getCustomer(principal.getName()).getName());
		model.addAttribute("customerSession", customerService.getCustomer(principal.getName()));
		model.addAttribute("username", principal.getName());
		
		return "redirect:/product/showProducts";
	}
	
    @InitBinder
    public void initBinder(WebDataBinder binder) {
 //       binder.setDisallowedFields(new String[]{"firstName"});
      }
}
