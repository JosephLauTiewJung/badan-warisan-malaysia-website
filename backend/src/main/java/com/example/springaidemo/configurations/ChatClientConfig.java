package com.example.springaidemo.configurations;
import com.google.genai.Chat;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.ChatMemoryRepository;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.google.genai.GoogleGenAiChatModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.util.List;

@Configuration
public class ChatClientConfig {
    @Value("classpath:system-instruction.st")
    Resource systemInstruction;;
    @Bean
    public ChatClient geminiClient(GoogleGenAiChatModel googleGenAiChatModel, @Qualifier("chatMemoryRepository") ChatMemoryRepository chatMemoryRepository) {
        ChatMemory chatMemory = MessageWindowChatMemory.builder()
                .chatMemoryRepository(chatMemoryRepository)
                .maxMessages(1000)
                .build();
        MessageChatMemoryAdvisor chatMemoryAdvisor = MessageChatMemoryAdvisor
                .builder(chatMemory)
                .build();

        ChatClient.Builder builder = ChatClient
                .builder(googleGenAiChatModel)
                .defaultOptions(ChatOptions.builder().temperature(0.8).build())
                .defaultAdvisors(List.of(chatMemoryAdvisor))
                .defaultSystem(systemInstruction);
        return builder.build();
    }
}
