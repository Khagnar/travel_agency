package model;

import java.sql.Timestamp;
import java.util.Objects;

public class Order {

    private long orderId;
    private long customerId;
    private long tourId;
    private Timestamp date;

    public Order(long orderId, long customerId, long tourId, Timestamp date) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.tourId = tourId;
        this.date = date;
    }

    public Order(long customerId, long tourId, Timestamp date) {
        this.customerId = customerId;
        this.tourId = tourId;
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

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getTourId() {
        return tourId;
    }

    public void setTourId(long tourId) {
        this.tourId = tourId;
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
                customerId == order.customerId &&
                tourId == order.tourId &&
                Objects.equals(date, order.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, customerId, tourId, date);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerId=" + customerId +
                ", tourId=" + tourId +
                ", date=" + date +
                '}';
    }
}
