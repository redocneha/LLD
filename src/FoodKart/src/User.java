package FoodKart.src;

import java.util.*;

public class User {
    private static User user;

    public static User getInstance(int id,String name, String gender, String phNo, String pin){
        if(user == null)
            user = new User(id,name,gender,phNo,pin);
        return user;
    }
    private int id;

    public User(int id,String name, String gender, String phNo, String pin) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.phNo = phNo;
        this.pin = pin;
        orderList = new ArrayList<>();
    }

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhNo() {
        return phNo;
    }

    public void setPhNo(String phNo) {
        this.phNo = phNo;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    private String gender;
    private String phNo;
    private String pin;
    private List<Order> orderList;
}
