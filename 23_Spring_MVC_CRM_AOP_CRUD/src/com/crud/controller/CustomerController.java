package com.crud.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.crud.entity.Customer;
import com.crud.service.CustomerService;
import com.crud.service.CustomerServiceImpl;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	
	@GetMapping("/list") // @RequestMapping(path = "/list", method = RequestMethod.GET)
	public String listCustomers(Model theModel) {
		
		// get customers from the service
		List<Customer> theCustomers = customerService.getCustomers();
				
		// add the customers to the model
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd") // @RequestMapping(path = "/showFormForAdd", method = RequestMethod.GET)
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer") // @RequestMapping(path = "/saveCustomer", method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer,@RequestParam("file") MultipartFile file,
			@RequestParam("date") String date ) throws ParseException, IOException {
		
		// Image
		System.out.println("/saveCustomer | File Name : "+file.getName());
        byte[] imageBytes = file.getBytes();
 
        try {
            FileInputStream fileInputStream = new FileInputStream(file.getOriginalFilename());
            fileInputStream.read(imageBytes);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        theCustomer.setImage(imageBytes);
        
        // Date
        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
		Date registerDate = dateformat.parse(String.valueOf(date));
		
		System.out.println("/saveCustomer | registerDate : " + registerDate);
		
		theCustomer.setRegisterDate(registerDate); 
		
		
		// save the customer using our service
		customerService.saveCustomer(theCustomer);
		
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdateAndDelete")
	public String showFormForUpdateAndDelete(@RequestParam("customerId") int theId,HttpServletRequest request ,
									Model theModel) {
		
		String button = request.getParameter("button");
		if ("Edit".equals(button)) {
			System.out.println("/showFormForUpdate | Edit process is working");
			// get the customer from our service
			Customer theCustomer = customerService.getCustomer(theId);	
			
			// set customer as a model attribute to pre-populate the form
			theModel.addAttribute("customer", theCustomer);
			
			// send over to our form		
			return "customer-form";
		}
		else if("Delete".equals(button)) {
			System.out.println("/showFormForUpdate | Delete process is working");
			
			// delete the customer
			customerService.deleteCustomer(theId);
			
			return "redirect:/customer/list";
		}
		return "";
	}
	
	@GetMapping("/search")
	public String searchCustomers(@RequestParam("theSearchName") String theSearchName,
									Model theModel) {

		// search customers from the service
		List<Customer> theCustomers = customerService.searchCustomers(theSearchName);
				
		// add the customers to the model
		theModel.addAttribute("customers", theCustomers);

		return "list-customers";		
	}
	
	
}
