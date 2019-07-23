package hibernate;

import model.Tour;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateSessionFactory;

import java.util.List;

public class TourRepoImpl implements CommonRepo<Tour> {
    @Override
    public Tour getById(Long id) {
        Tour tour;
        try (Session session = HibernateSessionFactory
                .getSessionFactory()
                .openSession()) {
            tour = session.get(Tour.class, id);
        }
        return tour;
    }

    @Override
    public List<Tour> getAll() {
        List list;
        try (Session session = HibernateSessionFactory
                .getSessionFactory()
                .openSession()) {
            list = session.createQuery("FROM model.Tour").list();
        }
        return list;
    }

    @Override
    public void add(Tour tour) {
        try (Session session = HibernateSessionFactory
                .getSessionFactory()
                .openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(tour);
            transaction.commit();
        }
    }

    @Override
    public void delete(Tour tour) {
        try (Session session = HibernateSessionFactory
                .getSessionFactory()
                .openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(tour);
            transaction.commit();
        }
    }

    @Override
    public void update(Tour tour) {
        try (Session session = HibernateSessionFactory
                .getSessionFactory()
                .openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(tour);
            transaction.commit();
        }
    }
}
