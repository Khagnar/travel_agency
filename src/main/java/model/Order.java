package model;

import java.sql.Timestamp;
import java.util.Objects;
import java.util.TimeZone;

public class Order {

    private long orderId;
    private long customer_id;
    private long tour_id;
    private Timestamp date;

    public Order(long orderId, long customer_id, long tour_id, Timestamp date) {
        this.orderId = orderId;
        this.customer_id = customer_id;
        this.tour_id = tour_id;
        this.date = date;
    }

    public Order(long customer_id, long tour_id, Timestamp date) {
        this.customer_id = customer_id;
        this.tour_id = tour_id;
        this.date = date;
    }

    public Order() {
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(long customer_id) {
        this.customer_id = customer_id;
    }

    public long getTour_id() {
        return tour_id;
    }

    public void setTour_id(long tour_id) {
        this.tour_id = tour_id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderId == order.orderId &&
                customer_id == order.customer_id &&
                tour_id == order.tour_id &&
                Objects.equals(date, order.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, customer_id, tour_id, date);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customer_id=" + customer_id +
                ", tour_id=" + tour_id +
                ", date=" + date +
                '}';
    }
}
