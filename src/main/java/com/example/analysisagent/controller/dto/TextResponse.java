package com.example.analysisagent.controller.dto;

import lombok.Data;

@Data
public class TextResponse {

    private String topic;

    private String summary;

    private String sentiment;
}
