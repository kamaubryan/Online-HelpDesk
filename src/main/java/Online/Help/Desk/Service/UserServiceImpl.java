package Online.Help.Desk.Service;

import Online.Help.Desk.Model.Role;
import Online.Help.Desk.Model.User;
import Online.Help.Desk.Repository.RoleRepository;
import Online.Help.Desk.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public boolean findRoleByUser(String role, User user) {
        return user.getRoles().contains(roleRepository.findByRole(role));
    }

    @Override
    public boolean isAdmin(User user) {
        return user.getRoles().contains("ADMIN");
    }

    @Override
    public boolean isUser(User user) {
        return user.getRoles().contains("USER");
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRole("USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
    }
}