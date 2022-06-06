package hiber.service;

import java.util.List;

import hiber.model.User;

public interface UserService {
    void add(User user);
    List<User> getListUsers();

    List<User> getUsersByCar(String model, int series);
}
