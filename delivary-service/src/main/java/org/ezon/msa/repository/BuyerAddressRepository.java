package org.ezon.msa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ezon.msa.entity.BuyerAddress;

import java.util.List;

public interface BuyerAddressRepository extends JpaRepository<BuyerAddress, Integer> {
    
    // 특정 사용자 ID로 등록한 배송지 목록 조회
    List<BuyerAddress> findByUserId(int userId);
}
