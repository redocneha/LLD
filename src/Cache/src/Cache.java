package Cache.src;

import java.util.*;

public class Cache{
   private int capacity;
   private String evictionPolicy;
   private LinkedList<String> linkedList ;
   private HashMap<String,String> hm;
   public Cache(int capacity,String evictionPolicy){
        this.capacity = capacity;
        this.evictionPolicy = evictionPolicy;
        linkedList = new LinkedList<>();
        hm = new HashMap<>();
    }
    public void add(String key, String value){
       if(hm.containsKey(key)){
           linkedList.remove(key);
           linkedList.addFirst(key);
           hm.put(key,value);
       }
       else if(hm.size()==capacity)
       {
           hm.remove(linkedList.peekLast());
           linkedList.removeLast();
           linkedList.addFirst(key);
           hm.put(key,value);
       }
       else{
           linkedList.addFirst(key);
           hm.put(key,value);
       }
    }

    public String get(String key){
       if(hm.containsKey(key)){
           linkedList.remove(key);
           linkedList.addFirst(key);
           return hm.get(key);
       }
       return "Key is not present";
    }
}