package FoodKart.src;

public class OrderService {
    public static String placeOrder(String name, int quantity){
        if(RestaurantService.placeOrder(name,quantity)) {
            return "Order placed successfully";
        }
        return "Cannot place order";
    }
}
