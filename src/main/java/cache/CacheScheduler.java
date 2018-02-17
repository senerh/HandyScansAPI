package cache;

import dto.MangaDTO;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.Map;

@Singleton
@Startup
public class CacheScheduler {

    @EJB
    private MangaCache mangaCache;

    @PostConstruct
    public void postConstruct() {
        refreshCache();
    }

    @Schedule(minute="*/30", hour="*", persistent = false)
    private void refreshCache() {
        Map<String, MangaDTO> cache = mangaCache.loadFreshCache();
        mangaCache.setCache(cache);
    }
}
