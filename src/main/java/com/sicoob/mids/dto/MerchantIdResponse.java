package com.sicoob.mids.dto;

import com.sicoob.mids.model.MerchantId;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class MerchantIdResponse {

    private Long cdSeqMerchantId;
    private String dsMerchantName;
    private String cdMid;
    private String dsFlag;
    private LocalDateTime dtLoad;
    private Integer bolSituation;
    private LocalDateTime dtChange;

    public static MerchantIdResponse fromEntity(MerchantId merchantId) {
        return new MerchantIdResponse(
                merchantId.getCdSeqMerchantId(),
                merchantId.getDsMerchantName(),
                merchantId.getCdMid(),
                merchantId.getDsFlag(),
                merchantId.getDtLoad(),
                merchantId.getBolSituation(),
                merchantId.getDtChange()
        );
    }

}
