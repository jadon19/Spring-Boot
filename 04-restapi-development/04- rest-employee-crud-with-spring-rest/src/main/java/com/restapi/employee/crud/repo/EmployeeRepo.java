package com.restapi.employee.crud.repo;

import com.restapi.employee.crud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestResource(path="members")
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
}
