package hiber;

import java.sql.SQLException;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hiber.config.AppConfigure;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfigure.class);

      UserService userService = context.getBean(UserService.class);

     /* userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));*/
      userService.add(new User(new Car("Ferrari", 123),"Petr", "Ivanov", "Ivanov@mail.ru"));
      userService.add(new User(new Car("Lambo", 99),"Pavel", "Petrov", "Petrov@mail.ru"));

      List<User> usersWithCar = userService.getUsersByCar("Ferrari", 123);



      /*List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }*/

      for (User user : usersWithCar) {
         System.out.println("Id = " + user.getId());
         System.out.println("carModel = " + user.getCar().getModel());
         System.out.println("carSeries = " + user.getCar().getSeries());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }

      context.close();
   }
}
