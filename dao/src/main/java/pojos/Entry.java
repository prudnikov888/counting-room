package pojos;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.Objects;

import static javax.persistence.GenerationType.SEQUENCE;

/**
 * Created by prudnikov on 21.06.2015.
 */
@Entity
public class Entry implements Serializable {

    @Id
    @SequenceGenerator(name = "entry_seq", sequenceName = "entry_sequence", allocationSize = 1)
    @GeneratedValue (strategy = SEQUENCE, generator = "entry_seq")
    private BigInteger entryId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column
    private BigDecimal sum;

    @ManyToOne
    private Currency currency;

    @Cascade({CascadeType.SAVE_UPDATE})
    @OneToOne
    private Account debit;

    @Cascade({CascadeType.SAVE_UPDATE})
    @OneToOne
    private Account credit;

    @OneToOne
    private User user;

    public Entry(){

    }

    public BigInteger getEntryId() {
        return entryId;
    }

    public void setEntryId(BigInteger entryId) {
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

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
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
        return Objects.equals(this.entryId, entry.entryId);
    }

    @Override
    public int hashCode() {
        String s = entryId + "";
        return s.hashCode();
    }
}
