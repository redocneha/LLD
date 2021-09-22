package Cache.src;

class CacheDao{
    public static CacheDao cacheDao;
    private  Cache cache;
    public static CacheDao getInstance(){
        if(cacheDao== null)
        {
            cacheDao = new CacheDao();
        }
        return  cacheDao;
    }

    public Cache initialize(int capacity,String evictionPolicy){
        cache = new Cache(capacity,evictionPolicy);
        return cache;
    }


    public void addEntry(String key, String value) {
        cache.add(key,value);
    }

    public String getEntry(String key) {
        return cache.get(key);
    }
}