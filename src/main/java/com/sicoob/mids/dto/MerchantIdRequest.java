package com.sicoob.mids.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class MerchantIdRequest {

    @NotNull(message = "O código sequencial do merchant é obrigatório")
    private Long cdSeqId;

    @NotBlank(message = "O código do MID é obrigatório")
    private String cdMid;

    @NotBlank(message = "O nome do merchant é obrigatório")
    private String dsName;

    @NotBlank(message = "A bandeira é obrigatória")
    private String dsBrand;

    @NotNull(message = "A data de carga é obrigatória")
    private LocalDateTime dtLoadedAt;

    private Boolean stActive;

    private LocalDateTime dtUpdatedAt;

}
