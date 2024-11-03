package gcty.root.Entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userRoleId;
    private String userRoleName;
    
    @ManyToOne
    @JoinColumn(name = "permissionId")
    private RolePermission userRolePermission;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userRole")
    private List<User> users;

    public UserRole(Long userRoleId, String userRoleName) {
        this.userRoleId = userRoleId;
        this.userRoleName = userRoleName;
    }

    public Long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getUserRoleName() {
        return userRoleName;
    }

    public void setUserRoleName(String userRoleName) {
        this.userRoleName = userRoleName;
    }

    public void setUserRolePermission(RolePermission userRolePermission) {
        this.userRolePermission = userRolePermission;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UserRole [userRoleId=" + userRoleId + ", userRoleName=" + userRoleName + "]";
    }
    
}
