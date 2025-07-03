package org.ezon.msa.controller;

import java.util.List;

import org.ezon.msa.dto.PageResponse;
import org.ezon.msa.entity.SellerAddress;
import org.ezon.msa.service.SellerAddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/delivery/seller")
public class SellerAddressController {
	private final SellerAddressService sellerAddressService;

	public SellerAddressController(SellerAddressService sellerAddressService) {
		this.sellerAddressService = sellerAddressService;
	}

	// 주소지 등록
	// POST : http://localhost:10500/api/delivery/seller
	/* body
	 	{
		  "userId": 3,
		  "shippingName": "서울물류센터",
		  "managerName": "홍길동",
		  "managerTel": "010-1234-5678",
		  "shippingAddr1": "서울시 강남구 테헤란로 123",
		  "shippingAddr2": "3층",
		  "shippingZipcode": "06233",
		  "shippingReq": "출고 전에 연락 주세요."
		} 
	 */
    @PostMapping
    public ResponseEntity<SellerAddress> add(@RequestBody SellerAddress address) {
        return ResponseEntity.ok(sellerAddressService.save(address));
    }
   
	// 주소지 목록 조회
    // GET : http://localhost:10500/api/delivery/seller?userId=3
//    @GetMapping
//    public ResponseEntity<List<SellerAddress>> getByUserId(@RequestParam int userId) {
//        return ResponseEntity.ok(sellerAddressService.findByUserId(userId));
//    }
    
    
    @GetMapping("/list")
    public ResponseEntity<PageResponse<SellerAddress>> getAddress(@RequestParam(defaultValue = "0") int pageNum) {
    	return ResponseEntity.ok(new PageResponse<SellerAddress>(sellerAddressService.getList(pageNum)));
    }
    
    // 주소지 목록 조회(페이징)
    @GetMapping
    public ResponseEntity<PageResponse<SellerAddress>> getByUserId(
            @RequestParam int userId,
            @RequestParam(defaultValue = "0") int pageNum) {
        return ResponseEntity.ok(new PageResponse<SellerAddress>(sellerAddressService.findByUserId(pageNum, userId)));
    }
    
    // 주소지 목록 조회(전체) - 다른 서비스에서 호출 시
    @GetMapping("/all")
    public ResponseEntity<List<SellerAddress>> getByUserIdAll(@RequestParam int userId) {
    	return ResponseEntity.ok(sellerAddressService.findByUserIdAll(userId).get());
    }
    
    // 주소지 수정
    // PUT : http://localhost:10500/api/delivery/seller/1
    @PutMapping("/{id}")
    public ResponseEntity<SellerAddress> update(@PathVariable int id, @RequestBody SellerAddress address) {
        address.setSellerAddressId(id);
        return ResponseEntity.ok(sellerAddressService.update(address));
    }

    // 주소지 삭제
    // DELETE : http://localhost:10500/api/delivery/seller/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        sellerAddressService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
