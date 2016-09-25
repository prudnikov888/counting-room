package pojos;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Created by prudnikov on 21.06.2015.
 */
@Entity
public class Account implements Serializable {

    @Id
    @GeneratedValue
    private long accountId;

    @Column
    private String accountName;

    @Column
    private double balance;

    @Column
    private String currency;

    @ManyToMany (cascade = {CascadeType.ALL})
    private List<Category> categories;

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

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
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
