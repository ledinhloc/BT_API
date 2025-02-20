package com.android.APILogin.repository;

import com.android.APILogin.entity.Category;
import com.android.APILogin.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface DocumentRepository extends JpaRepository<Document, Long> {
    List<Document> findByCategory(Category category);

    @Query("SELECT d FROM Document d WHERE d.createdAt >= :sevenDaysAgo ORDER BY d.createdAt DESC")
    List<Document> findRecentDocuments(@Param("sevenDaysAgo") LocalDateTime sevenDaysAgo);
}
