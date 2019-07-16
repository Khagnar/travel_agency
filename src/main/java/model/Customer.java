package model;

public class Customer {

    private long customerId;
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public Customer(long customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
