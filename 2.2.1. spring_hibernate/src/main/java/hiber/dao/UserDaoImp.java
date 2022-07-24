package hiber.dao;

import java.util.List;
import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import hiber.model.User;

@Repository
public class UserDaoImp implements UserDao {

   private final SessionFactory sessionFactory;

   public UserDaoImp(SessionFactory sessionFactory) {
      this.sessionFactory = sessionFactory;
   }

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> getListUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   @SuppressWarnings("ALL")
   public List<User> getUsersByCar(String model, int series) {
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User where car in (from Car where model = :model and series = :series)")
              .setParameter("model", model)
              .setParameter("series", series);
      return query.getResultList();
   }
}
