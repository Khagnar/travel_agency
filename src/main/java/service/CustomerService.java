package service;

import dao.CustomerRepoImpl;
import model.Customer;

public class CustomerService {
    private CustomerRepoImpl customerRepo = new CustomerRepoImpl();

    public void getCustomerById(Long id) {
        System.out.println("| " + id + " | " + customerRepo.getById(id).getName() + " |");
    }

    public void getAllCustomers() {
        for (Customer c : customerRepo.getAll()) {
            getCustomerById(c.getCustomerId());
        }
    }

    public void addCustomer(Customer customer) {
        customerRepo.add(customer);
        System.out.println("Customer " + customer.getName() + " was added!" );
    }

    public void deleteCustomer(Long id) {
        System.out.println("Customer " + customerRepo.getById(id).getName() + "was deleted!");
        customerRepo.delete(id);
    }

    public void setCustomer(Long id, String name) {
        Customer update = customerRepo.getById(id);
        update.setCustomerId(id);
        update.setName(name);
        customerRepo.update(update);
        System.out.println("Customer was changed!");
    }
}
