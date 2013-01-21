package pl.itcrowd.tutorials.hibernate;

import pl.itcrowd.tutorials.hibernate.Company.Address;
import pl.itcrowd.tutorials.hibernate.Company.Company;
import pl.itcrowd.tutorials.hibernate.Company.Department;
import pl.itcrowd.tutorials.hibernate.Company.Employee;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Startup
@Singleton
public class Starter {

    @PersistenceContext
    private EntityManager entityManager;

    @PostConstruct
    public void postConstruct()
    {
        final Company company = new Company();
        Department department1 = new Department();
        Department department2 = new Department();
        Address address = new Address();
        Employee employee1 = new Employee();
        Employee employee2 = new Employee();
        Employee employee3 = new Employee();

    }
}
