package hibernate;

import model.Country;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateSessionFactory;
import java.util.List;

public class CountryRepoImpl implements CommonRepo<Country> {

    @Override
    public Country getById(Long id) {
        Country country;
        try (Session session = HibernateSessionFactory
                .getSessionFactory()
                .openSession()) {
            country = session.get(Country.class, id);
        }
        return country;
    }

    @Override
    public List<Country> getAll() {
        List list;
        try (Session session = HibernateSessionFactory
                .getSessionFactory()
                .openSession()) {
            list = session.createQuery("FROM public.\"Country\"").list();
        }
        return list;
    }

    @Override
    public void add(Country country) {
        try (Session session = HibernateSessionFactory
                .getSessionFactory()
                .openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(country);
            transaction.commit();
        }
    }

    @Override
    public void delete(Country country) {
        try (Session session = HibernateSessionFactory
                .getSessionFactory()
                .openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(country);
            transaction.commit();
        }
    }

    @Override
    public void update(Country country) {
        try (Session session = HibernateSessionFactory
                .getSessionFactory()
                .openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(country);
            transaction.commit();
        }
    }
}
