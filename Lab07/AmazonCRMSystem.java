package lab_java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

// Customer class
class Customer implements Comparable<Customer> {
    private String customerId;
    private String name;

    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }


    @Override
    public int compareTo(Customer otherCustomer) {
        return this.customerId.compareTo(otherCustomer.getCustomerId());
    }
}

// Product class
class Product implements Comparable<Product> {
    private String productId;
    private String name;

    public Product(String productId, String name) {
        this.productId = productId;
        this.name = name;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Product otherProduct) {
        return this.productId.compareTo(otherProduct.getProductId());
    }
}

// Order class
class Order {
    private String orderId;
    private Customer customer;
    private ArrayList<Product> products;

    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public String getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

}

// Main class
public class AmazonCRMSystem {
    public static void main(String[] args) {
        // Implementation of ArrayList 
        ArrayList<Customer> customersList = new ArrayList<>();
        ArrayList<Product> productsList = new ArrayList<>();
        ArrayList<Order> ordersList = new ArrayList<>();

        // Sample customers, products, and orders
        Customer customer1 = new Customer("001", "abcde");
        customersList.add(customer1);

        Product product1 = new Product("p0123", "Laptop");
        productsList.add(product1);

        Order order1 = new Order("0O1", customer1);
        order1.addProduct(product1);
        ordersList.add(order1);

        // Implementation of HashMap 
        HashMap<String, Customer> customerMap = new HashMap<>();
        HashMap<String, Product> productMap = new HashMap<>();

        for (Customer customer : customersList) {
            customerMap.put(customer.getCustomerId(), customer);
        }

        for (Product product : productsList) {
            productMap.put(product.getProductId(), product);
        }

        // Implementation of HashSet 
        HashSet<Product> uniqueProductsSet = new HashSet<>();

        // Adding products to the set
        uniqueProductsSet.add(product1);

        // Implementation of TreeSet
        TreeSet<Customer> sortedCustomersSet = new TreeSet<>(customersList);
        TreeSet<Product> sortedProductsSet = new TreeSet<>(productsList);

        // Display information about customers
        System.out.println("Customers:");
        for (Customer customer : customersList) {
            System.out.println("Customer ID: " + customer.getCustomerId() + ", Name: " + customer.getName());
        }

        // Display information about products
        System.out.println("\nProducts:");
        for (Product product : productsList) {
            System.out.println("Product ID: " + product.getProductId() + ", Name: " + product.getName());
        }

        // Display information about orders and associated products
        System.out.println("\nOrders:");
        for (Order order : ordersList) {
            System.out.println("Order ID: " + order.getOrderId() + ", Customer: " + order.getCustomer().getName());

            System.out.println("Products in the order:");
            for (Product product : order.getProducts()) {
                System.out.println("  Product ID: " + product.getProductId() + ", Name: " + product.getName());
            }
        }
    }
}

