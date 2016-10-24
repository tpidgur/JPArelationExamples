package ua.rd.relations.embeddables;

import javax.persistence.*;

//@Entity
public class Employee {
    @TableGenerator(name = "Employee_Gen",
            table = "ID_GEN",
            pkColumnName = "Gen_name",
            valueColumnName = "Gen_val",
            initialValue = 0,
            allocationSize = 50)
    @Id
    @GeneratedValue(generator = "Employee_Gen")
    private Long id;
    private String name;
    private long salary;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="state", column=@Column(name="PROVINCE")),
            @AttributeOverride(name="zip", column=@Column(name="POSTAL_CODE"))
    })
    private Address address;


    public Employee() {
    }

    public Employee(String name, long salary, Address address) {
        this.name = name;
        this.salary = salary;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
