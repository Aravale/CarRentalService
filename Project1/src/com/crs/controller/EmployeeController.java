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
import com.crs.model.Employee;
import com.crs.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController{

	@Autowired
	private EmployeeService empservice;	
	
	@RequestMapping("/main")
	public ModelAndView landing() {
		
		ModelAndView mv = new ModelAndView("employeelogin");
		return mv;
		
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession(false);
		session.invalidate();
		ModelAndView mv = new ModelAndView("employeelogin");
		return mv;	
	}
	
	@RequestMapping("/employeehome")
	public ModelAndView employeehome() {		
		ModelAndView mv = new ModelAndView("employeehome");
		return mv;	
	}
	
	
	@RequestMapping("/UpdateLanding")
	public ModelAndView updatelanding(
			@RequestParam("id") String id) {
		
		Employee result = empservice.getEmployeebyID(Integer.parseInt(id));		
		ModelAndView mv = new ModelAndView("employeeupdate");
		mv.addObject("employee",result);
		return mv;		
	}
	
	@RequestMapping("/employeepanel")
	public ModelAndView employeepanel() {		
		ModelAndView mv = new ModelAndView("employeepanel");
		return mv;	
	}
	
	@RequestMapping("/UpdateEmployee")
	public ModelAndView updateemployee(
			@RequestParam("id") String id ,
			@RequestParam("name") String name,
			@RequestParam("contact") String contact,
			@RequestParam("address") String address,
			@RequestParam("username") String username,
			@RequestParam("password") String password) {
		Employee employee = new Employee();
		employee.setId(Integer.parseInt(id));
		employee.setName(name);
		employee.setContact(contact);
		employee.setAddress(address);
		employee.setUsername(username);
		employee.setPassword(password);
		empservice.updateEmployee(employee);
		ModelAndView mv = new ModelAndView("employeepanel");
		mv.addObject("employee",employee);
		return mv;		
	}
		
	@RequestMapping("/login")
	public ModelAndView loginemployee(
			@RequestParam("uname") String username,
			@RequestParam("pass") String pass,
			HttpServletRequest request
			) {
		Employee result = empservice.loginEmployee(username, pass);
		if(result != null) {
			HttpSession session = request.getSession();
			 session.setAttribute("employeeid", result.getId());
			 request.setAttribute("employeeid", result.getId());
		if(result.getAuthlevel() == 1) {
			ModelAndView mv = new ModelAndView("employeehome");	
			return mv;

		}
		else {
			ModelAndView mv = new ModelAndView("employeehome");
			mv.addObject("employee", result);
			return mv;	
		}}
		else {
			ModelAndView mv = new ModelAndView("employeelogin");
			mv.addObject("errmsg","Username or Password is invalid!!"); 
			return mv;			
		}
	}
	
	@RequestMapping("/register")
	public ModelAndView registeremployee(
			@RequestParam("name") String name,
			@RequestParam("contact") String contact,
			@RequestParam("address") String address,
			@RequestParam("username") String username,
			@RequestParam("password") String pass
			) {		
		Employee employee = new Employee();
		employee.setName(name);
		employee.setContact(contact);
		employee.setAddress(address);
		employee.setUsername(username);
		employee.setPassword(pass);
		empservice.saveEmployee(employee);
		
		ModelAndView mv = new ModelAndView("registersuccess");
		return mv;
	}
		
}
