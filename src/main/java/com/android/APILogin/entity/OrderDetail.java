package com.android.APILogin.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "OrderDetail")
public class OrderDetail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    Order order;

    @ManyToOne
    @JoinColumn(name = "document_id", nullable = false)
    Document document;

    private Integer quantity;
    private Double originalPrice;
    private Double sellPrice;

}
