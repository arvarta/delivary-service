package org.ezon.msa.entity;

import java.time.LocalDateTime;

import org.ezon.msa.enums.DeliveryStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "delivery")
public class Delivery {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "delivery_id")
	private int deliveryId;
	
	@Column(name = "order_item_id", nullable = false)
    private int orderItemId;
	
	@Column(name = "seller_address_id", nullable = false)
    private int sellerAddressId;
	
	@Column(name = "buyer_address_id", nullable = false)
    private int buyerAddressId;
	
	@Column(name = "product_id", nullable = false)
    private int productId;
	
	@Column(name = "tracking_num", nullable = false, length = 30)
    private String trackingNum;
	
	@Column(name = "status", nullable = false, length = 20)
	@Enumerated(EnumType.STRING)
    private DeliveryStatus status;
	
	@Column(name = "shipping_at", nullable = false)
    private LocalDateTime shippingAt;
	
	@Column(name = "delivery_at")
    private LocalDateTime deliveryAt;
	
	@Column(name = "courier_name", nullable = false)
    private String courierName;
	
	@Column(name = "estimated_delivery_date", nullable = false)
    private LocalDateTime estimatedDeliveryDate;
	
	@Column(name = "shipping_fee", nullable = false)
    private int shippingFee;
	
	@Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
}
