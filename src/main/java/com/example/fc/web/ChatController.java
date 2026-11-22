package com.example.fc.web;

import com.example.fc.tool.OrderTools;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ChatController {

    private final ChatClient chatClient;
    private final OrderTools orderTools;

    public ChatController(ChatClient chatClient, OrderTools orderTools) {
        this.chatClient = chatClient;
        this.orderTools = orderTools;
    }

 
    @GetMapping("/chat")
    public String chat(@RequestParam @NonNull String message) {
        return chatClient.prompt()
            .user(message)
            .call()
            .content();
    }
}
