package org.ezon.msa.controller;

import org.ezon.msa.dto.BuyerAddressRequestDto;
import org.ezon.msa.entity.BuyerAddress;
import org.ezon.msa.service.BuyerAddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/delivery/user")
public class BuyerAddressController {

    private final BuyerAddressService buyerAddressService;

    public BuyerAddressController(BuyerAddressService buyerAddressService) {
        this.buyerAddressService = buyerAddressService;
    }
    
    // 배송지 등록
    // POST : http://localhost:10500/api/delivery/user
    /* body
	 	{
		  "buyerAddressId": 17,
		  "userId": 2,
		  "recipientName": "김수신",
		  "recipientTel": "010-9999-8888",
		  "recipientAddr1": "서울시 서초구 서초대로",
		  "recipientAddr2": "101동 101호",
		  "recipientZipcode": "06500",
		  "recipientReq": "부재 시 문 앞"
		}
    */
    @PostMapping
    public ResponseEntity<BuyerAddress> addAddress(@RequestBody BuyerAddressRequestDto req) {
        BuyerAddress saved = buyerAddressService.addAddress(req);
        return ResponseEntity.ok(saved);
    }
    
    // 배송지 조회
    // GET : http://localhost:10500/api/delivery/user/1
    @GetMapping("/{id}")
    public ResponseEntity<BuyerAddress> getById(@PathVariable int id) {
        BuyerAddress address = buyerAddressService.findById(id);
        return ResponseEntity.ok(address);
    }
}
