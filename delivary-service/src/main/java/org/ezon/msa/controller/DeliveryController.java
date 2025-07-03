package org.ezon.msa.controller;

import java.util.List;

import org.ezon.msa.dto.DeliveryRequestDto;
import org.ezon.msa.dto.DeliveryStatusUpdateDto;
import org.ezon.msa.entity.Delivery;
import org.ezon.msa.service.DeliveryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/delivery")
public class DeliveryController {

    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }
    
    // 주문 시 배송 등록
    // POST : http://localhost:10500/api/delivery
    /* body
       {
		  "userId": 2,
		  "recipientName": "김수신",
		  "recipientTel": "010-8888-7777",
		  "recipientAddr1": "부산 해운대구 우동",
		  "recipientAddr2": "101동 101호",
		  "recipientZipcode": "48050",
		  "recipientReq": "부재 시 경비실",
		
		  "orderItemId": 10,
		  "sellerAddressId": 1,
		  "productId": 100,
		  "trackingNum": "123456789",
		  "courierName": "CJ대한통운",
		  "estimatedDeliveryDate": "2025-06-20T00:00:00",
		  "shippingFee": 3000
		}
     */
    @PostMapping
    public ResponseEntity<Delivery> createDelivery(@RequestBody DeliveryRequestDto dto) {
        Delivery saved = deliveryService.registerDelivery(dto);
        return ResponseEntity.ok(saved);
    }
    
    @DeleteMapping("/user/{addressId}")
    public ResponseEntity<Void> deleteDelivery(@PathVariable Integer addressId) {
    	int process = deliveryService.delete(addressId);
    	switch(process) {
    	case -1: return ResponseEntity.badRequest().body(null);
    	case 0: return ResponseEntity.internalServerError().body(null);
    	}
    	return ResponseEntity.ok(null);
    }
    
    // 배송 상태 변경
    // PUT : http://localhost:10500/api/delivery/1/status
    /* body
    	{
		  "status": "DELIVERED"
		}
     */
    @PutMapping("/{deliveryId}/status")
    public ResponseEntity<Delivery> updateStatus(
            @PathVariable int deliveryId,
            @RequestBody DeliveryStatusUpdateDto dto) {

        Delivery updated = deliveryService.updateStatus(deliveryId, dto.getStatus());
        return ResponseEntity.ok(updated);
    }
    
    @GetMapping
    public ResponseEntity<List<Delivery>> findByAll(){
        return ResponseEntity.ok(deliveryService.getAll());
    }
}

