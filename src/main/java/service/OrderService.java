package service;

import hibernate.OrderRepoImpl;
import model.Order;

import java.util.List;

public class OrderService {

    private OrderRepoImpl orderRepo = new OrderRepoImpl();

    public Order getOrderById(Long id) {
        return orderRepo.getById(id);
    }

    public List<Order> getAllOrders() {
        return orderRepo.getAll();
    }

    public void addOrder(Order order) {
        orderRepo.add(order);
    }

    public void deleteOrder(Order order) {
        orderRepo.delete(order);
    }

    public void updateOrder(Order order) {
        orderRepo.update(order);
    }
}
