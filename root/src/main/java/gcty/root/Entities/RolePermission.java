package gcty.root.Entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class RolePermission {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long permissionId;
    private String permissionDescription;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userRoleName")
    private List<UserRole> userRoles;

    public RolePermission(Long permissionId, String permissionDescription) {
        this.permissionId = permissionId;
        this.permissionDescription = permissionDescription;
    }

    public RolePermission() {

    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionDescription() {
        return permissionDescription;
    }

    public void setPermissionDescription(String permissionDescription) {
        this.permissionDescription = permissionDescription;
    }

    public List<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    @Override
    public String toString() {
        return "RolePermission [permissionId=" + permissionId + ", permissionDescription=" + permissionDescription
                + "]";
    }

    


}
