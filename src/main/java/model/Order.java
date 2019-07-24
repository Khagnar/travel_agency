package model;

import java.sql.Timestamp;
import java.util.Objects;

public class Order {

    private long orderId;
    private Timestamp date;
    private Customer customer;
    private Tour tour;

    public Order() {
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderId == order.orderId &&
                date.equals(order.date) &&
                customer.equals(order.customer) &&
                tour.equals(order.tour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, date, customer, tour);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", date=" + date +
                ", customer=" + customer +
                ", tour=" + tour +
                '}';
    }
}
