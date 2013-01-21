package pl.itcrowd.tutorials.hibernate.Company;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "COMPANY")
public class Company implements Serializable {

    public Company()
    {
    }

    public Company(String name)
    {
        this.name = name;
    }

    @SequenceGenerator(name = "COMPANY_ID_SEQUENCE", sequenceName = "COMPANY_ID_SEQUENCE", initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMPANY_ID_SEQUENCE")
    @Id
    private Long id;

    @Column(name = "NAME" , nullable =false)
    private String name;

    @OneToMany(mappedBy = "company")
    private List<Department> departments = new ArrayList<Department>();

    @Embedded
    private Address address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
