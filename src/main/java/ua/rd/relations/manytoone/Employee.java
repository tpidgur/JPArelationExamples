package ua.rd.relations.manytoone;

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
    @ManyToOne
    @JoinColumn(name="DEPT_ID")
    private Department department;
    private long salary;
    private String name;

    public Employee(Department department, long salary, String name) {
        this.department = department;
        this.salary = salary;
        this.name = name;
    }

    public Employee() {
    }
}
