package com.example.springaidemo.controllers;

import com.example.springaidemo.models.ResponseModel;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.api.Advisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class ChatController {

    private final ChatClient geminiClient;
    private final Advisor retrieveAugmentAdvisor;
    public ChatController(ChatClient geminiClient, @Qualifier("retrievalAugmentationAdvisor") Advisor retrieveAugmentAdvisor) {
        this.geminiClient = geminiClient;
        this.retrieveAugmentAdvisor = retrieveAugmentAdvisor;
    }


    @GetMapping("/chat")
    public ResponseModel getGeminiMessage(@RequestParam("message") String message,
                                          @RequestHeader("username") String username) {
        return geminiClient
                .prompt(message)
                .advisors(advisorSpec -> {
                    advisorSpec.param(ChatMemory.CONVERSATION_ID, username);
                    advisorSpec.advisors(retrieveAugmentAdvisor);
                })
                .call()
                .entity(ResponseModel.class);
    }
}
