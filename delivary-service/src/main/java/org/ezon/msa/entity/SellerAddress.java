package org.ezon.msa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "seller_address")
public class SellerAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seller_address_id", nullable = false)
	private int sellerAddressId;
	
	@Column(name = "user_id", nullable = false)
    private int userId;
	
	@Column(name = "shipping_name", nullable = false, length = 30)
    private String shippingName;
	
	@Column(name = "manager_name", nullable = false, length = 50)
    private String managerName;
	
	@Column(name = "manager_tel", nullable = false, length = 20)
    private String managerTel;
	
	@Column(name = "shipping_addr1", nullable = false, length = 100)
    private String shippingAddr1;
	
	@Column(name = "shipping_addr2", nullable = false, length = 100)
    private String shippingAddr2;
	
	@Column(name = "shipping_zipcode", nullable = false, length = 20)
    private String shippingZipcode;
	
	@Column(name = "shipping_req", length = 100)
    private String shippingReq;
}
