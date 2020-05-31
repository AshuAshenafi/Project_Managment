//package com.jrp.pma;
//
//import com.jrp.pma.dao.EmployeeRepository;
//import com.jrp.pma.dao.ProjectRepository;
//import com.jrp.pma.entities.Employee;
//import com.jrp.pma.entities.Project;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.HashSet;
//import java.util.Set;
//
////@Component
//public class DataLoader implements CommandLineRunner {
//
//    @Autowired
//    EmployeeRepository employeeRepository;
//
//    @Autowired
//    ProjectRepository projectRepository;
//
//    @Override
//    public void run(String... strings) throws Exception {
//        Employee emp1 = new Employee("John", "Warton", "warton@gmail.com");
//        Employee emp2 = new Employee("Mike", "Lanister", "lanister@gmail.com");
//        Employee emp3 = new Employee("Steve", "Reeves", "Reeves@gmail.com");
//
//        Employee emp4 = new Employee("Ronald", "Connor", "connor@gmail.com");
//        Employee emp5 = new Employee("Jim", "Salvator", "sal@yahoo.com");
//        Employee emp6 = new Employee("Tony", "Roggers", "roggers@gmail.com");
//
//        Project pro1 = new Project("Large Production Deploy", "NOTSTARTED", "This requires all hands on");
//        Project pro2 = new Project("Large Production Deploy", "NOTSTARTED", "This requires all hands on");
//        Project pro3 = new Project("Large Production Deploy", "NOTSTARTED", "This requires all hands on");
//
//        Set<Employee> employees1 = new HashSet<Employee>();
//        employees1.add(emp1);
//        employees1.add(emp2);
//        employees1.add(emp3);
//
//        Set<Employee> employees2 = new HashSet<Employee>();
//        employees2.add(emp4);
//        employees2.add(emp5);
//        employees2.add(emp6);
//
//        pro1.setEmployees(employees1);
//        pro2.setEmployees(employees2);
//        projectRepository.save(pro1);
//        projectRepository.save(pro2);
//
//        emp1.setProjects(pro1);
//        emp2.setProjects(pro1);
//        emp3.setProjects(pro1);
//
//        employeeRepository.save(emp1);
//        employeeRepository.save(emp2);
//        employeeRepository.save(emp3);
//
//        emp4.setProject(pro2);
//        emp5.setProject(pro2);
//        emp6.setProject(pro2);
//
//        employeeRepository.save(emp4);
//        employeeRepository.save(emp5);
//        employeeRepository.save(emp6);
//    }
//}
