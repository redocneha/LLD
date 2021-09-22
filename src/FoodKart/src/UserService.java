package FoodKart.src;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    public static User getCurrUser() {
        return currUser;
    }

    private static User currUser ;
    List<User> userList = new ArrayList<>();
    public User registerUser(String name,String gender,String phNo,String pin){
        User user = new User(IDGenerator.generaterId(),name,gender,phNo,pin);
        userList.add(user);
        return user;
    }
    public User loginUser(int id){
        for(User user:userList){
            if(user.getId()==id){
                currUser = user;
                return user;
        }}
        return null;
    }
    public static void addOrder(Order order){
        List<Order> temp = currUser.getOrderList();
        temp.add(order);
        currUser.setOrderList(temp);
    }

}
