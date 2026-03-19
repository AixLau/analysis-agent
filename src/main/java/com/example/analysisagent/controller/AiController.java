package com.example.analysisagent.controller;

import com.example.analysisagent.controller.dto.TextRequest;
import com.example.analysisagent.controller.dto.TextResponse;
import com.example.analysisagent.service.AiExtractService;
import com.example.analysisagent.service.AiPingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ai")
public class AiController {

    private final AiPingService aiPingService;
    private final AiExtractService aiExtractService;

    public AiController(AiPingService aiPingService, AiExtractService aiExtractService) {
        this.aiPingService = aiPingService;
        this.aiExtractService = aiExtractService;
    }

    @GetMapping("/ping")
    public String ping() {
        return aiPingService.ping();
    }

    @PostMapping("/extract")
    public TextResponse extract(@RequestBody TextRequest textRequest) {
        return aiExtractService.extract(textRequest);
    }
}
