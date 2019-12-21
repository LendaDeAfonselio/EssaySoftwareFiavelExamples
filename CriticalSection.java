import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CriticalSection {
	  private final Map<Long,Cache> caches = new ConcurrentHashMap<Long, Cache>();

	    public Cache getCache(Long cacheId) {
	        Cache cache = caches.get(cacheId);
	        if (cache == null) {
	            cache = new Cache();
	            caches.put(cacheId, cache);
	        }
	        return cache;
	    }
}
