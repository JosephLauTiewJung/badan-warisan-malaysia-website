package com.example.springaidemo.configurations;

import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TokenSplitter {
    @Bean("tokenTextSplitter")
    public TokenTextSplitter tokenTextSplitter() {
        return TokenTextSplitter.builder()
                .withMaxNumChunks(50)
                .build();
    }
}
