package ua.rd.relations.embeddables;

import javax.persistence.*;

//@Entity
public class Company {
    @TableGenerator(name = "Company_Gen",
            table = "ID_GEN",
            pkColumnName = "Gen_name",
            valueColumnName = "Gen_val",
            initialValue = 0,
            allocationSize = 50)
    @Id
    @GeneratedValue(generator = "Company_Gen")
    private Long id;
    @Embedded
    private Address address;



    public Company() {
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
