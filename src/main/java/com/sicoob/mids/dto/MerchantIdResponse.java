package com.sicoob.mids.dto;

import com.sicoob.mids.model.MerchantId;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class MerchantIdResponse {

    private Long cdSeqId;
    private String cdMid;
    private String dsName;
    private String dsBrand;
    private LocalDateTime dtLoadedAt;
    private boolean stActive;
    private LocalDateTime dtUpdatedAt;

    public static MerchantIdResponse fromEntity(MerchantId merchantId) {
        return new MerchantIdResponse(
                merchantId.getCdSeqId(),
                merchantId.getCdMid(),
                merchantId.getDsName(),
                merchantId.getDsBrand(),
                merchantId.getDtLoadedAt(),
                merchantId.isStActive(),
                merchantId.getDtUpdatedAt()
        );
    }

}
