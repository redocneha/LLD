package Cache.src;

import java.util.*;

public class Main {
    public static void main(String[] args){
            int cap =2;
            CacheService cacheService = CacheService.getInstance();
            Cache cache = cacheService.intializeCache(cap,"LRU");
            cacheService.addEntry("Neha","Shaik");
            cacheService.addEntry("Irfan","Shaik2");
            cacheService.addEntry("Razia","Shaik3");
            System.out.println(cacheService.getEntry("Irfan"));
            System.out.println(cacheService.getEntry("Neha"));
            cacheService.addEntry("Neha","Shaik4");
        }
    }
