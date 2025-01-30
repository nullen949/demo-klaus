package com.nullen.demo.ws.controller;

import com.nullen.demo.ws.WebSocketManager;
import com.nullen.demo.ws.server.DemoWebSocketServer;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Nullen
 */
@RestController
public class WSController {
    @Resource
    private DemoWebSocketServer demoWebSocketServer;

    @SendTo
    @MessageMapping("/send")
    @RequestMapping("/api/ws/send-all")
    public String sendMsg(String msg) {
        WebSocketManager.sendAllMessage(msg);
        return "接收到消息: " + msg;
    }


}
