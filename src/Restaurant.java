import java.util.*;

public class Restaurant {
    private ArrayList<MenuItem> menu;
    private LinkedList<Order> kitchenQueue;
    private HashMap<Integer, Order> orders;
    private LinkedHashMap<Integer, Order> completedOrders;

    public Restaurant() {
        menu = new ArrayList<>();
        kitchenQueue = new LinkedList<>();
        orders = new HashMap<>();
        completedOrders = new LinkedHashMap<>();
    }

    public void addMenuItem(int id, String name, double price, String category) {
        if (!menu.isEmpty()) {
            for (MenuItem menuItem : menu) {
                if (id == menuItem.getId()) {
                    System.out.println("This ID already exists.");
                    return;
                }
            }
        }
        MenuItem newItem = new MenuItem(id, name, price, category);
        menu.add(newItem);
        System.out.println("This Menu Item done successfully.");
        System.out.println(newItem);
    }

    public void removeMenuItem(int id) {
        boolean removed = menu.removeIf(
                menuItem -> menuItem.getId() == id
        );

        if (removed) {
            System.out.println("This Menu Item removed successfully.");
        } else {
            System.out.println("This ID not found.");
        }
    }

    public void displayMenu() {
        int counter = 1;
        menu.forEach(menuItem -> {
          System.out.println("Menu Item " + counter++);
          System.out.println(menuItem);
        });
    }

    public MenuItem searchMenuItem(int id) {
        Optional<MenuItem> item = menu.stream()
            .filter(menuItem -> menuItem.getId() == id)
            .findFirst();

        if (item.isPresent()) {
            return item.get();
        }

        System.out.println("This ID not found.");
        return null;
    }

    public void createOrder(int ID, String customerName) {
        if (orders.containsKey(ID)) {
            System.out.println("This ID already exists.");
            return;
        }
        Order newOrder = new Order(ID, customerName);
        orders.put(ID, newOrder);
        System.out.println("This Order created successfully.");
        newOrder.displayOrder();
    }

    public void addItemToOrder(int OrderID, int ItemID, int quantity) {
        if (!orders.containsKey(OrderID)) {
            System.out.println("This Order ID not found.");
            return;
        }
        if (orders.get(OrderID).getStatus() == OrderStatus.CANCELLED) {
            System.out.println("This Order already Cancelled.");
            return;
        }
        if (orders.get(OrderID).getStatus() == OrderStatus.COMPLETED) {
            System.out.println("This Order already Completed.");
            return;
        }
        for (MenuItem menuItem : menu) {
            if (menuItem.getId() == ItemID) {
                orders.get(OrderID).addItem(menuItem, quantity);
                System.out.println("This Menu item added successfully.");
                return;
            }
        }
        System.out.println("This Menu Item ID not found.");
    }

    public void removeItemFromOrder(int OrderID, int ItemID) {
        if (!orders.containsKey(OrderID)) {
            System.out.println("This Order ID not found.");
            return;
        }
        if (orders.get(OrderID).getStatus() == OrderStatus.CANCELLED) {
            System.out.println("This Order already Cancelled.");
            return;
        }
        if (orders.get(OrderID).getStatus() == OrderStatus.COMPLETED) {
            System.out.println("This Order already Completed.");
            return;
        }
        MenuItem item = searchMenuItem(ItemID);
        if (item == null) {
            System.out.println("This Menu Item ID not found.");
            return;
        }
        for (int i = 0; i < orders.get(OrderID).getItems().size(); i++) {
            if (orders.get(OrderID).getItems().get(i).getItem() == item) {
                orders.get(OrderID).removeItem(orders.get(OrderID).getItems().get(i));
                System.out.println("This Item removed successfully.");
                return;
            }
        }
        System.out.println("This Item not found in this Order.");
    }

    public void displayOrder(int orderID) {
        Order order = orders.get(orderID);
        if (order == null) {
            System.out.println("This Order ID not found.");
            return;
        }
        System.out.println("Order Data: ");
        order.displayOrder();
    }

    public void addOrderToKitchen(int orderID) {
        Order order = orders.get(orderID);
        if (order == null) {
            System.out.println("This Order ID not found.");
            return;
        }
        if (order.getStatus() != OrderStatus.PENDING) {
            System.out.println("This Order already " + order.getStatus().name());
            return;
        }
        if (kitchenQueue.contains(order)) {
            System.out.println("This Order already in Kitchen");
            return;
        }
        kitchenQueue.add(order);
        order.updateStatus(OrderStatus.IN_KITCHEN);
        System.out.println("This order has been successfully placed in the kitchen.");
    }

    public void processNextOrder() {
        if (kitchenQueue.isEmpty()) {
            System.out.println("There are no orders in kitchen yet.");
            return;
        }
        Order order = kitchenQueue.getFirst();
        order.updateStatus(OrderStatus.COMPLETED);
        completedOrders.put(order.getOrderId(), order);
        kitchenQueue.removeFirst();
        System.out.println("This Order process successfully.");
    }

    public Order searchOrder(int orderID) {
        Order order = orders.get(orderID);
        return orders.get(orderID);

    }

    public void checkOrderStatus(int orderID) {
        Order order = orders.get(orderID);
        if (order == null) {
            System.out.println("This Order ID not exist.");
            return;
        }
        System.out.println("Order " + orderID + " Status: " + order.getStatus().name());
    }

    public void displayCompletedOrders() {
        int counter = 1;
        for (Map.Entry<Integer, Order> entry : completedOrders.entrySet()) {
            System.out.println("Order " + counter++);
            entry.getValue().displayOrder();
        }
    }

    public boolean isMenuItemIDExist(int itemID){
        if (menu.isEmpty())
            return false;
        for (MenuItem menuItem : menu) {
            if (itemID == menuItem.getId()) {
                return true;
            }
        }
        return false;
    }

    public boolean isOrderIDExist(int orderID){
        return orders.containsKey(orderID);
    }
}
