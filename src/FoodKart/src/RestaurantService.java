package FoodKart.src;

import java.util.*;

public class RestaurantService {

    private static HashMap<String,Restaurant> hm = new HashMap<>();

    public Restaurant registerRestaurant(String name,String pins,String dishName,int price,int initialQuantity){
        List<String> pincodes = Arrays.asList(pins.split("/"));
        Restaurant restaurant = new Restaurant(name,dishName,price,initialQuantity,pincodes);
        hm.put(name,restaurant);
        return restaurant;
    }

    public void increaseQuantity(String restaurantName,int extra){
        int finalQuant = hm.get(restaurantName).getInitialQuantity()+extra;
        hm.get(restaurantName).setInitialQuantity(finalQuant);

    }

    public void addRating(String name,double rating,String comment){
        Restaurant restaurant = hm.get(name);
        restaurant.rate(rating,comment);
    }

    public double getAvgRating(String name){
        return hm.get(name).getAvgRating();
    }

    public static boolean placeOrder(String name, int quantity){
        int actual = hm.get(name).getInitialQuantity();
        if(actual<quantity) return false;
        hm.get(name).setInitialQuantity(actual-quantity);
        UserService.addOrder(new Order(IDGenerator.generaterId(),name,quantity));
        return true;
    }

    public List<Restaurant> getServiceableRestaurants(String pin){
        List<Restaurant> result = new ArrayList<>();
        for(Restaurant restaurant:hm.values()){
            if(restaurant.getPinList().contains(pin) && restaurant.getInitialQuantity() > 0)
                result.add(restaurant);
        }
        return result;
    }

    public List<Restaurant> sortByRating(List<Restaurant> restaurantList){
        Collections.sort(restaurantList, new Comparator<Restaurant>() {
            @Override
            public int compare(Restaurant o1, Restaurant o2) {
                return (int) (o2.getAvgRating()-o1.getAvgRating());
            }
        });
        return restaurantList;
    }

    public List<Restaurant> sortByPrice(List<Restaurant> restaurantList){
        Collections.sort(restaurantList, new Comparator<Restaurant>() {
            @Override
            public int compare(Restaurant o1, Restaurant o2) {
                return (int) (o2.getPrice()-o1.getPrice());
            }
        });
        return restaurantList;
    }

    public List<Restaurant> showRestaurants(String type){
        List<Restaurant> temp = getServiceableRestaurants(UserService.getCurrUser().getPin());
        if(type.equals("Price"))
            return sortByPrice(temp);
        return sortByRating(temp);
    }
}
