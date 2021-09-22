package FoodKart.src;

public class IDGenerator {
    private static int id=1;
    public static int generaterId(){
        return id++;
    }
}
