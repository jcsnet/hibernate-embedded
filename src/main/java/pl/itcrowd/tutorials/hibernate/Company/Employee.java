package pl.itcrowd.tutorials.hibernate.Company;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="EMPLOYEE")
public class Employee implements Serializable {

    public Employee()
    {}

    public Employee(String name) {
        this.name = name;
    }

    @Id
    @SequenceGenerator(name = "EMPLOYEE_ID_SEQUENCE", sequenceName = "EMPLOYEE_ID_SEQUENCE", initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMPLOYEE_ID_SEQUENCE")
    private Long id;

    @Embedded
    private Address address;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="city", column=@Column(name = "CITY_FORM_CORREPONDENCE")),
            @AttributeOverride(name="street", column=@Column(name = "STREET_FORM_CORREPONDENCE")),
            @AttributeOverride(name="zipcode", column=@Column(name = "ZIPCODE_FORM_CORREPONDENCE"))
    })

    private Address addressCorespondence;

    @ManyToOne(optional = true)  //opcjonalnie, ewentualnie
    @JoinColumn(name = "BOSS_ID")
    private Employee boss;


    @ManyToOne
    @JoinColumn(name =  "DEPARTAMENT_ID")
    private Department department;

    @Column(name = "NAME")
    private String name;


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

    public Employee getBoss() {
        return boss;
    }

    public void setBoss(Employee boss) {
        this.boss = boss;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
