package nix.alvl.module.dao.jpa;

import nix.alvl.module.dao.DaoI;
import nix.alvl.module.entity.Bill;
import nix.alvl.module.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import nix.alvl.module.util.SessionFactoryUtil;

import java.util.List;

public class UserDAO implements DaoI<User> {
    public User findById(int id) {
        return SessionFactoryUtil.getSessionFactory().openSession().get(User.class, id);
    }

    public void save(User user) {
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }

    public void update(User user) {
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
    }

    public void delete(User user) {
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }

    public Bill findBillById(int id) {
        return SessionFactoryUtil.getSessionFactory().openSession().get(Bill.class, id);
    }

    public List<User> findAll() {
        List<User> users = (List<User>) SessionFactoryUtil.getSessionFactory().openSession().createQuery("From User").list();
        return users;
    }
}
