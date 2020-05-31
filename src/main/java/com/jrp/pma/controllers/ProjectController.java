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
    public String displayProjects(Model model) {
        List<Project> projects = proRepo.findAll();
        model.addAttribute("projects", projects);
        return "projects/list-projects";
    }

    @GetMapping("/new")
    public String displayProjectForm(Model model) {
        Project aProject = new Project();
        List <Employee> employees = empRepo.findAll();
        model.addAttribute("project", aProject);
        model.addAttribute("allEmployees", employees);
        return "projects/new-project";
    }

    @PostMapping("/save")
//        ////////////////////start//////////////OneToMany - DB Relationship///////////////Lecture 20- time 25:00/29:08
//    public String createProject(Project project, @RequestParam List<Long> employees, Model model) {
//        ////////////////////end//////////////OneToMany - DB Relationship///////////////////////

//        ////////////////////start//////////////ManyToMany - DB Relationship///////////////Lecture 22
    public String createProject(Project project, Model model) {
//        ////////////////////end//////////////ManyToMany - DB Relationship///////////////Lecture 22

        proRepo.save(project);
//        ////////////////////start//////////////OneToMany - DB Relationship///////////////Lecture 20- time 25:00/29:08
//        Iterable <Employee> chosenEmployees = empRepo.findAllById(employees);   //lecture 22 time 22:00/29:08
//        for(Employee emp : chosenEmployees) {
//            emp.setProject(project);    // lecture 21 @ManyToMany 13:40/19:15
//            empRepo.save(emp);
//        }
//        ////////////////////end//////////////OneToMany - DB Relationship///////////////////////

        // use a redirect to prevent duplicate submissions
//        return "redirect:/projects/new";


//        ////////////////////start//////////////ManyToMany - DB Relationship///////////////Lecture 22
        return "redirect:/projects";
//        ////////////////////end//////////////ManyToMany - DB Relationship////////////////////////Lecture 22
    }


}
