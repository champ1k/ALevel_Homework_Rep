package nix.alvl.module.dao.jpa;

import nix.alvl.module.dao.DaoI;
import nix.alvl.module.util.SessionFactoryUtil;
import nix.alvl.module.entity.Category;
import nix.alvl.module.entity.Operation;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class OperationDAO implements DaoI<Operation> {
    public Operation findById(int id) {
        return SessionFactoryUtil.getSessionFactory().openSession().get(Operation.class, id);
    }

    public void save(Operation operation) {
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(operation);
        tx1.commit();
        session.close();
    }

    public void update(Operation operation) {
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(operation);
        tx1.commit();
        session.close();
    }

    public void delete(Operation operation) {
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(operation);
        tx1.commit();
        session.close();
    }

    public Category findCategoryById(int id) {
        return SessionFactoryUtil.getSessionFactory().openSession().get(Category.class, id);
    }

    public List<Operation> findAll() {
        List<Operation> operations = (List<Operation>) SessionFactoryUtil.getSessionFactory().openSession().createQuery("From Bill").list();
        return operations;
    }
}
