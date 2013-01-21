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
import java.util.ArrayList;
import java.util.List;

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

//       Setup address properties
        address.setCity("Tarnow");
        address.setStreet("Krakowska");
        address.setZipcode("123");

//       Setup departments properties
        department1.setName("Departament nr 1");
        department1.setCompany(company);
        department1.setAddress(address);

        department2.setName("Departament nr 2");
        department2.setCompany(company);
        department2.setAddress(address);

//       Creating departments list
        List<Department> departments = new ArrayList<Department>();
        departments.add(department1);
        departments.add(department2);

//       Setup company properties
        company.setName("Firma");
        company.setDepartments(departments);
        company.setAddress(address);


    }
}
