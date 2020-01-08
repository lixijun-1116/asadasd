package cn.kgc.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.context.annotation.Configuration;

@ApiModel(description = "这是返回的对象")
public class Message {

    @ApiModelProperty(value = "这是状态码")
    private String code;

    @ApiModelProperty(value = "这是携带的信息")
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
