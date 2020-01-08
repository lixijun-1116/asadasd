package cn.kgc.controller;

import cn.kgc.utils.RedisUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class TestController {

    @Resource
    private RedisUtils redisUtils;

    @RequestMapping("/getValue")
    @ResponseBody
    public String getValue(String key){
        String value = (String) redisUtils.get(key);
        return value;
    }

    @RequestMapping("/setValue")
    @ResponseBody
    public String set(String key,String value){
        boolean flag = redisUtils.set(key, value);
        if (flag){
            return "success";
        }
        return "fail";
    }
}
