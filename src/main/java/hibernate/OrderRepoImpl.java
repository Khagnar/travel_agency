package hibernate;

import model.Order;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateSessionFactory;

import java.util.List;

public class OrderRepoImpl implements CommonRepo<Order> {

    @Override
    public Order getById(Long id) {
        Order order;
        try (Session session = HibernateSessionFactory
                .getSessionFactory()
                .openSession()) {
            order = session.get(Order.class, id);
        }
        return order;
    }

    @Override
    public List<Order> getAll() {
        List list;
        try (Session session = HibernateSessionFactory
                .getSessionFactory()
                .openSession()) {
            list = session.createQuery("FROM model.Order").list();
        }
        return list;
    }

    @Override
    public void add(Order order) {
        try (Session session = HibernateSessionFactory
                .getSessionFactory()
                .openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(order);
            transaction.commit();
        }
    }

    @Override
    public void delete(Order order) {
        try (Session session = HibernateSessionFactory
                .getSessionFactory()
                .openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(order);
            transaction.commit();
        }
    }

    @Override
    public void update(Order order) {
        try (Session session = HibernateSessionFactory
                .getSessionFactory()
                .openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(order);
            transaction.commit();
        }
    }
}
