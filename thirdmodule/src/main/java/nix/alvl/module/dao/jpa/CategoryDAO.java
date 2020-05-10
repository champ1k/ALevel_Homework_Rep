package nix.alvl.module.dao.jpa;

import nix.alvl.module.dao.DaoI;
import nix.alvl.module.util.SessionFactoryUtil;
import nix.alvl.module.entity.Category;
import nix.alvl.module.entity.CategoryType;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CategoryDAO implements DaoI<Category> {
    public Category findById(int id) {
        return SessionFactoryUtil.getSessionFactory().openSession().get(Category.class, id);
    }

    public void save(Category category) {
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(category);
        tx1.commit();
        session.close();
    }

    public void update(Category category) {
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(category);
        tx1.commit();
        session.close();
    }

    public void delete(Category category) {
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(category);
        tx1.commit();
        session.close();
    }

    public CategoryType findCategoryTypeById(int id) {
        return SessionFactoryUtil.getSessionFactory().openSession().get(CategoryType.class, id);
    }

    public List<Category> findAll() {
        List<Category> categorys = (List<Category>) SessionFactoryUtil.getSessionFactory().openSession().createQuery("From Bill").list();
        return categorys;
    }
}
