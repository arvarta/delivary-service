package org.ezon.msa.dto;

import org.ezon.msa.enums.DeliveryStatus;

import lombok.Data;

@Data
public class DeliveryStatusUpdateDto {
    private DeliveryStatus status;
}
