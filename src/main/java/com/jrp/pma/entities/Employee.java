package com.jrp.pma.entities;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)             // if you are using sql the id shall be taken care specially when we have to load data as acomponent or starting data and do the same on project entity
    private long employeeId;

    @NotBlank(message="Must give first name!")
    @Size(min=2, max=50)
    private String firstName;

    @NotBlank(message="Must give last name!")
    @Size(min=1, max=50)
    private String lastName;

    @NotBlank(message="Must give email!")
    @Email
    private String email;
    //  /////////start ////////The code below is for OneToMany relationship
//    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},
//                    fetch = FetchType.LAZY)
//    @JoinColumn(name="project_id")
//    private Project project;
    //  /////////end of ////////The code below is for OneToMany relationship


    //  /////////start ////////The code below is for many to many relationship

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinTable(name="project_employee",
            joinColumns = @JoinColumn(name="employee_id"),
            inverseJoinColumns = @JoinColumn(name="project_id"))
    private List<Project> projects;

    //  /////////end of ////////The code below is for many to many relationship

    public Employee() {
    }

    public Employee(String firstName, String lastName, String email) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    //  /////////start of ////////The code below is for OneToMany relationship
//    public Project getProject() {
//        return project;
//    }
//
//    public void setProject(Project project) {
//        this.project = project;
//    }
    //  /////////end of ////////The code below is for OneToMany relationship




    //  /////////end of ////////The code below is for ManyToMany relationship

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    //  /////////start ////////The code below is for ManyToMany relationship

}
