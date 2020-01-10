package com.example.demowebsocket.controller;

import com.example.demowebsocket.service.WebSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class TestController {

    @Resource
    private WebSocket webSocket;

    @RequestMapping("/ws")
    public void ws(){
        webSocket.onMessage("aaaaaaaaaaaaaaaaaaa");
    }
}
