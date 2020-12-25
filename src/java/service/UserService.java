package service;

import java.util.List;
import model.User;

public interface UserService {

    boolean checkExistUsername(String username);

    void insert(User user);

    User get(String username);

    boolean register(String email, String password, String username);

    User login(String username, String password);

    List<User> search(String keyword);

    void delete(int id);

    User get(int id);

    void edit(User user);

    List<User> getAll();

    boolean checkExistEmail(String email);

    void active(int id);
}
