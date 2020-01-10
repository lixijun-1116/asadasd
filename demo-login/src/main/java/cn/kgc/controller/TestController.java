package cn.kgc.controller;

import cn.kgc.service.WebSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @Autowired
    private WebSocket webSocket;

    @RequestMapping("/ws")
    public void ws(){
        webSocket.onMessage("aaaaaaaaaaaaaaaaaaa");
    }
}
