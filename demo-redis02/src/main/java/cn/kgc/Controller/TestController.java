package cn.kgc.Controller;

import cn.kgc.utils.RedisUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class TestController {

    @Resource
    private RedisUtils redisUtils;



    @ResponseBody
    @RequestMapping("/getValue")
    public String getValue(String k){
        String value = (String)redisUtils.get(k);

        return value;
    }

    @ResponseBody
    @RequestMapping("/set")
    public String set(String k,String v){
        boolean b = redisUtils.set(k, v);
        if (b){
            return "success";
        }

        return "failed";
    }

    @ResponseBody
    @RequestMapping("/setTime")
    public String set(String k,String v,long t){
        boolean b = redisUtils.set(k, v, t);
        if (b){
            return "success";
        }

        return "failed";
    }


    @ResponseBody
    @RequestMapping("/update")
    public String update(String k,String v){
        boolean update = redisUtils.update(k, v);
        if (update){
            return "success";
        }
        return "failed";
    }
    @ResponseBody
    @RequestMapping("/expire")
    public String expire(String k,long t){
        boolean b = redisUtils.expire(k, t);
        if (b){
            return "success";
        }
        return "failed";
    }


    @ResponseBody
    @RequestMapping("/getExpire")
    public long getExpire(String k){
        long expire = redisUtils.getExpire(k);
        return expire;
    }
    @ResponseBody
    @RequestMapping("/delete")
    public void delete(String k){
        redisUtils.delete(k);
    }

    @ResponseBody
    @RequestMapping("/exists")
    public String exists(String k){
        boolean b = redisUtils.exists(k);
        if (b){
            return "success";
        }
        return "failed";
    }

}
