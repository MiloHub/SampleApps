package com.spring.restful.controller;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.restful.TestREST.Employee;
import com.spring.restful.TestREST.EmployeeList;

@Controller
@XmlRootElement
public class EmployeeController {
	@RequestMapping(method=RequestMethod.GET,value="/employee/{id}")
	public ModelAndView getEmployee(@PathVariable String id,@RequestParam String foo) throws UnknownHostException, IOException{
		
		System.out.println("fooo--"+foo);
		Employee e = new Employee();
		e.setEmail("dvijayan@test.com");
		e.setName("dvijayan");
		e.setId(1);
		System.out.println("Sasas");
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(e);
		
		String a = null;
		EmployeeList employList = new  EmployeeList(employees);
		return new ModelAndView("employees", "employees", employList);
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/employees")
	public ModelAndView getEmployees() {
		List<Employee> employees = new EmployeeDS().getAll();
		EmployeeList list = new EmployeeList(employees);
		return new ModelAndView("employees", "employees", list);
	}
	@RequestMapping(method=RequestMethod.POST ,value="/translateToJson" )
	//@ModelAttribute("json")
	public ModelMap  test(@RequestBody String account ,ModelMap model) {
		Map<String,String> json = new HashMap<String, String>();
		json.put("1", "value1");
		json.put("2", "value2");
		json.put("3", "value3");
		
	
		
	//	jsonObj.put("json", json);
		
		model.addAttribute("json", json);
		return model;
	}

}
