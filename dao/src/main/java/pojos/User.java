package pojos;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Created by prudnikov on 21.06.2015.
 */
@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue
    private long userId;

    @Column
    private String userName;

    @Column
    private String email;

    @Column
    private String password;

    @ManyToMany (cascade = {CascadeType.ALL})
    private List<Role> roles;

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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
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
