package Service;

import model.Customer;

import java.util.*;
import java.util.Map;
import java.util.ArrayList;

public class CustomerService {
    public static Collection<Customer> customers = new HashSet<>();

    private static CustomerService customerService = null;

    public void addCustomer(String firstName, String lastName, String email) {
        Customer customer = new Customer(firstName, lastName, email);
        customers.add(customer);
    }

    //Reference getCustomer: https://knowledge.udacity.com/questions/609553

    public Customer getCustomer(String customerEmail) {
        Optional<Customer> customer = customers.stream().filter(c -> customerEmail.equals(c.getEmail())).findFirst();
        return customer.orElse(null);
    }

    public Customer checkCustomer(String customerEmail) {
        for (Customer customer : customers) {
            if (customer.getEmail().equals(customerEmail)) {
                System.out.println("Customer existed");
                System.out.println("-----------------------------------------------------------");
                return customer;
            }
        } return null;
    }

    public Collection<Customer> getAllCustomers() {
        return customers;
    }

    //static Reference of CustomerService

    private CustomerService() {
    }

    public static CustomerService getInstance() {
        if(customerService == null) {
            customerService = new CustomerService();
        }
        return customerService;
    }

}
