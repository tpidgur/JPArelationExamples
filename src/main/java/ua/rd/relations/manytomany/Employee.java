package ua.rd.relations.manytomany;

import javax.persistence.*;
import java.util.Collection;

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
    @ManyToMany
    @JoinTable(name="EMP_PROJ", joinColumns = @JoinColumn(name = "EMP_ID"),
    inverseJoinColumns = @JoinColumn(name="PROJ_ID"))
    private Collection<Project> projects;
    private long salary;
    private String name;


    public Employee(long salary, String name) {
        this.projects = projects;
        this.salary = salary;
        this.name = name;
    }

    public Employee() {
    }

    public void setProjects(Collection<Project> projects) {
        this.projects = projects;
    }
}
