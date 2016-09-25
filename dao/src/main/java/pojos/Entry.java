package pojos;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Created by prudnikov on 21.06.2015.
 */
@Entity
public class Entry implements Serializable {

    @Id
    @GeneratedValue
    private long entryId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column
    private double sum;

    @Column
    private String currency;

    @OneToOne
    private Account debit;

    @OneToOne
    private Account credit;

    public Entry(){

    }

    public long getEntryId() {
        return entryId;
    }

    public void setEntryId(long entryId) {
        this.entryId = entryId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Account getDebit() {
        return debit;
    }

    public void setDebit(Account debit) {
        this.debit = debit;
    }

    public Account getCredit() {
        return credit;
    }

    public void setCredit(Account credit) {
        this.credit = credit;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        return (this.entryId == entry.entryId);
    }

    @Override
    public int hashCode() {

        String s = entryId + "";
        return s.hashCode();
    }
}
