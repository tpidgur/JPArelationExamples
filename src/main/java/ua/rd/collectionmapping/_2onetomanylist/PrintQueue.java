package ua.rd.collectionmapping._2onetomanylist;

import javax.persistence.*;
import java.util.List;

//@Entity
public class PrintQueue {

    @TableGenerator(name = "PrintQueue_Gen",
            table = "ID_GEN",
            pkColumnName = "Gen_name",
            valueColumnName = "Gen_val",
            initialValue = 0,
            allocationSize = 50)
    @Id
    @GeneratedValue(generator = "PrintQueue_Gen")
    private Long id;

    @OneToMany(mappedBy = "queue")
   @OrderColumn(name = "PRINT_ORDER")
   // @OrderBy("id ASC")
    private List<PrintJob> jobs;

    public PrintQueue() {
    }

    public void setJobs(List<PrintJob> jobs) {
        this.jobs = jobs;
    }
}
