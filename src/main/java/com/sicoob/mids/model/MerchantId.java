package com.sicoob.mids.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "tb_merchant_id",
        schema = "CEIBO",
        uniqueConstraints = @UniqueConstraint(name = "ak_tb_merchant_id", columnNames = {"cd_mid", "ds_flag"})
)
@IdClass(MerchantIdPK.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MerchantId {

    @Id
    @Column(name = "cd_seq_merchant_id", nullable = false)
    private Long cdSeqMerchantId;

    @Column(name = "ds_merchant_name", length = 100, nullable = false)
    private String dsMerchantName;

    @Column(name = "cd_mid", length = 50, nullable = false)
    private String cdMid;

    @Id
    @Column(name = "ds_flag", length = 50, nullable = false)
    private String dsFlag;

    @Column(name = "dt_load", nullable = false)
    private LocalDateTime dtLoad;

    @Column(name = "bolsituation", nullable = false)
    private Integer bolSituation;

    @Column(name = "dt_change")
    private LocalDateTime dtChange;

}
