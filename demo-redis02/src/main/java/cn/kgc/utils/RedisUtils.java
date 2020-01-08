package cn.kgc.utils;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class RedisUtils {
    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    public boolean set(String key,Object value){

        try{
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.setValueSerializer(new StringRedisSerializer());

            ValueOperations<String, Object> vo = redisTemplate.opsForValue();
            vo.set(key,value);
            return true;

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    public boolean set(String key,Object value,long seconds){
        try{
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.setValueSerializer(new StringRedisSerializer());

            ValueOperations<String, Object> vo = redisTemplate.opsForValue();
            vo.set(key,value);
            expire(key,seconds);
            return true;

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    public boolean expire(final String key,final long expireTime){
        return redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                boolean flag = false;
                try{
                    redisTemplate.setKeySerializer(new StringRedisSerializer());
                    redisTemplate.setValueSerializer(new StringRedisSerializer());

                    byte [] a = new StringRedisSerializer().serialize(key);
                    flag = connection.expire(a,expireTime);
                }catch (Exception e){
                    e.printStackTrace();
                }
                return flag;
            }
        });
    }

    public void delete(String key){
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        redisTemplate.delete(key);
    }

    public Object get(String key){
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());

        ValueOperations<String, Object> vo = redisTemplate.opsForValue();
        return vo.get(key);
    }

    public long getExpire(String key){
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());

        return redisTemplate.getExpire(key);
    }

    public boolean exists(String key){
        try {
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.setValueSerializer(new StringRedisSerializer());

            ValueOperations<String, Object> vo = redisTemplate.opsForValue();
            Object value = vo.get(key);
            if (value == null || value == ""){
                return false;
            }else{
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(String key,Object value){
        try {
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.setValueSerializer(new StringRedisSerializer());
            ValueOperations<String, Object> vo = redisTemplate.opsForValue();
            Long expire = redisTemplate.getExpire(key);
            if (expire == null){
                return false;
            }else if (expire == 0 || expire == -2){
                return false;
            }
            vo.set(key, value);
            if(expire > 0){
                expire(key, expire);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
