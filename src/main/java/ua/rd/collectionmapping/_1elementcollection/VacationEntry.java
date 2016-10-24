package ua.rd.collectionmapping._1elementcollection;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Calendar;

@Embeddable
public class VacationEntry {
    @Temporal(TemporalType.DATE)
    private Calendar startDate;

    @Column(name="DAYS")
    private int daysTaken;

    public VacationEntry(Calendar startDate, int daysTaken) {
        this.startDate = startDate;
        this.daysTaken = daysTaken;
    }

    public VacationEntry() {
    }
}
