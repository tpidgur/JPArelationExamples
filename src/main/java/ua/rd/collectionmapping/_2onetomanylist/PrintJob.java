package ua.rd.collectionmapping._2onetomanylist;

import javax.persistence.*;

//@Entity
public class PrintJob {

    @TableGenerator(name = "PrintJob_Gen",
            table = "ID_GEN",
            pkColumnName = "Gen_name",
            valueColumnName = "Gen_val",
            initialValue = 0,
            allocationSize = 50)
    @Id
    @GeneratedValue(generator = "PrintJob_Gen")
    private Long id;
    @ManyToOne
    private PrintQueue queue;

    public PrintJob(PrintQueue queue) {
        this.queue = queue;
    }

    public PrintJob() {
    }



}
