package com.crs.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView; 
import com.crs.model.Customer;
import com.crs.model.Employee;
import com.crs.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService custservice;
	
	@RequestMapping("/main")
	public ModelAndView landing() {		
		ModelAndView mv = new ModelAndView("customerlogin");
		return mv;	
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession(false);
		session.invalidate();
		ModelAndView mv = new ModelAndView("customerlogin");
		return mv;	
	}
	
	@RequestMapping("/customerhome")
	public ModelAndView customerhome() {		
		ModelAndView mv = new ModelAndView("customerhome");
		return mv;	
	}
	
	@RequestMapping("/customerpanel")
	public ModelAndView customerpanel() {		
		ModelAndView mv = new ModelAndView("customerpanel");
		return mv;	
	}
	
	@RequestMapping("/ViewCustomers")
    public ModelAndView viewcustomers() {
        ModelAndView mv = new ModelAndView("ViewCustomer");
        List<Customer> customers = custservice.getCustomers();
        mv.addObject("customers",customers);
        return mv;       
    }
	
	@RequestMapping("/editCustomer")
	public ModelAndView updatelanding(
			@RequestParam("id") String id) {
		
		Customer result = custservice.getCustomerById((Integer.parseInt(id)));		
		ModelAndView mv = new ModelAndView("customerupdate");
		mv.addObject("customer",result);
		return mv;
		
		
	}
	
	
	@RequestMapping("/UpdateCustomer")
	public ModelAndView updatecustomer(
			@RequestParam("id") String id ,
			@RequestParam("name") String name,
			@RequestParam("contact") String contact,
			@RequestParam("address") String address,
			@RequestParam("username") String username,
			@RequestParam("password") String password) {
		Customer customer = new Customer();
		customer.setId(Integer.parseInt(id));
		customer.setName(name);
		customer.setContactno(contact);
		customer.setAddress(address);
		customer.setUsername(username);
		customer.setPassword(password);
		custservice.updateCustomer(customer);
		return viewcustomers();	
	}
	
	@RequestMapping("/deleteCustomer")
	public ModelAndView delcustomer(
			@RequestParam("id") String id
			) {
		Customer customer = custservice.getCustomerById(Integer.parseInt(id));	
		custservice.deleteCustomer(customer);
		
		return viewcustomers();
	}
	
	
	@RequestMapping("/login")
	public ModelAndView logincustomer(
			@RequestParam("uname") String username,
			@RequestParam("pass") String pass,
			HttpServletRequest request
			) {
		Customer result = custservice.loginCustomer(username, pass);
		
		if(result != null){
			ModelAndView mv = new ModelAndView("customerhome");
			HttpSession session = request.getSession();
			 session.setAttribute("customerid", result.getId());
			 request.setAttribute("customerid", result.getId());
			mv.addObject("customer",result); 
			return mv;
		}
		else {
			ModelAndView mv = new ModelAndView("customerlogin");
			mv.addObject("errmsg","Username or Password is invalid!!"); 
			return mv;			
		}
	}
	@RequestMapping("/feedback")
	public ModelAndView feedbackcust(){
		
			ModelAndView mv = new ModelAndView("customerfeedback");
			mv.addObject("msg","Thank you for your valuable feedback!!"); 
			return mv;			
		}
	@RequestMapping("/feedbackform")
	public ModelAndView feedbackformcust(){
		
			ModelAndView mv = new ModelAndView("customerfeedback");
			return mv;			
		}
	
	@RequestMapping("/register")
    public ModelAndView registerpage() {
        ModelAndView mv = new ModelAndView("customerregister");
        return mv;
        
    }
	
	@RequestMapping("/addcustomer")
	public ModelAndView registercustomer(
			@RequestParam("name") String name,
			@RequestParam("contact") String contact,
			@RequestParam("address") String address,
			@RequestParam("username") String username,
			@RequestParam("password") String pass
			) {
		
		Customer customer = new Customer();
		customer.setName(name);
		customer.setContactno(contact);
		customer.setAddress(address);
		customer.setUsername(username);
		customer.setPassword(pass);
		custservice.saveCustomer(customer);
		
		ModelAndView mv = new ModelAndView("registersuccess");
		return mv;
	}
	
}
