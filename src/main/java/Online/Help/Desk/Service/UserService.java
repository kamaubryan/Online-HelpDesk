package Online.Help.Desk.Service;

import Online.Help.Desk.Model.User;

public interface UserService {

    User findUserByEmail(String email);

    boolean findRoleByUser(String role, User user);

    boolean isAdmin(User user);

    boolean isUser(User user);

    void saveUser(User user);
}
