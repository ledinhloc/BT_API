package com.android.APILogin.service;

import com.android.APILogin.entity.Category;
import com.android.APILogin.entity.Document;
import com.android.APILogin.repository.DocumentRepository;
import com.android.APILogin.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DocumentService {
    @Autowired
    DocumentRepository documentRepository;

    @Autowired
    OrderDetailRepository orderDetailRepository;

    public List<Document> getDocumentsByCategory(Long categoryId) {
        Category category = new Category();
        category.setCategoryId(categoryId);
        return documentRepository.findByCategory(category);
    }

    public List<Object[]> getTopSellingDocuments() {
        return orderDetailRepository.findTopSellingDocuments();
    }

    public List<Document> getRecentDocuments() {
        LocalDateTime sevenDaysAgo = LocalDate.now().minusDays(7).atStartOfDay();
        return documentRepository.findRecentDocuments(sevenDaysAgo);
    }
}
