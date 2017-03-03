package pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;

import java.util.List;
import java.util.Objects;

import static javax.persistence.GenerationType.SEQUENCE;

/**
 * Created by prudnikov on 21.06.2015.
 */
@Entity
public class User implements Serializable {

    @Id
    @SequenceGenerator(name = "user_seq", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue (strategy = SEQUENCE, generator = "user_seq")
    private long userId;

    @Column
    private String userName;

    @Column
    private String email;

    @Column
    private String password;

    @JsonIgnore
    @OneToMany (mappedBy = "user", fetch = FetchType.EAGER)
    private List<Entry> entries;

    @JsonIgnore
    @ManyToOne
    @JoinColumn (name = "FK_household_id")
    private Household household;

    public User() {
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @JsonIgnore
    public List<Entry> getEntries() {
        return entries;
    }

    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }

    @JsonIgnore
    public Household getHousehold() {
        return household;
    }

    public void setHousehold(Household household) {
        this.household = household;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof User)) {
            return false;
        }
        User user = (User) obj;
        return (this.userId == user.userId);
    }

    @Override
    public int hashCode() {
        String s = userId + "";
        return s.hashCode();
    }
}
