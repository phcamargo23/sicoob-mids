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
        name = "merchantId",
        schema = "MIDS",
        uniqueConstraints = @UniqueConstraint(name = "ak_tb_merchant_id", columnNames = {"cd_mid", "ds_brand"})
)
@IdClass(MerchantIdPK.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MerchantId {

    @Id
    @Column(name = "cd_seq_id", nullable = false)
    private Long cdSeqId;

    @Column(name = "cd_mid", length = 50, nullable = false)
    private String cdMid;

    @Column(name = "ds_name", length = 100, nullable = false)
    private String dsName;

    @Id
    @Column(name = "ds_brand", length = 50, nullable = false)
    private String dsBrand;

    @Column(name = "dt_loaded_at", nullable = false)
    private LocalDateTime dtLoadedAt;

    @Column(name = "st_active", nullable = false)
    private boolean stActive;

    @Column(name = "dt_updated_at")
    private LocalDateTime dtUpdatedAt;

}
