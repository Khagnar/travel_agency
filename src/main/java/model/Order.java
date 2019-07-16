package model;

import java.util.TimeZone;

public class Order {

    private long orderId;
    private String customer;
    private String tour;
    private TimeZone date;

    public Order(String customer, String tour, TimeZone date) {
        this.customer = customer;
        this.tour = tour;
        this.date = date;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getTour() {
        return tour;
    }

    public void setTour(String tour) {
        this.tour = tour;
    }

    public TimeZone getDate() {
        return date;
    }

    public void setDate(TimeZone date) {
        this.date = date;
    }
}
