package com.example.analysisagent.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class AiPingService {

    private final ChatClient chatClient;

    public AiPingService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public String ping() {
        return chatClient.prompt("请回复：AI连接成功")
                .call()
                .content();
    }
}
