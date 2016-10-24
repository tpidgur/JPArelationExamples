package ua.rd.collectionmapping._1elementcollection;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

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

    @ElementCollection(targetClass = VacationEntry.class)
    @CollectionTable(name = "VACATION", joinColumns = @JoinColumn(name = "EMP_ID"))
    @AttributeOverride(name = "daysTaken", column = @Column(name = "DAYS_ABS"))
    private Collection vacationBookings;

    @ElementCollection
    @Column (name="NICKNAME")
    private Set<String> nickNames;

    public Employee() {
    }

    public Employee(String name, long salary, Set<String> nickNames) {
        this.name = name;
        this.salary = salary;
        this.nickNames = nickNames;
    }

    public void setVacationBookings(Collection vacationBookings) {
        this.vacationBookings = vacationBookings;
    }
}
