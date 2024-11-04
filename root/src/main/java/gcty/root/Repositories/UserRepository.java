package gcty.root.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gcty.root.Entities.User;
import gcty.root.Entities.UserRole;

import java.util.List;





    @Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);

    User findByFirstNameAndLastName(String firstName, String lastName);
    
    User findByEmail(String email);

    User findByPhone(String phone);

    List<User> findByUserRole(UserRole userRole);
}

