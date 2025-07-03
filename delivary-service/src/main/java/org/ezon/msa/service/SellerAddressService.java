package org.ezon.msa.service;

import java.util.List;
import java.util.Optional;

import org.ezon.msa.entity.SellerAddress;
import org.ezon.msa.repository.SellerAddressRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class SellerAddressService {
	
	@Value("${delivery.pageSize}")
	private int pageSize;
	
	private SellerAddressRepository sellerAddressRepository;
	
	public SellerAddressService(SellerAddressRepository sellerAddressRepository) {
		this.sellerAddressRepository = sellerAddressRepository;
	}

	// 주소지 등록
	public SellerAddress save(SellerAddress address) {
		return sellerAddressRepository.save(address);
	}
	
	// 주소지 조회
//    public List<SellerAddress> findByUserId(int userId) {
//        return sellerAddressRepository.findByUserId(userId);
//    }
	
	// 리스트 가져오기
	public Page<SellerAddress> getList(int pageNum) {
		Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.Direction.DESC, "userId");
		return sellerAddressRepository.findAll(pageable);
	}
	
	// 주소지 조회(페이징)
	public Page<SellerAddress> findByUserId(int pageNum, int userId) {
		Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.by(Sort.Direction.ASC, "userId"));
		return  sellerAddressRepository.findByUserId(userId, pageable);
	}
	
	// 주소지 조회(전체)
	public Optional<List<SellerAddress>> findByUserIdAll(int userId) {
		return sellerAddressRepository.findByUserId(userId);
	}

    // 주소지 수정
    public SellerAddress update(SellerAddress address) {
        return sellerAddressRepository.save(address);
    }

    // 주소지 삭제
    public void delete(int id) {
        sellerAddressRepository.deleteById(id);
    }
	
}
