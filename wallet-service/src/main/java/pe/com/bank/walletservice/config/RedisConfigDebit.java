package pe.com.bank.walletservice.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveHashOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import pe.com.bank.walletservice.dto.DebitDto;

@Configuration
@ConditionalOnProperty(name = "cache.enabled", havingValue = "true")
public class RedisConfigDebit {

    @Bean
    public ReactiveHashOperations<String, Integer, DebitDto> hashOperations(ReactiveRedisConnectionFactory redisConnectionFactory){
        var template = new ReactiveRedisTemplate<>(
                redisConnectionFactory,
                RedisSerializationContext.<String, DebitDto>newSerializationContext(new StringRedisSerializer())
                                         .hashKey(new GenericToStringSerializer<>(Integer.class))
                                         .hashValue(new Jackson2JsonRedisSerializer<>(DebitDto.class))
                                         .build()
        );
        return template.opsForHash();
    }


}
