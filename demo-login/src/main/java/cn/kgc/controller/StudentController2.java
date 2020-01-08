package cn.kgc.controller;

import cn.kgc.dao.StudentDao;
import cn.kgc.entity.Message;
import cn.kgc.entity.Student;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Api(tags = "这是xxx组中xxx写的类")
public class StudentController2 {

    @Resource
    private StudentDao studentDao;

    @ApiOperation(value = "输入学号和密码验证信息",notes = "正确返回学生数据，错误就返回字符串")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sid",value = "sid",dataType = "String",example = "22"),
            @ApiImplicitParam(name = "pwd",value = "pwd",dataType = "String",example = "111111")
    })
    @ApiResponses({
            @ApiResponse(code = 123,message = "登录信息有误"),
            @ApiResponse(code = 200,message = "成功")
    })
    @PostMapping(value = "denglu")
    public Message login(@RequestParam("sid") Integer sid,@RequestParam("pwd") String pwd){
        Student student = studentDao.getStu(sid,pwd);
        Message message = new Message();
        if (student == null){
            message.setCode("123");
            message.setMsg("登录信息有误");
        }else{
            message.setCode("200");
            message.setMsg(JSON.toJSONString(student));
        }
        return message;
    }
}
