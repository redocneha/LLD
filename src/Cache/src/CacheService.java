package Cache.src;

class CacheService{
    public static CacheService cacheService;
    private  CacheDao cacheDao;
    public static CacheService getInstance(){
        if(cacheService == null)
        {
            cacheService = new CacheService();
        }
        return  cacheService;
    }

    public Cache intializeCache(int capacity, String evictionPolicy){
        cacheDao = CacheDao.getInstance();
       return cacheDao.initialize(capacity,evictionPolicy);

    }
    public void addEntry(String key,String value){
        cacheDao.addEntry(key,value);
    }

    public String getEntry(String key){
        return cacheDao.getEntry(key);
    }

}