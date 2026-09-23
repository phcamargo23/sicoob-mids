package com.sicoob.mids.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class MerchantIdStatusRequest {

    @NotNull(message = "O campo ativo é obrigatório")
    private Boolean ativo;

}
