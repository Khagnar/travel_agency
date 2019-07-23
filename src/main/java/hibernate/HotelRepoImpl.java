package hibernate;

import model.Hotel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateSessionFactory;
import java.util.List;

public class HotelRepoImpl implements CommonRepo<Hotel> {

    @Override
    public Hotel getById(Long id) {
        Hotel hotel;
        try (Session session = HibernateSessionFactory
                .getSessionFactory()
                .openSession()) {
            hotel = session.get(Hotel.class, id);
        }
        return hotel;
    }

    @Override
    public List<Hotel> getAll() {
        List list;
        try (Session session = HibernateSessionFactory
                .getSessionFactory()
                .openSession()) {
            list = session.createQuery("FROM model.Hotel").list();
        }
        return list;
    }

    @Override
    public void add(Hotel hotel) {
        try (Session session = HibernateSessionFactory
                .getSessionFactory()
                .openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(hotel);
            transaction.commit();
        }
    }

    @Override
    public void delete(Hotel hotel) {
        try (Session session = HibernateSessionFactory
                .getSessionFactory()
                .openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(hotel);
            transaction.commit();
        }
    }

    @Override
    public void update(Hotel hotel) {
        try (Session session = HibernateSessionFactory
                .getSessionFactory()
                .openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(hotel);
            transaction.commit();
        }
    }
}
