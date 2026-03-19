package com.example.analysisagent.service;

import com.example.analysisagent.controller.dto.TextRequest;
import com.example.analysisagent.controller.dto.TextResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class AiExtractService {

    private final ChatClient chatClient;
    private final ObjectMapper objectMapper;

    public AiExtractService(ChatClient chatClient, ObjectMapper objectMapper) {
        this.chatClient = chatClient;
        this.objectMapper = objectMapper;
    }

    public TextResponse extract(TextRequest textRequest) {
        String prompt = """
                你是一个文本结构化抽取助手。
                请从用户输入中提取 topic、summary、sentiment。
                topic 表示这段文本的核心主题短语，不超过 10 个字。
                summary 表示这段文本的一句话摘要，长度控制在 30 到 50 字左右。
                sentiment 表示这段文本的整体情绪倾向。
                正面文本返回 POSITIVE。
                中性文本返回 NEUTRAL。
                负面文本返回 NEGATIVE。
                sentiment 只能是 POSITIVE、NEUTRAL、NEGATIVE 三个值之一。
                只返回 JSON，不要返回 markdown，不要返回额外解释，不要返回代码块。
                JSON 结构如下：
                {
                  "topic": "字符串",
                  "summary": "字符串",
                  "sentiment": "POSITIVE | NEUTRAL | NEGATIVE"
                }
                用户输入如下：
                <text>
                %s
                </text>
                """.formatted(textRequest.getText());

        String content = chatClient.prompt(prompt)
                .call()
                .content();

        try {
            return objectMapper.readValue(normalizeJsonContent(content), TextResponse.class);
        } catch (Exception e) {
            throw new IllegalStateException("模型返回内容无法解析为 TextResponse: " + content, e);
        }
    }

    private String normalizeJsonContent(String content) {
        String trimmed = content.trim();

        if (trimmed.startsWith("```json")) {
            trimmed = trimmed.substring(7).trim();
        } else if (trimmed.startsWith("```")) {
            trimmed = trimmed.substring(3).trim();
        }

        if (trimmed.endsWith("```")) {
            trimmed = trimmed.substring(0, trimmed.length() - 3).trim();
        }

        return trimmed;
    }
}
