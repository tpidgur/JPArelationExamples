package ua.rd.relations.bidironetomany;

import javax.persistence.*;
import java.util.Collection;

//@Entity
public class Department {
    @TableGenerator(name = "Department_Gen",
            table = "ID_GEN",
            pkColumnName = "Gen_name",
            valueColumnName = "Gen_val",
            initialValue = 0,
            allocationSize = 50)
    @Id
    @GeneratedValue(generator = "Department_Gen")
    private Long id;
    private String name;
    @OneToMany(mappedBy = "department")
    private Collection<Employee> employees;

    public Department(String name) {
        this.name = name;
    }

    public Department() {
    }

    public void setEmployees(Collection<Employee> employees) {
        this.employees = employees;
    }
}
