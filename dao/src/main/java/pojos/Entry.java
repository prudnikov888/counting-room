package pojos;

import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import static javax.persistence.GenerationType.SEQUENCE;

/**
 * Created by prudnikov on 21.06.2015.
 */
@Entity
public class Entry implements Serializable {

    @Id
    @SequenceGenerator(name = "entry_seq", sequenceName = "entry_sequence", allocationSize = 1)
    @GeneratedValue (strategy = SEQUENCE, generator = "entry_seq")
    private long entryId;

    @Column
    private BigDecimal sum;

    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne
    @JoinColumn (name = "FK_userId")
    private User user;

    @ManyToOne
    @JoinColumn (name = "FK_accountId_debit")
    private Account debit;

    @ManyToOne
    @JoinColumn (name = "FK_accountId_credit")
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

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
