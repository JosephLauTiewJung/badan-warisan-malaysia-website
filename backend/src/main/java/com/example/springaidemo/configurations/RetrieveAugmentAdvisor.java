package com.example.springaidemo.configurations;

import org.springframework.ai.chat.client.advisor.api.Advisor;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.rag.advisor.RetrievalAugmentationAdvisor;
import org.springframework.ai.rag.generation.augmentation.ContextualQueryAugmenter;
import org.springframework.ai.rag.retrieval.search.VectorStoreDocumentRetriever;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RetrieveAugmentAdvisor {
    private final VectorStore vectorStore;
    public RetrieveAugmentAdvisor(VectorStore vectorStore) {
        this.vectorStore = vectorStore;
    }

    @Bean
    public Advisor retrievalAugmentationAdvisor() {
        return RetrievalAugmentationAdvisor.builder()
                .documentRetriever(VectorStoreDocumentRetriever.builder()
                        .similarityThreshold(0.3)
                        .vectorStore(vectorStore)
                        .build())
                .queryAugmenter(ContextualQueryAugmenter.builder()
                        .promptTemplate(new PromptTemplate("""
                            Context information is below.
                            ---------------------
                            {context}
                            ---------------------
                            Given the context and your own general knowledge, answer the question.
                            If the answer is not in the context, use your own data to be helpful!
                            
                            User Question: {query}
                            """))
                        .build())
                .build();
    }

}
