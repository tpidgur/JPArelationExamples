package ua.rd.relations.bidironetoone;

import javax.persistence.*;

//@Entity
public class ParkingSpace {
    @TableGenerator(name = "Parking_Gen",
            table = "ID_GEN",
            pkColumnName = "Gen_name",
            valueColumnName = "Gen_val",
            initialValue = 0,
            allocationSize = 50)
    @Id
    @GeneratedValue(generator = "Parking_Gen")
    private Long id;
    private int lot;
    private String location;
    @OneToOne(mappedBy = "parkingSpace")
    private Employee employee;

    public ParkingSpace(int lot, String location, Employee employee) {
        this.lot = lot;
        this.location = location;
        this.employee = employee;
    }

    public ParkingSpace() {
    }
}
