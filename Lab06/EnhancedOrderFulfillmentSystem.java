package lab_java;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EnhancedOrderFulfillmentSystem {

    private ConcurrentHashMap<String, Integer> inventory;
    private ConcurrentHashMap<Integer, Order> orders;
    private ExecutorService executorService;

    public EnhancedOrderFulfillmentSystem() {
        inventory = new ConcurrentHashMap<>();
        orders = new ConcurrentHashMap<>();
        executorService = Executors.newFixedThreadPool(10);
    }

    public static class Item {
        public String id;
        public int quantity;

        public Item(String id, int quantity) {
            this.id = id;
            this.quantity = quantity;
        }
    }

    public static class Order {
        public int id;
        public List<Item> items;

        public Order(int id, List<Item> items) {
            this.id = id;
            this.items = items;
        }
    }

    public void placeOrder(Order order) {
        orders.put(order.id, order);
    }

    public void updateInventory(Order order) throws InsufficientInventoryException {
        for (Item item : order.items) {
            int currentQuantity = inventory.getOrDefault(item.id, 0);
            if (currentQuantity >= item.quantity) {
                inventory.put(item.id, currentQuantity - item.quantity);
            } else {
                throw new InsufficientInventoryException(item.id);
            }
        }
    }

    public boolean checkInventoryAvailability(Item item) {
        return inventory.getOrDefault(item.id, 0) >= item.quantity;
    }

    public void startProcessing() {
        for (Order order : orders.values()) {
            executorService.submit(new OrderProcessingTask(order));
        }
    }

    public void waitForCompletion() {
        executorService.shutdown();
        while (!executorService.isTerminated()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public String trackOrderStatus(int orderId) {
        Order order = orders.get(orderId);
        if (order == null) {
            return "Order not found";
        }

        StringBuilder status = new StringBuilder("Order status: ");
        for (Item item : order.items) {
            int currentQuantity = inventory.getOrDefault(item.id, 0);
            if (currentQuantity >= item.quantity) {
                status.append(item.id).append(" available, ");
            } else {
                status.append(item.id).append(" unavailable, ");
            }
        }

        return status.toString();
    }

    public class InsufficientInventoryException extends Exception {
        public InsufficientInventoryException(String itemId) {
            super("Insufficient inventory for item " + itemId);
        }
    }

    private class OrderProcessingTask implements Callable<Void> {
        private Order order;

        public OrderProcessingTask(Order order) {
            this.order = order;
        }

        @Override
        public Void call() throws Exception {
            try {
                updateInventory(order);
            } catch (InsufficientInventoryException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public static void main(String[] args) {
    EnhancedOrderFulfillmentSystem system = new EnhancedOrderFulfillmentSystem();

    system.inventory.put("item1", 10);
    system.inventory.put("item2", 2);
    system.inventory.put("item3", 15);
    system.inventory.put("item4", 5);

    List<EnhancedOrderFulfillmentSystem.Item> items1 = new ArrayList<>();
    items1.add(new EnhancedOrderFulfillmentSystem.Item("item1", 3));
    items1.add(new EnhancedOrderFulfillmentSystem.Item("item2", 2));
    system.placeOrder(new EnhancedOrderFulfillmentSystem.Order(1, items1));

    List<EnhancedOrderFulfillmentSystem.Item> items2 = new ArrayList<>();
    items2.add(new EnhancedOrderFulfillmentSystem.Item("item3", 7));
    items2.add(new EnhancedOrderFulfillmentSystem.Item("item4", 3));
    system.placeOrder(new EnhancedOrderFulfillmentSystem.Order(2, items2));

    system.startProcessing();

    system.waitForCompletion();

    String status = system.trackOrderStatus(1);
    System.out.println(status);

    String status2 = system.trackOrderStatus(2);
    System.out.println(status2);
}
}

