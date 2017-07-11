package cn.pwc.demo.util;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

import java.util.Collection;

/**
 * @author boom
 * @description 缓存
 * @create 2017-05-17 0:26
 **/
public class EhcacheUtil implements CacheManager {

    private CacheManager cacheManager;

    public void setCacheManager(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    @Override
    public Cache getCache(String name) {
        return cacheManager.getCache(name);
    }

    @Override
    public Collection<String> getCacheNames() {
        return null;
    }
}
