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
@Table(name = "buyer_address")
public class BuyerAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "buyer_address_id", nullable = false)
	private int buyerAddressId;
	
	@Column(name = "user_id", nullable = false)
    private int userId;
	
	@Column(name = "recipient_name", nullable = false, length = 50)
    private String recipientName;
	
	@Column(name = "recipient_tel", nullable = false, length = 30)
    private String recipientTel;
	
	@Column(name = "recipient_addr1", nullable = false, length = 100)
    private String recipientAddr1;
	
	@Column(name = "recipient_addr2", nullable = false, length = 30)
    private String recipientAddr2;
	
	@Column(name = "recipient_zipcode", nullable = false, length = 50)
    private String recipientZipcode;
	
	@Column(name = "recipient_req", length = 100)
    private String recipientReq;

}
