package org.ezon.msa.repository;

import org.ezon.msa.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery, Integer> { 
	
}