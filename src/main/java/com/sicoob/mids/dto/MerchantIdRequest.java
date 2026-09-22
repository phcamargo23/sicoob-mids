package com.sicoob.mids.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class MerchantIdRequest {

    @NotNull(message = "O código sequencial do merchant é obrigatório")
    private Long cdSeqMerchantId;

    @NotBlank(message = "O nome do merchant é obrigatório")
    private String dsMerchantName;

    @NotBlank(message = "O MID é obrigatório")
    private String cdMid;

    @NotBlank(message = "A bandeira (flag) é obrigatória")
    private String dsFlag;

    @NotNull(message = "A data de carga é obrigatória")
    private LocalDateTime dtLoad;

    private Integer bolSituation;

    private LocalDateTime dtChange;

}
