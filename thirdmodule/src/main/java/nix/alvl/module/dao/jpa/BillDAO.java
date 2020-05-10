package nix.alvl.module.dao.jpa;

import nix.alvl.module.dao.DaoI;
import nix.alvl.module.util.SessionFactoryUtil;
import nix.alvl.module.entity.Bill;
import nix.alvl.module.entity.Operation;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class BillDAO implements DaoI<Bill> {

    public Bill findById(int id) {
        return SessionFactoryUtil.getSessionFactory().openSession().get(Bill.class, id);
    }

    public void save(Bill bill) {
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(bill);
        tx1.commit();
        session.close();
    }

    public void update(Bill bill) {
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(bill);
        tx1.commit();
        session.close();
    }

    public void delete(Bill bill) {
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(bill);
        tx1.commit();
        session.close();
    }

    public Operation findOperationById(int id) {
        return SessionFactoryUtil.getSessionFactory().openSession().get(Operation.class, id);
    }

    public List<Bill> findAll() {
        List<Bill> bills = (List<Bill>) SessionFactoryUtil.getSessionFactory().openSession().createQuery("From Bill").list();
        return bills;
    }
}
