package gcty.root.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity(name="users")
@Table(name="\"users\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @NotBlank
    @Size(min = 4, max = 50)
    private String userName;

    @NotBlank
    @Size(min = 2, max = 50)
    private String firstName;

    @NotBlank
    @Size(min = 2, max = 50)
    private String lastName;

    @NotBlank
    @Size(min = 6)
    private String passwordHash;

    @NotBlank
    @Email(message = "Invalid email")
    private String email;

    private String phone;

    @ManyToOne
    @JoinColumn(name = "userRoleId") // many-to-one relationship with UserRole
    private UserRole userRoleName;

    public User(Long userId, String userName, String firstName, String lastName, String passwordHash, String email, String phone, UserRole userRoleName) {
        this.userId = userId;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.passwordHash = passwordHash;
        this.email = email;
        this.phone = phone;
        this.userRoleName = userRoleName;
    }
    
    // käyttäjä ilman roolia testailuu varten :)

    public User(Long userId, String userName, String firstName, String lastName, String passwordHash, String email, String phone) {
        this.userId = userId;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.passwordHash = passwordHash;
        this.email = email;
        this.phone = phone;
    }

    public User() {
    }
    
    // getterit

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public UserRole getUserRoleName() {
        return userRoleName;
    }


    //setterit
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUserRole(UserRole userRoleName) {
        this.userRoleName = userRoleName;
    }

    @Override
    public String toString() {
        return "User [userId=" + userId +  ", firstName=" + firstName + ", lastName=" + lastName
                + ", password=" + passwordHash + ", email=" + email + ", phone=" + phone + ", userrole="
                + userRoleName + "]";
    } 
}




