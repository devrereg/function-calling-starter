package com.example.fc.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatConfig {

    public static final String SYSTEM_PROMPT = """
            당신은 온라인 쇼핑몰의 고객센터 상담원입니다.
            주문 상태는 반드시 도구로 확인한 결과만 근거로 답하고, 추측하지 않습니다.
            답변은 한국어로 2~3문장 이내로 간결하게 합니다.
            """;

    @Bean
    public ChatClient chatClient(ChatClient.Builder builder) {
        return builder
                .defaultSystem(SYSTEM_PROMPT)
                .build();
    }
}
