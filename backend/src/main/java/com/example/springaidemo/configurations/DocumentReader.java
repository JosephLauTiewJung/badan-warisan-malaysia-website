package com.example.springaidemo.configurations;

import org.springframework.ai.document.Document;
import org.springframework.ai.reader.tika.TikaDocumentReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@Configuration
public class DocumentReader {
    private final Logger logger = Logger.getLogger(DocumentReader.class.getName());
    public List<Document> readDocuments(Resource[] documents) {
        List<Document> allDocs = new ArrayList<>();
       for (Resource document: documents) {
            TikaDocumentReader tikaDocumentReader = new TikaDocumentReader(document);
           List<Document> read = tikaDocumentReader.read();
           allDocs.addAll(read);
       }
       return allDocs;
    }
}
