package service;

import dao.OrderRepoImpl;
import model.Order;

import java.sql.Timestamp;

public class OrderService {

    private OrderRepoImpl orderRepo = new OrderRepoImpl();

    public void getOrderById(Long id) {
        System.out.println("| " + id + " | " + orderRepo.getById(id).getCustomerId() +
                 " | " + orderRepo.getById(id).getTourId()+ " |");
    }

    public void getAllOrders() {
        for (Order t : orderRepo.getAll()) {
            getOrderById(t.getOrderId());
        }
    }

    public void addOrder(Order order) {
        orderRepo.add(order);
        System.out.println("Order " + order.getOrderId() + " was added!" );
    }

    public void deleteOrder(Long id) {
        System.out.println("Order " + orderRepo.getById(id) + "was deleted!");
        orderRepo.delete(id);
    }

    public void setOrder(Long id, long customer_id, long tour_id, Timestamp date) {
        Order update = orderRepo.getById(id);
        update.setOrderId(id);
        update.setCustomerId(customer_id);
        update.setTourId(tour_id);
        update.setDate(date);
        orderRepo.update(update);
        System.out.println("Order was changed!");
    }
}
