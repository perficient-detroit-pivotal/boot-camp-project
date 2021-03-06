/**
 * @author justin.grothe
 *
 */
package com.perficient.spring.web.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.perficient.spring.web.model.DropdownOption;
import com.perficient.spring.web.model.Employee;
import com.perficient.spring.web.service.EmployeeService;

@Controller
public class HomeController {
	
	@Autowired
	private EmployeeService service;
	
	@ModelAttribute("employeeType")
	public List<DropdownOption> populateWhichType() {
		List<DropdownOption> employeeType = new ArrayList<DropdownOption>();

		employeeType.add(new DropdownOption(1, "Part-time Intern"));
		employeeType.add(new DropdownOption(2, "Part-time Employee"));
		employeeType.add(new DropdownOption(3, "Full-time Intern"));
		employeeType.add(new DropdownOption(4, "Full-time Employee"));
		return employeeType;
		
	}
	
	@ModelAttribute("employeeDept")
	public List<DropdownOption> populateDept() {
		List<DropdownOption> employeeType = new ArrayList<DropdownOption>();

		employeeType.add(new DropdownOption(1, "Development"));
		employeeType.add(new DropdownOption(2, "Testing"));
		employeeType.add(new DropdownOption(3, "Automation"));

		return employeeType;
	}
	
	@ModelAttribute("userRole")
	public List<DropdownOption> populateRoles() {
		List<DropdownOption> employeeType = new ArrayList<DropdownOption>();

		employeeType.add(new DropdownOption(1, "Admin"));
		employeeType.add(new DropdownOption(2, "Manager"));
		employeeType.add(new DropdownOption(3, "Employee"));
		employeeType.add(new DropdownOption(4, "Deactivated"));

		return employeeType;
	}

	@RequestMapping(value = "/")
	public String showThymeleafPage() {
		return "redirect:/add";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String showAddEmployee(Model model) {
		model.addAttribute("employee", service.getSampleEmployee());
		return "employee-thymeleaf-add";
	}
	
	@RequestMapping(value = "/add", params = "add", method = RequestMethod.POST)
	public String showAddEmployeePost(Employee employee, RedirectAttributes re) {
		System.out.println("In the /add POST requestmapping");
		re.addAttribute("id", service.addEmployee(employee));
		return "redirect:/edit";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String showEditEmployee(@RequestParam("id") int id, Model model) {
		System.out.println("In /edit GET method, id: " + id);
		model.addAttribute("employee", service.findOne(id));
		return "employee-thymeleaf";
	}
	
	@RequestMapping(value = "/edit", params="save", method=RequestMethod.POST)
	public String saveEmployee(Employee employee, Model model) {
		System.out.println("SAVE EMPLOYEE");
		model.addAttribute("employee", service.saveEmployee(employee));
		return "employee-thymeleaf";
	}
	
	// Of course this is not how to actually deal with a password, but just doing this to get it working for now
	@RequestMapping(value = "/edit", params="change-password", method=RequestMethod.POST)
	public String changeEmployeePassword(@RequestParam("newpassword") String newpassword, Employee employee, RedirectAttributes re) {
		System.out.println("CHANGE EMPLOYEE PASSWORD");
		re.addAttribute("id", service.changePassword(employee.getPassword(), newpassword, employee.getEmployeeID()));
		System.out.println("out of changing password");
		return "redirect:/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/search", method = RequestMethod.POST, consumes = "text/plain")
	public ArrayList<String> findList(@RequestBody String searchBar) {
		System.out.println("in /search");

		return service.findAll(searchBar);
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		binder.registerCustomEditor(Date.class,
			new CustomDateEditor(dateFormat, false));
	}
	
}
