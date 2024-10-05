package service;

import domain.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Author :  Ahmmed Jubayer Rumman
 * Created at : 05 Oct 2024
 */
public class UserService {

    private List<User> userList = new ArrayList<>();

    public User registerUser(String email) {

        User user = new User();
        user.setEmail(email);
        userList.add(user);

        return user;
    }

    public User getUserInformation(String email) {

        return userList.stream()
                .filter(user -> user.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElse(null);
    }
}
