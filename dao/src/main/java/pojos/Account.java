package pojos;

import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;
import java.math.BigDecimal;


import static javax.persistence.GenerationType.SEQUENCE;


/**
 * Created by prudnikov on 21.06.2015.
 */
@Entity
public class Account implements Serializable {

    @Id
    @SequenceGenerator(name = "account_seq", sequenceName = "account_sequence", allocationSize = 1)
    @GeneratedValue (strategy = SEQUENCE, generator = "account_seq")
    private long accountId;

    @Column
    private String accountName;

    @Column
    private BigDecimal balance;

    @ManyToOne
    @JoinColumn (name = "FK_household_id")
    private Household household;

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

    public Household getHousehold() {
        return household;
    }

    public void setHousehold(Household household) {
        this.household = household;
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
