package ua.rd.relations.manytoone;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

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

    public Department(String name) {
        this.name = name;
    }

    public Department() {
    }
}
