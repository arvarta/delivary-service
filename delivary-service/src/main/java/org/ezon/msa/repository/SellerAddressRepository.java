package org.ezon.msa.repository;

import java.util.List;
import java.util.Optional;

import org.ezon.msa.entity.SellerAddress;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerAddressRepository extends JpaRepository<SellerAddress, Integer> {
	//List<SellerAddress> findByUserId(int userId);
	Page<SellerAddress> findByUserId(int userId, Pageable pageable);
	Optional<List<SellerAddress>> findByUserId(int userId);
}
