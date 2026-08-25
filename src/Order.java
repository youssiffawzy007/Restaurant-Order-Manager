import java.util.ArrayList;

public class Order {
    private final int orderId;
    private String customerName;
    private ArrayList<OrderItem> items;
    private double total = 0;
    private OrderStatus status;

    public Order(int orderId, String customerName) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.status = OrderStatus.PENDING;
        items = new ArrayList<>();
    }

    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public ArrayList<OrderItem> getItems() {
        return items;
    }

    public double getTotal() {
        return total;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setItems(ArrayList<OrderItem> items) {
        this.items = items;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void updateStatus(OrderStatus status) {
        this.status = status;
    }

    public void addItem(MenuItem item, int quantity) {
        OrderItem orderItem = new OrderItem(item, quantity);
        total += orderItem.calculateSubtotal();
        items.add(orderItem);
    }

    public void removeItem(OrderItem orderItem) {
        total -= orderItem.calculateSubtotal();
        items.remove(orderItem);
    }

    public double calculateTotal() {
        return total;
    }

    public void displayOrder() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer: " + customerName);
        System.out.println("Status: " + status.name());
        System.out.println();
        items.forEach(orderItem -> {
            System.out.println(orderItem.getItem().getName() + " * " + orderItem.getQuantity() + " = " + orderItem.calculateSubtotal());
        });
        System.out.println();
        System.out.println("Total: " + total);
    }
}
