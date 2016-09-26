package pojos;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import static javax.persistence.GenerationType.SEQUENCE;

/**
 * Created by prudnikov on 21.06.2015.
 */
@Entity
@SequenceGenerator(name = "role_seq", sequenceName = "role_sequence", allocationSize = 1)
public class Role implements Serializable {

    @Id
    @GeneratedValue (strategy = SEQUENCE, generator = "role_seq")
    private long roleId;

    @Column
    private String roleName;

    @ManyToMany (mappedBy = "roles")
    private List<User> users;

    public Role(){

    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Role)) {
            return false;
        }
        Role role = (Role) obj;
        return (this.roleId == role.roleId);
    }

    @Override
    public int hashCode() {
        String s = roleId + "";
        return s.hashCode();
    }
}
