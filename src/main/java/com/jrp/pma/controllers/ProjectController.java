package com.jrp.pma.controllers;

import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.dao.ProjectRepository;
import com.jrp.pma.entities.Employee;
import com.jrp.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    ProjectRepository proRepo;

    @Autowired
    EmployeeRepository empRepo;


    @GetMapping
    public String displayEmployees(Model model) {
        Set<Project> projects = proRepo.findAll();
        model.addAttribute("projects", projects);
        return "projects/list-projects";
    }


    @GetMapping("/new")
    public String displayProjectForm(Model model) {
        Project aProject = new Project();
        Set <Employee> employees = empRepo.findAll();
        model.addAttribute("project", aProject);
        model.addAttribute("allEmployees", employees);
        return "projects/new-project";
    }

    @PostMapping("/save")
    public String createProject(Project project, @RequestParam Set<Long> employees, Model model) {
        proRepo.save(project);
        Iterable <Employee> chosenEmployees = empRepo.findAllById(employees);
        for(Employee emp : chosenEmployees) {
            emp.setProject(project);
            empRepo.save(emp);
        }
        // use a redirect to prevent duplicate submissions
        return "redirect:/projects/new";
    }


}
