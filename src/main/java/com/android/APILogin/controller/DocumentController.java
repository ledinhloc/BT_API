package com.android.APILogin.controller;

import com.android.APILogin.entity.Document;
import com.android.APILogin.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/documents")
public class DocumentController {
    @Autowired
    DocumentService documentService;

    @GetMapping("/by-category/{categoryId}")
    public List<Document> getDocumentsByCategory(@PathVariable Long categoryId) {
        return documentService.getDocumentsByCategory(categoryId);
    }

    @GetMapping("/top-selling")
    public List<Object[]> getTopSellingDocuments() {
        return documentService.getTopSellingDocuments();
    }

    @GetMapping("/recent")
    public List<Document> getRecentDocuments() {
        return documentService.getRecentDocuments();
    }
}
