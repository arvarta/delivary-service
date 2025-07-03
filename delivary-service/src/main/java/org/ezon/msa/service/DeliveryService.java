package org.ezon.msa.service;

import java.time.LocalDateTime;
import java.util.List;

import org.ezon.msa.dto.DeliveryRequestDto;
import org.ezon.msa.entity.BuyerAddress;
import org.ezon.msa.entity.Delivery;
import org.ezon.msa.enums.DeliveryStatus;
import org.ezon.msa.repository.BuyerAddressRepository;
import org.ezon.msa.repository.DeliveryRepository;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {

    private final BuyerAddressRepository buyerAddressRepository;
    private final DeliveryRepository deliveryRepository;

    public DeliveryService(BuyerAddressRepository buyerAddressRepository,
                           DeliveryRepository deliveryRepository) {
        this.buyerAddressRepository = buyerAddressRepository;
        this.deliveryRepository = deliveryRepository;
    }
    
    // 배송지 등록
    public Delivery registerDelivery(DeliveryRequestDto dto) {
        // 1 배송지(BuyerAddress) 저장
        BuyerAddress buyerAddress = BuyerAddress.builder()
                .userId(Integer.parseInt(dto.getUserId().toString()))
                .recipientName(dto.getRecipientName())
                .recipientTel(dto.getRecipientTel())
                .recipientAddr1(dto.getRecipientAddr1())
                .recipientAddr2(dto.getRecipientAddr2())
                .recipientZipcode(dto.getRecipientZipcode())
                .recipientReq(dto.getRecipientReq())
                .build();
        buyerAddress = buyerAddressRepository.save(buyerAddress);

        // 2 배송 정보 저장
        Delivery delivery = Delivery.builder()
                .orderItemId(Integer.parseInt(dto.getOrderItemId().toString()))
                .sellerAddressId(Integer.parseInt(dto.getSellerAddressId().toString()))
                .buyerAddressId(buyerAddress.getBuyerAddressId())
                .productId(Integer.parseInt(dto.getProductId().toString()))
                .trackingNum(dto.getTrackingNum())
                .courierName(dto.getCourierName())
                .status(DeliveryStatus.READY)
                .shippingAt(LocalDateTime.now())
                .estimatedDeliveryDate(dto.getEstimatedDeliveryDate())
                .shippingFee(Integer.parseInt(dto.getShippingFee().toString()))
                .createdAt(LocalDateTime.now())
                .deliveryAt(null)
                .build();

        return deliveryRepository.save(delivery);
    }
    
    // 배송 상태 변경
    public Delivery updateStatus(int deliveryId, DeliveryStatus newStatus) {
        Delivery delivery = deliveryRepository.findById(deliveryId)
                .orElseThrow(() -> new IllegalArgumentException("배송 ID가 존재하지 않습니다: " + deliveryId));
        
        delivery.setStatus(newStatus);

        if (newStatus == DeliveryStatus.DELIVERED) {
            delivery.setDeliveryAt(LocalDateTime.now());
        }

        return deliveryRepository.save(delivery);
    }

	public List<Delivery> getAll() {
		return deliveryRepository.findAll();
	}

	public int delete(Integer addressId) {
		if(addressId == null) return -1;
		Delivery temp = deliveryRepository.findById(addressId).get();
		if(temp == null) return 0;
		deliveryRepository.delete(temp);
		return 1;
	}
}
