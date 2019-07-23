package hibernate;

import model.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateSessionFactory;
import java.util.List;

public class CustomerRepoImpl implements CommonRepo<Customer> {
    
    @Override
    public Customer getById(Long id) {
        Customer customer;
        try (Session session = HibernateSessionFactory
                .getSessionFactory()
                .openSession()) {
            customer = session.get(Customer.class, id);
        }
        return customer;
    }

    @Override
    public List<Customer> getAll() {
        List list;
        try (Session session = HibernateSessionFactory
                .getSessionFactory()
                .openSession()) {
            list = session.createQuery("FROM model.Customer").list();
        }
        return list;
    }

    @Override
    public void add(Customer Customer) {
        try (Session session = HibernateSessionFactory
                .getSessionFactory()
                .openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(Customer);
            transaction.commit();
        }
    }

    @Override
    public void delete(Customer customer) {
        try (Session session = HibernateSessionFactory
                .getSessionFactory()
                .openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(customer);
            transaction.commit();
        }
    }

    @Override
    public void update(Customer customer) {
        try (Session session = HibernateSessionFactory
                .getSessionFactory()
                .openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(customer);
            transaction.commit();
        }
    }
}
