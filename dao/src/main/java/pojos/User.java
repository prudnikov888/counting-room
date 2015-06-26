package pojos;

import java.io.Serializable;
import java.util.List;

/**
 * Created by prudnikov on 21.06.2015.
 */
public class User implements Serializable {
    private long userId;
    private String userName;
    private String email;
    private String password;
    private List<Role> roles;

    public User() {
    }

    public User(String userName, String email, String password, List<Role> roles) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.roles = roles;
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
        if (obj instanceof User) {
            User temp = (User) obj;
            if (userId == temp.userId
                    && userName.equals(temp.userName)
                    && email.equals(temp.email)
                    && password.equals(temp.password)
                    && roles.equals(temp.roles)
                    )
                return true;
            else
                return false;
        } else
            return false;
    }

    @Override
    public int hashCode() {
        String s = userId + "";
        return s.hashCode();
    }
}
