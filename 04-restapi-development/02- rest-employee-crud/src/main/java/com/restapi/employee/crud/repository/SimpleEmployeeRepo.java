package com.restapi.employee.crud.repository;
import java.util.List;
import com.restapi.employee.crud.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SimpleEmployeeRepo implements EmployeeRepository{
    private EntityManager em;
    TypedQuery<Employee> query;
    @Autowired
    SimpleEmployeeRepo(EntityManager em){
        this.em=em;
    }
    @Override
    public List<Employee> findAll(){
        query = em.createQuery("FROM Employee", Employee.class);
        return query.getResultList();
    }
    @Override
    public Employee find(Integer id){
        return em.find(Employee.class,id);
    }

    @Override
    public Employee save(Employee emp) {
       return em.merge(emp);
    }

    @Override
    public void deleteById(Integer i) {
        Employee emp = em.find(Employee.class,i);
        em.remove(emp);
    }

}
