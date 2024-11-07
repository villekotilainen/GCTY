package gcty.root.Services;



import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import gcty.root.Entities.User;
import gcty.root.Repositories.UserRepository;

@Service
public class UserDetailService implements UserDetailsService{

    private final UserRepository userRepository;

    public UserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        User currentUser = userRepository.findByUserName(userName);
        UserDetails user = new org.springframework.security.core.userdetails.User(userName, currentUser.getPasswordHash(),
            AuthorityUtils.createAuthorityList(currentUser.getUserRoleName().toString()));
        return user;
    }
    
}
