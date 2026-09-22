package com.sicoob.mids.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class MerchantIdPK implements Serializable {

    private Long cdSeqMerchantId;
    private String dsFlag;

}
