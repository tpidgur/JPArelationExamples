package ua.rd.relations.manytomany;



import javax.persistence.*;
import java.util.Collection;

//@Entity
public class Project {
    @TableGenerator(name = "Project_Gen",
            table = "ID_GEN",
            pkColumnName = "Gen_name",
            valueColumnName = "Gen_val",
            initialValue = 0,
            allocationSize = 50)
    @Id
    @GeneratedValue(generator = "Project_Gen")
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "projects")
    private Collection<Employee> employees;

    public Project(String name) {
        this.name = name;
    }

    public Project() {
    }

    public void setEmployees(Collection<Employee> employees) {
        this.employees = employees;
    }
}
