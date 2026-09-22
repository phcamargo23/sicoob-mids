package com.sicoob.mids.repository;

import com.sicoob.mids.model.MerchantId;
import com.sicoob.mids.model.MerchantIdPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantIdRepository extends JpaRepository<MerchantId, MerchantIdPK> {
}
