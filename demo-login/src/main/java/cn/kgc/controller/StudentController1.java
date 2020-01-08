package cn.kgc.controller;

import cn.kgc.dao.StudentDao;
import cn.kgc.entity.Result;
import cn.kgc.entity.Student;
import cn.kgc.utils.MD5;
import cn.kgc.utils.RedisUtils;
import cn.kgc.utils.UserAgentUtils;
import com.alibaba.fastjson.JSON;
import cz.mallat.uasparser.UserAgentInfo;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Controller
public class StudentController1 {

    @Resource
    private StudentDao studentDao;

    @Resource
    private RedisUtils redisUtils;

    @RequestMapping(value = "/login")
    public Result loginByPwd(Student student , HttpServletRequest request) throws IOException {
        String header = request.getHeader("User-Agent");
        UserAgentInfo userAgentInfo = UserAgentUtils.uaSparser.parse(header);
        String type=userAgentInfo.getDeviceType();

        Object[] loginResult=this.login(student,type);
        Result result=new Result();
        if (loginResult==null){
            result.setCode(2001);
            result.setMessage("登录失败");
        }else{
            result.setCode(1001);
            result.setMessage("登录成功");
            result.setData(JSON.toJSONString(loginResult));
        }
        return result;
    }


    public Object[] login(Student student,String type){
        Student stu = studentDao.getStu(student.getSid(), student.getPwd());
        if (stu == null){
            return null;
        }
        //生成token
        String token = createToken(stu, type);

        this.saveToken(token,stu);
        return new Object[]{stu,token};

    }

    //token
    public String createToken(Student student,String type){
        StringBuilder builder = new StringBuilder();
        builder.append("token-");
        builder.append(type + "-");
        String md5 = MD5.getMD5(student.getSid().toString(), 32);
        builder.append(md5 + "-");
        builder.append(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        builder.append(UUID.randomUUID().toString().substring(0,6));
        return builder.toString();

    }
    //保存token
    public void saveToken(String token,Student student){
        String tokenKey = "stu" + student.getSid();
        String tokenValue = null;
        if ((tokenValue=(String)redisUtils.get(tokenKey))!=null){
            redisUtils.delete(tokenKey);
            redisUtils.delete(tokenValue);
        }
        redisUtils.set(tokenKey,token,30000);
        redisUtils.set(token, JSON.toJSONString(student),30000);
    }
}
