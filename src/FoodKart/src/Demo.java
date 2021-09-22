package FoodKart.src;

import java.util.List;

public class Demo {
    private static User currLoggedUser;
    public static void main(String[] args) {
        UserService userService = new UserService();
        RestaurantService restaurantService = new RestaurantService();
        User user1 = userService.registerUser("Neha","F","27382","HSR");
        User user2 = userService.registerUser("Irfan","M","9839","BTM");
        User user3 = userService.registerUser("Razia","F","289","BTM");
        System.out.println("user1 id"+user1.getId());
        System.out.println("user2 id"+user2.getId());
        System.out.println("user3 id"+user3.getId());
        currLoggedUser = userService.loginUser(user1.getId());
        restaurantService.registerRestaurant("Bawarchi","HSR/BTM","Samiya",100,10);
        restaurantService.registerRestaurant("Paradise","BTM/MAH","Biryani",200,5);
        currLoggedUser = userService.loginUser(user3.getId());
        restaurantService.addRating("Bawarchi",4,"Nice food");
        restaurantService.addRating("Bawarchi",3,"Nice ambience");
        restaurantService.getServiceableRestaurants(currLoggedUser.getPin());
        List<Restaurant> result = restaurantService.showRestaurants("Rating");
        for(Restaurant restaurant:result){
            System.out.println(restaurant.getName()+" "+restaurant.getDishName()+" "+restaurant.getAvgRating());
        }
        System.out.println(OrderService.placeOrder(result.get(0).getName(),4));
        System.out.println(OrderService.placeOrder(result.get(0).getName(),4));
        result = restaurantService.showRestaurants("Price");
        for(Restaurant restaurant:result){
            System.out.println(restaurant.getName()+" "+restaurant.getDishName());
        }
        currLoggedUser = userService.loginUser(user1.getId());
        restaurantService.increaseQuantity("Bawarchi",10);
        result = restaurantService.showRestaurants("Rating");
        for(Restaurant restaurant:result){
            System.out.println(restaurant.getName()+" "+restaurant.getDishName()+" "+restaurant.getAvgRating());
        }
    }
}
