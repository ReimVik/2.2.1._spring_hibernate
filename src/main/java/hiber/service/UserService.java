package hiber.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import hiber.model.User;

public interface UserService {
    void add(User user);
    List<User> listUsers();

    @Transactional(readOnly = true)
    List<User> getListUsers();

    List<User> getUsersByCar(String model, int series);
}
