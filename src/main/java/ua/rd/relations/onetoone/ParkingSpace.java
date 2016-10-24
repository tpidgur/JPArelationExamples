package ua.rd.relations.onetoone;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

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

    public ParkingSpace() {
    }
}
