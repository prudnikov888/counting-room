package pojos;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

import static javax.persistence.GenerationType.SEQUENCE;


/**
 * Created by prudnikov on 21.06.2015.
 */
@Entity
public class Account implements Serializable {

    @Id
    @SequenceGenerator(name = "account_seq", sequenceName = "account_sequence", allocationSize = 1)
    @GeneratedValue (strategy = SEQUENCE, generator = "account_seq")
    private BigInteger accountId;

    @Column
    private String accountName;

    @Column
    private BigDecimal balance;

    @ManyToOne (cascade = CascadeType.REFRESH)
    @JoinColumn
    private Currency currency;

    @ManyToOne (cascade = CascadeType.REFRESH)
    @JoinColumn
    private User user;

    @ManyToOne (cascade = CascadeType.REFRESH)
    @JoinColumn
    private Category category;

    public Account(){

    }

    public BigInteger getAccountId() {
        return accountId;
    }

    public void setAccountId(BigInteger accountId) {
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
        return Objects.equals(this.accountId, account.accountId);
    }

    @Override
    public int hashCode() {
        String s = accountId + "";
        return s.hashCode();
    }
}
