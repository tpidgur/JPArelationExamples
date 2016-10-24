package ua.rd.relations.onetoone;

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
    @OneToOne
    @JoinColumn(name = "PSPACE_ID")
    private ParkingSpace parkingSpace;
    private long salary;
    private String name;

    public Employee(ParkingSpace parkingSpace, long salary, String name) {
        this.parkingSpace = parkingSpace;
        this.salary = salary;
        this.name = name;
    }

    public Employee() {
    }
}
