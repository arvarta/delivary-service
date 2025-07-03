package org.ezon.msa.dto;

import lombok.Data;

@Data
public class BuyerAddressRequestDto {
    private int userId;
    private String recipientName;
    private String recipientTel;
    private String recipientAddr1;
    private String recipientAddr2;
    private String recipientZipcode;
    private String recipientReq;
}
