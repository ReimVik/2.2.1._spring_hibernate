package hiber.dao;

import java.util.List;

import hiber.model.User;

public interface UserDao {
   void add(User user);
   List<User> listUsers();

    @SuppressWarnings("unchecked")
    List<User> getListUsers();

    List<User> getUsersByCar(String model, int series);
}
