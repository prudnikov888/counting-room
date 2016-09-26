package pojos;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;
import java.math.BigDecimal;

import static javax.persistence.GenerationType.SEQUENCE;


/**
 * Created by prudnikov on 21.06.2015.
 */
@Entity
@SequenceGenerator(name = "account_seq", sequenceName = "account_sequence", allocationSize = 1)
public class Account implements Serializable {

    @Id
    @GeneratedValue (strategy = SEQUENCE, generator = "account_seq")
    private long accountId;

    @Column
    private String accountName;

    @Column
    private BigDecimal balance;

    @ManyToOne
    private Currency currency;

    @OneToOne
    private User user;

    @Cascade({CascadeType.SAVE_UPDATE})
    @ManyToOne
    private Category category;

    public Account(){

    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals (Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Account)) {
            return false;
        }
        Account account = (Account) obj;
        return (this.accountId == account.accountId);
    }

    @Override
    public int hashCode() {
        String s = accountId + "";
        return s.hashCode();
    }
}
