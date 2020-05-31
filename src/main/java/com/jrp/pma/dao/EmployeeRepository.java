package com.jrp.pma.dao;

import com.jrp.pma.entities.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface EmployeeRepository extends CrudRepository <Employee, Long> {
    @Override
    public List<Employee> findAll();

    public Employee findByEmployeeId(long theId);
}
