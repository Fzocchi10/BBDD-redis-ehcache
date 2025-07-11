package aeropuerto_api.tp.config;

import java.util.List;

import javax.cache.CacheManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.cache.support.CompositeCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;

@Configuration
@EnableCaching
public class CacheConfig {

    @Autowired
    private RedisCacheConfiguration redisCacheConfiguration;

    @Bean
    RedisCacheManager redisCacheManager(RedisConnectionFactory redisConnectionFactory) {
        return RedisCacheManager.builder(redisConnectionFactory)
                .cacheDefaults(redisCacheConfiguration)
                .build();
    }

    @Bean
    JCacheCacheManager jCacheCacheManager(CacheManager ehcacheManager) {
        return new JCacheCacheManager(ehcacheManager);
    }

    @Bean
    @Primary
    CompositeCacheManager compositeCacheManager(RedisCacheManager redisCacheManager,
                                                       JCacheCacheManager jCacheCacheManager) {
        CompositeCacheManager compositeCacheManager = new CompositeCacheManager();
        compositeCacheManager.setCacheManagers(List.of(
                jCacheCacheManager, 
                redisCacheManager   
        ));
        compositeCacheManager.setFallbackToNoOpCache(true);
        return compositeCacheManager;
    }
}
