package com.jrp.pma.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Project {
            // using @GeneratedValue(strategy = GenerationType.IDENTITY) might kill our performance if we are using batching.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)                    // if you are using sql the id shall be taken care specially when we have to load data as acomponent or starting data and do the same on project entity
    private long projectId;

    private String name;

    private String stage;   // NOT STARTED, COMPLETED, INPROGRESS

    private String description;

    //  start OneToMany Relationships db
//    @OneToMany(mappedBy = "project")
    //  end of OneToMany Relationships db

    //  //////////////////////start ManyToMany Relationships db///////////////////

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH,
            CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinTable(name="project_employee",
            joinColumns = @JoinColumn(name="project_id"),
            inverseJoinColumns = @JoinColumn(name="employee_id"))

    //  //////////////////////end ManyToMany Relationships db///////////////////

    private List<Employee> employees;

    public Project() {
    }

    public Project(String name, String stage, String description) {
        super();
        this.name = name;
        this.stage = stage;
        this.description = description;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    // convenience method:
    public void addEmployee(Employee emp) {
        if(employees == null) {
            ArrayList<Employee> employees = new ArrayList<>();
        }
        employees.add(emp);
    }
}
