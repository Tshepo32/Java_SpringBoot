package za.ac.cput.service;

import za.ac.cput.domain.Employee;

import java.util.List;
import java.util.Set;

public interface IEmployeeService extends IService<Employee, Long> {
   // Employee read(long id);

    List<Employee> getall();
}
