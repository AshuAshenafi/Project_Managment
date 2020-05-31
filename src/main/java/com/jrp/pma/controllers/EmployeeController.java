package com.jrp.pma.controllers;

import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.entities.Employee;
import com.jrp.pma.entities.Project;
import com.jrp.pma.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeRepository empRep;

    @Autowired
    EmployeeService empService;

    @GetMapping
    public String displayEmployees(Model model) {
        List<Employee> employees = empRep.findAll();
        model.addAttribute("employees", employees);
        return "employees/list-employees";
    }

    @GetMapping("/new")
    public String displayEmployeeForm(Model model) {
        Employee anEmployee = new Employee();
        model.addAttribute("employee", anEmployee);
        return "employees/new-employee";
    }
    @PostMapping("/save")
    public String createProject(Model model, @Valid Employee employee, Errors errors) {
        if(errors.hasErrors()){
            return "employees/new-employee";
        }
        empRep.save(employee);
        // use a redirect to prevent duplicate submissions
        return "redirect:/employees/new";
    }

    @GetMapping("/update")
    public String displayEmployeeUpdateForm(@RequestParam("id") long theId, Model model) {
        Employee theEmp = empService.findByEmployeeId(theId);
        model.addAttribute("employee", theEmp);
        return "employees/new-employee";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("id") long theId, Model model) {
        Employee theEmp = empService.findByEmployeeId(theId);
        empService.delete(theEmp);
        return "redirect:/employees";
    }
}
