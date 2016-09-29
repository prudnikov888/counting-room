package pojos;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

/**
 * Created by anpr0915 on 28.09.2016.
 */
@Entity
public class Household implements Serializable {

    @Id
    @SequenceGenerator(name = "household_seq", sequenceName = "household_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "household_seq")
    private long householdId;

    @Column
    private String householdName;

    @OneToMany (mappedBy = "household")
    private List<User> users;

    @OneToMany (mappedBy = "household")
    private List<Account> accounts;

    public long getHouseholdId() {
        return householdId;
    }

    public void setHouseholdId(long householdId) {
        this.householdId = householdId;
    }

    public String getHouseholdName() {
        return householdName;
    }

    public void setHouseholdName(String householdName) {
        this.householdName = householdName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Household)) {
            return false;
        }
        Household household = (Household) obj;
        return (this.householdId == household.householdId);
    }

    @Override
    public int hashCode() {
        String s = householdId + "";
        return s.hashCode();
    }
}
