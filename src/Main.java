import java.util.InputMismatchException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Restaurant restaurant = new Restaurant();
        boolean stay = true;
        int choice;
        System.out.println("Welcome to our Restaurant.");
        while (stay) {
            System.out.println("1. Add Menu Item\n" +
                    "2. Remove Menu Item\n" +
                    "3. Display Menu\n" +
                    "4. Search Menu Item\n" +
                    "5. Create Order\n" +
                    "6. Add Item to Order\n" +
                    "7. Remove Item from Order\n" +
                    "8. Display Order\n" +
                    "9. Add Order to Kitchen Queue\n" +
                    "10. Process Next Order\n" +
                    "11. Search Order\n" +
                    "12. Check Order Status\n" +
                    "13. Display Completed Orders\n" +
                    "14. Exit");
            while (true) {
                System.out.println("Enter your choice.");
                try {
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    if (choice >= 1 && choice <= 14)
                        break;
                    else
                        System.out.println("You can only enter valid integer between 1 and 14.");
                } catch (InputMismatchException e) {
                    scanner.nextLine();
                    System.out.println("Please enter only valid integer.");
                }
            }
            switch (choice) {
                case 1 -> {
                    int itemID;
                    double price;
                    String name, category;
                    while (true) {
                        System.out.println("Enter Menu Item ID.");
                        try {
                            itemID = scanner.nextInt();
                            scanner.nextLine();
                            if (!restaurant.isMenuItemIDExist(itemID) && itemID >= 0)
                                break;
                            else
                                System.out.println("Please Enter Unique ID.");
                        } catch (InputMismatchException e) {
                            scanner.nextLine();
                            System.out.println("Please enter only valid integer.");
                        }
                    }
                    while (true) {
                        System.out.println("Enter Menu Item Price.");
                        try {
                            price = scanner.nextDouble();
                            scanner.nextLine();
                            if (price > 0)
                                break;
                            else
                                System.out.println("You can only enter valid Number greater than 0.");
                        } catch (InputMismatchException e) {
                            scanner.nextLine();
                            System.out.println("Please enter only valid integer.");
                        }
                    }
                    System.out.println("Enter Menu Item name.");
                    name = scanner.nextLine();
                    System.out.println("Enter Menu Item category.");
                    category = scanner.nextLine();
                    restaurant.addMenuItem(itemID, name, price, category);
                }
                case 2 -> {
                    int itemID;
                    while (true) {
                        System.out.println("Enter Menu Item ID.");
                        try {
                            itemID = scanner.nextInt();
                            scanner.nextLine();
                            if (itemID >= 0)
                                break;
                            else
                                System.out.println("Please Enter ID greater than 0.");
                        } catch (InputMismatchException e) {
                            scanner.nextLine();
                            System.out.println("Please enter only valid integer.");
                        }
                    }
                    restaurant.removeMenuItem(itemID);
                }
                case 3 -> {
                    restaurant.displayMenu();
                }
                case 4 -> {
                    int itemID;
                    while (true) {
                        System.out.println("Enter Menu Item ID.");
                        try {
                            itemID = scanner.nextInt();
                            scanner.nextLine();
                            if (itemID >= 0)
                                break;
                            else
                                System.out.println("Please Enter ID greater than 0.");
                        } catch (InputMismatchException e) {
                            scanner.nextLine();
                            System.out.println("Please enter only valid integer.");
                        }
                    }
                    MenuItem menuItem = restaurant.searchMenuItem(itemID);
                    if (menuItem != null) {
                        System.out.println("Menu Item: ");
                        System.out.println(menuItem);
                    }
                }
                case 5 -> {
                    int orderID;
                    String customerName;
                    while (true) {
                        System.out.println("Enter Menu Item ID.");
                        try {
                            orderID = scanner.nextInt();
                            scanner.nextLine();
                            if (!restaurant.isOrderIDExist(orderID) && orderID >= 0)
                                break;
                            else
                                System.out.println("Please Enter Unique ID.");
                        } catch (InputMismatchException e) {
                            scanner.nextLine();
                            System.out.println("Please enter only valid integer.");
                        }
                    }
                    System.out.println("Enter Customer Name.");
                    customerName = scanner.nextLine();
                    restaurant.createOrder(orderID, customerName);
                }
                case 6 -> {
                    int orderID, itemID, quantity;
                    while (true) {
                        System.out.println("Enter Order ID.");
                        try {
                            orderID = scanner.nextInt();
                            scanner.nextLine();
                            if (orderID >= 0)
                                break;
                            else
                                System.out.println("Please Enter ID greater than 0.");
                        } catch (InputMismatchException e) {
                            scanner.nextLine();
                            System.out.println("Please enter only valid integer.");
                        }
                    }
                    while (true) {
                        System.out.println("Enter Menu Item ID.");
                        try {
                            itemID = scanner.nextInt();
                            scanner.nextLine();
                            if (itemID >= 0) {
                                break;
                            } else {
                                System.out.println("Please Enter ID greater than 0.");
                            }
                        } catch (InputMismatchException e) {
                            scanner.nextLine();
                            System.out.println("Please enter only valid integer.");
                        }
                    }
                    while (true) {
                        System.out.println("Enter the Quantity.");
                        try {
                            quantity = scanner.nextInt();
                            scanner.nextLine();
                            if (quantity > 0)
                                break;
                            else
                                System.out.println("You can only enter valid integer greater than 0.");
                        } catch (InputMismatchException e) {
                            scanner.nextLine();
                            System.out.println("Please enter only valid integer.");
                        }
                    }
                    restaurant.addItemToOrder(orderID, itemID, quantity);
                }
                case 7 -> {
                    int orderID, itemID;
                    while (true) {
                        System.out.println("Enter Order ID.");
                        try {
                            orderID = scanner.nextInt();
                            scanner.nextLine();
                            if (orderID >= 0)
                                break;
                            else
                                System.out.println("Please Enter ID greater than 0.");
                        } catch (InputMismatchException e) {
                            scanner.nextLine();
                            System.out.println("Please enter only valid integer.");
                        }
                    }
                    while (true) {
                        System.out.println("Enter Menu Item ID.");
                        try {
                            itemID = scanner.nextInt();
                            scanner.nextLine();
                            if (itemID >= 0) {
                                break;
                            } else {
                                System.out.println("Please Enter ID greater than 0.");
                            }
                        } catch (InputMismatchException e) {
                            scanner.nextLine();
                            System.out.println("Please enter only valid integer.");
                        }
                    }
                    restaurant.removeItemFromOrder(orderID, itemID);
                }
                case 8 -> {
                    int orderID;
                    while (true) {
                        System.out.println("Enter Order ID.");
                        try {
                            orderID = scanner.nextInt();
                            scanner.nextLine();
                            if (orderID >= 0)
                                break;
                            else
                                System.out.println("Please Enter ID greater than 0.");
                        } catch (InputMismatchException e) {
                            scanner.nextLine();
                            System.out.println("Please enter only valid integer.");
                        }
                    }
                    restaurant.displayOrder(orderID);
                }
                case 9 -> {
                    int orderID;
                    while (true) {
                        System.out.println("Enter Order ID.");
                        try {
                            orderID = scanner.nextInt();
                            scanner.nextLine();
                            if (orderID >= 0)
                                break;
                            else
                                System.out.println("Please Enter ID greater than 0.");
                        } catch (InputMismatchException e) {
                            scanner.nextLine();
                            System.out.println("Please enter only valid integer.");
                        }
                    }
                    restaurant.addOrderToKitchen(orderID);
                }
                case 10 -> {
                    restaurant.processNextOrder();
                }
                case 11 -> {
                    int orderID;
                    while (true) {
                        System.out.println("Enter Order ID.");
                        try {
                            orderID = scanner.nextInt();
                            scanner.nextLine();
                            if (orderID >= 0) {
                                break;
                            } else {
                                System.out.println("Please Enter ID greater than 0.");
                            }
                        } catch (InputMismatchException e) {
                            scanner.nextLine();
                            System.out.println("Please enter only valid integer.");
                        }
                    }
                    Order order = restaurant.searchOrder(orderID);
                    if (order == null) {
                        System.out.println("This Order ID not exist.");
                    }else {
                        System.out.println("Order Data: ");
                        order.displayOrder();
                    }
                }
                case 12 -> {
                    int orderID;
                    while (true) {
                        System.out.println("Enter Order ID.");
                        try {
                            orderID = scanner.nextInt();
                            scanner.nextLine();
                            if (orderID >= 0)
                                break;
                            else
                                System.out.println("Please Enter ID greater than 0.");
                        } catch (InputMismatchException e) {
                            scanner.nextLine();
                            System.out.println("Please enter only valid integer.");
                        }
                    }
                    restaurant.checkOrderStatus(orderID);
                }
                case 13 -> {
                    restaurant.displayCompletedOrders();
                }
                case 14 -> {
                    System.out.println("Thanks for visiting our Restaurant.");
                    stay = false;
                }
            }
        }

    }
}