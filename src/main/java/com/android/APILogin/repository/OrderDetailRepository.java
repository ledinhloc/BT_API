package com.android.APILogin.repository;

import com.android.APILogin.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    @Query("SELECT od.document, SUM(od.quantity) sumQuantity  FROM OrderDetail od GROUP BY od.document ORDER BY sumQuantity DESC LIMIT 10")
    List<Object[]> findTopSellingDocuments();
}
