package pojos;

import java.io.Serializable;
import java.util.List;

/**
 * Created by prudnikov on 21.06.2015.
 */
public class Role implements Serializable {
    private long roleId;
    private String roleName;
    private List<User> users;

    public Role(){

    }
    public Role (String roleName, List<User> users) {
        this.roleName = roleName;
        this.users = users;
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
        if (obj instanceof Role) {
            Role temp = (Role) obj;
            if (roleId == temp.roleId
                    && roleName.equals(temp.roleName)
                    && users.equals(temp.users)
                    )
                return true;
            else
                return false;
        } else
            return false;
    }

    @Override
    public int hashCode() {
        String s = roleId + "";
        return s.hashCode();
    }
}
