package service;

import hibernate.CustomerRepoImpl;
import model.Customer;

import java.util.List;

public class CustomerService {

    private CustomerRepoImpl customerRepo = new CustomerRepoImpl();

    public Customer getCustomerById(Long id) {
        return customerRepo.getById(id);
    }

    public List<Customer> getAllCustomers() {
        return customerRepo.getAll();
    }

    public void addCustomer(Customer customer) {
        customerRepo.add(customer);
    }

    public void deleteCustomer(Customer customer) {
        customerRepo.delete(customer);
    }

    public void updateCustomer(Customer customer) {
        customerRepo.update(customer);
    }
}
