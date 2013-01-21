package pl.itcrowd.tutorials.hibernate.Company;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "DEPARTMENT")

public class Department implements Serializable {

    public Department()
    {

    }

    public Department(String city) {
        this.getAddress().setCity(city);
    }

    @Id
    @SequenceGenerator(name = "DEPARTMENT_ID_SEQUENCE", sequenceName = "DEPARTMENT_ID_SEQUENCE", initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DEPARTMENT_ID_SEQUENCE")
    private Long id;


    @Column(name = "NAME" , nullable =false)
    private String name;

    @Embedded
    private Address address;

    @ManyToOne
    @JoinColumn(name = "COMPANY_ID" , nullable =false)
    private Company company;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}