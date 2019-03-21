package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerservice;

	@GetMapping("/list")
	public String listCustomers(Model theModel) {

		// get customer form Service
		List<Customer> customers = customerservice.getCustomers();

		// add the customer to Model
		theModel.addAttribute("customers", customers);

		return "list-customer";
	}

	@GetMapping("/ShowFormForAdd")
	public String ShowFormForAdd(Model theModel) {

		Customer theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer);
		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {

		// save customer to Database
		customerservice.saveCustomer(theCustomer);

		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel){
		
		Customer theCustomer = customerservice.getCustomer(theId);
		
		theModel.addAttribute("customer", theCustomer); 
		
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("customerId") int theId){
		
		// delete the Customer
		customerservice.deleteCustomer(theId);
		
		return "redirect:/customer/list";
	}
	
	@PostMapping("/search")
	public String search(@RequestParam("theSearchName") String theSearchName, Model theModel){
		
		// search customer from the service
		List<Customer> theCustomers = customerservice.searchCustomer(theSearchName);
		
		// add the customer to model
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customer";
	}
}
