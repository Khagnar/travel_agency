package hibernate;

import model.Review;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateSessionFactory;

import java.util.List;

public class ReviewRepoImpl implements CommonRepo<Review> {

    @Override
    public Review getById(Long id) {
        Review review;
        try (Session session = HibernateSessionFactory
                .getSessionFactory()
                .openSession()) {
            review = session.get(Review.class, id);
        }
        return review;
    }

    @Override
    public List<Review> getAll() {
        List list;
        try (Session session = HibernateSessionFactory
                .getSessionFactory()
                .openSession()) {
            list = session.createQuery("FROM model.Review").list();
        }
        return list;
    }

    @Override
    public void add(Review review) {
        try (Session session = HibernateSessionFactory
                .getSessionFactory()
                .openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(review);
            transaction.commit();
        }
    }

    @Override
    public void delete(Review review) {
        try (Session session = HibernateSessionFactory
                .getSessionFactory()
                .openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(review);
            transaction.commit();
        }
    }

    @Override
    public void update(Review review) {
        try (Session session = HibernateSessionFactory
                .getSessionFactory()
                .openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(review);
            transaction.commit();
        }
    }
}
