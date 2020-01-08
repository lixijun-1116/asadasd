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
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * set一个键值对
     * @param key 键
     * @param value 值
     * @return Boolean（true false）
     */
    public boolean set(String key , Object value){
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

    /**
     * set一个带有存在时间的键值
     * @param key 键
     * @param value 值
     * @param seconds 存在时间
     * @return Boolean（true false）
     */
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

    /**
     * 修改键的时间
     * @param key 键
     * @param expireTime 值
     * @return Boolean（true false）
     */
    public boolean expire(final String key,final long expireTime){
        return redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                boolean flag = false;
                try{
                    redisTemplate.setKeySerializer(new StringRedisSerializer());
                    redisTemplate.setValueSerializer(new StringRedisSerializer());

                    byte [] keys = new StringRedisSerializer().serialize(key);
                    flag = connection.expire(keys,expireTime);
                }catch (Exception e){
                    e.printStackTrace();
                }
                return flag;
            }
        });

    }

    /**
     * 获得这个键的存在时间
     * @param key 键
     * @return 所剩的时间
     */
    public long getExpire(String key){
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());

        ValueOperations<String, Object> vo = redisTemplate.opsForValue();
       return redisTemplate.getExpire(key);
    }



    /**
     * 通过键get值
     * @param key 键
     * @return value
     */
    public Object get(String key){
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        ValueOperations<String, Object> vo = redisTemplate.opsForValue();
        return vo.get(key);
    }


    /**
     * 删除键值对
     * @param key 键
     */
    public void delete(String key){
        try{
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.delete(key);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    /**
     * 判断是否有该键
     * @param key 键
     * @return Boolean（true false）
     */
    public boolean exists(String key){
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        ValueOperations<String, Object> vo = redisTemplate.opsForValue();
        Object value = vo.get(key);
        if(value == null || value == ""){
            return false;
        }else{
            return true;
        }
    }

    /**
     * 修改键的值（如果有存在时间 ，保持不变）
     * @param key 键
     * @param value 值
     * @return Boolean（true false）
     */
    public boolean update(String key , String value){
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());

        ValueOperations<String, Object> vo = redisTemplate.opsForValue();
        Long expire = redisTemplate.getExpire(key);
        if (expire == null){
            return false;
        }else if (expire == 0 || expire == -2){
            return false;
        }
        vo.set(key,value);
        if (expire > 0){
            expire(key,expire);
        }
        return true;
    }
}
