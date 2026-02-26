package com.example.springaidemo.configurations;

import org.springframework.ai.document.Document;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@Configuration
public class ProjectConfig {
    private final Logger logger = Logger.getLogger(ProjectConfig.class.getName());
    private final DocumentReader documentReader;
    private final VectorStore vectorStore;
    private final TokenTextSplitter tokenTextSplitter;
    private final ResourcePatternResolver resourcePatternResolver;
    private Resource[] documents;

    @Autowired
    public ProjectConfig(DocumentReader documentReader,
                         VectorStore vectorStore,
                         TokenTextSplitter tokenTextSplitter,
                         ResourcePatternResolver resourcePatternResolver) {
        this.documentReader = documentReader;
        this.vectorStore = vectorStore;
        this.tokenTextSplitter = tokenTextSplitter;
        this.resourcePatternResolver = resourcePatternResolver;
        try {
            this.documents = resourcePatternResolver.getResources("classpath*:static/documents/*");
        } catch (Exception e) {
            logger.warning("Could not load document resources: " + e.getMessage());
            this.documents = new Resource[0];
        }
    }

    @PostConstruct
    public void createVectorStore()  {
        try {
            if (documents.length == 0) {
                logger.warning("No document resources found in static/documents. Vector store will not be initialized.");
                return;
            }
            List<Document> allDocs = documentReader.readDocuments(this.documents);
            logger.info("allDocs: " + allDocs.toString());
            logger.info("documents: " + Arrays.toString(documents));
            vectorStore.add(tokenTextSplitter.apply(allDocs));
            logger.info("Vector store initialized with " + allDocs.size() + " documents.");
        }
        catch (Exception e) {
            logger.severe("Error initializing vector store: " + e.getMessage());
        }
    }
}
