package com.jrp.pma.services;

import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository empRepo;

    public Employee findByEmployeeId(long theId) {
        return empRepo.findByEmployeeId(theId);
    }

    public void delete(Employee theEmp) {
        empRepo.delete(theEmp);
    }
}
