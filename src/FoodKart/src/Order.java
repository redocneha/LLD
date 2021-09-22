package FoodKart.src;

public class Order {
    private int id;
    private String restaurantName;

    public int getId() {
        return id;
    }

    public Order(int id, String restaurantName, int quantity) {
        this.id = id;
        this.restaurantName = restaurantName;
        this.quantity = quantity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    private int quantity;
}
