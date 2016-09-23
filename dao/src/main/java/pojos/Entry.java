package pojos;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by prudnikov on 21.06.2015.
 */
@Entity
public class Entry implements Serializable {

    @Id
    @GeneratedValue
    private long entryId;

    @Column(name = "'timestamp'")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Basic
    private double sum;

    @Basic
    private String currency;


    private Account debit;

    private Account credit;

    public Entry(){

    }

    public Entry(Date date, double sum, String currency,Account debit, Account credit) {
        this.date = date;
        this.sum = sum;
        this.currency = currency;
        this.debit = debit;
        this.credit = credit;

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
        if (obj instanceof Entry) {
            Entry temp = (Entry) obj;
            if (entryId == temp.entryId
                    && date.equals(temp.date)
                    && sum == temp.sum
                    && currency.equals(temp.currency)
                    && debit.equals(temp.debit)
                    && credit.equals(temp.credit)
                    )
                return true;
            else
                return false;
        } else
            return false;
    }

    @Override
    public int hashCode() {
        String s = entryId + "";
        return s.hashCode();
    }
}
