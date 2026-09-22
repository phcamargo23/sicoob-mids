package com.sicoob.mids.service;

import com.sicoob.mids.dto.MerchantIdRequest;
import com.sicoob.mids.dto.MerchantIdResponse;
import com.sicoob.mids.exception.ResourceNotFoundException;
import com.sicoob.mids.model.MerchantId;
import com.sicoob.mids.model.MerchantIdPK;
import com.sicoob.mids.repository.MerchantIdRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MerchantIdService {

    private final MerchantIdRepository merchantIdRepository;

    public MerchantIdService(MerchantIdRepository merchantIdRepository) {
        this.merchantIdRepository = merchantIdRepository;
    }

    public List<MerchantIdResponse> listarTodos() {
        return merchantIdRepository.findAll().stream()
                .map(MerchantIdResponse::fromEntity)
                .collect(Collectors.toList());
    }

    public MerchantIdResponse buscarPorId(Long cdSeqMerchantId, String dsFlag) {
        return MerchantIdResponse.fromEntity(buscarEntidadePorId(cdSeqMerchantId, dsFlag));
    }

    public MerchantIdResponse criar(MerchantIdRequest request) {
        MerchantId merchantId = new MerchantId();
        merchantId.setCdSeqMerchantId(request.getCdSeqMerchantId());
        merchantId.setDsMerchantName(request.getDsMerchantName());
        merchantId.setCdMid(request.getCdMid());
        merchantId.setDsFlag(request.getDsFlag());
        merchantId.setDtLoad(request.getDtLoad());
        merchantId.setBolSituation(request.getBolSituation() != null ? request.getBolSituation() : 1);
        merchantId.setDtChange(request.getDtChange());
        return MerchantIdResponse.fromEntity(merchantIdRepository.save(merchantId));
    }

    public MerchantIdResponse atualizar(Long cdSeqMerchantId, String dsFlag, MerchantIdRequest request) {
        MerchantId merchantId = buscarEntidadePorId(cdSeqMerchantId, dsFlag);
        merchantId.setDsMerchantName(request.getDsMerchantName());
        merchantId.setCdMid(request.getCdMid());
        merchantId.setDtLoad(request.getDtLoad());
        merchantId.setBolSituation(request.getBolSituation() != null ? request.getBolSituation() : merchantId.getBolSituation());
        merchantId.setDtChange(request.getDtChange());
        return MerchantIdResponse.fromEntity(merchantIdRepository.save(merchantId));
    }

    public void deletar(Long cdSeqMerchantId, String dsFlag) {
        MerchantId merchantId = buscarEntidadePorId(cdSeqMerchantId, dsFlag);
        merchantIdRepository.delete(merchantId);
    }

    private MerchantId buscarEntidadePorId(Long cdSeqMerchantId, String dsFlag) {
        MerchantIdPK id = new MerchantIdPK(cdSeqMerchantId, dsFlag);
        return merchantIdRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Merchant ID não encontrado para cdSeqMerchantId=" + cdSeqMerchantId + " e dsFlag=" + dsFlag));
    }

}
