package org.ezon.msa.service;

import org.ezon.msa.dto.BuyerAddressRequestDto;
import org.ezon.msa.entity.BuyerAddress;
import org.ezon.msa.repository.BuyerAddressRepository;
import org.springframework.stereotype.Service;

@Service
public class BuyerAddressService {

    private final BuyerAddressRepository buyerAddressRepository;

    public BuyerAddressService(BuyerAddressRepository buyerAddressRepository) {
        this.buyerAddressRepository = buyerAddressRepository;
    }
    
    // 배송지 등록
    public BuyerAddress addAddress(BuyerAddressRequestDto req) {
        BuyerAddress address = BuyerAddress.builder()
                .userId(req.getUserId())
                .recipientName(req.getRecipientName())
                .recipientTel(req.getRecipientTel())
                .recipientAddr1(req.getRecipientAddr1())
                .recipientAddr2(req.getRecipientAddr2())
                .recipientZipcode(req.getRecipientZipcode())
                .recipientReq(req.getRecipientReq())
                .build();

        return buyerAddressRepository.save(address);
    }
    
    // 배송지 조회
    public BuyerAddress findById(int id) {
        return buyerAddressRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("배송지 ID가 존재하지 않습니다: " + id));
    }

}
