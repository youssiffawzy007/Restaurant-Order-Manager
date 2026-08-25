public class MenuItem {
    private final int id;
    private final String name;
    private double price;
    private String category;

    public MenuItem(int id, String name, double price, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public void setPrice(double price) {
        if (price > 0)
            this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return
                "ID: " + id +
                        "\n Name: " + name +
                        "\n Price: " + price +
                        "\n Category: " + category;
    }
}
