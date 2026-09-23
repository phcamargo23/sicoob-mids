package com.sicoob.mids.service;

import com.sicoob.mids.dto.MerchantIdRequest;
import com.sicoob.mids.dto.MerchantIdResponse;
import com.sicoob.mids.dto.MerchantIdStatusRequest;
import com.sicoob.mids.exception.ResourceNotFoundException;
import com.sicoob.mids.model.MerchantId;
import com.sicoob.mids.model.MerchantIdPK;
import com.sicoob.mids.repository.MerchantIdRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MerchantIdService {

    private final MerchantIdRepository merchantIdRepository;

    public MerchantIdService(MerchantIdRepository merchantIdRepository) {
        this.merchantIdRepository = merchantIdRepository;
    }

    public List<MerchantIdResponse> listarTudo() {
        return merchantIdRepository.findAll().stream()
                .map(MerchantIdResponse::fromEntity)
                .collect(Collectors.toList());
    }

    public MerchantIdResponse buscarPorId(Long cdSeqId, String dsBrand) {
        return MerchantIdResponse.fromEntity(buscarEntidadePorId(cdSeqId, dsBrand));
    }

    public MerchantIdResponse criar(MerchantIdRequest request) {
        MerchantId merchantId = new MerchantId();
        merchantId.setCdSeqId(request.getCdSeqId());
        merchantId.setCdMid(request.getCdMid());
        merchantId.setDsName(request.getDsName());
        merchantId.setDsBrand(request.getDsBrand());
        merchantId.setDtLoadedAt(request.getDtLoadedAt());
        merchantId.setStActive(request.getStActive() != null ? request.getStActive() : true);
        merchantId.setDtUpdatedAt(request.getDtUpdatedAt());
        return MerchantIdResponse.fromEntity(merchantIdRepository.save(merchantId));
    }

    public MerchantIdResponse atualizar(Long cdSeqId, String dsBrand, MerchantIdRequest request) {
        MerchantId merchantId = buscarEntidadePorId(cdSeqId, dsBrand);
        merchantId.setCdMid(request.getCdMid());
        merchantId.setDsName(request.getDsName());
        merchantId.setDtLoadedAt(request.getDtLoadedAt());
        merchantId.setStActive(request.getStActive() != null ? request.getStActive() : merchantId.isStActive());
        merchantId.setDtUpdatedAt(request.getDtUpdatedAt());
        return MerchantIdResponse.fromEntity(merchantIdRepository.save(merchantId));
    }

    public MerchantIdResponse atualizarSituacaoAtivo(Long cdSeqId, String dsBrand, MerchantIdStatusRequest request) {
        MerchantId merchantId = buscarEntidadePorId(cdSeqId, dsBrand);
        merchantId.setStActive(request.getAtivo());
        merchantId.setDtUpdatedAt(LocalDateTime.now());
        return MerchantIdResponse.fromEntity(merchantIdRepository.save(merchantId));
    }

    public void deletar(Long cdSeqId, String dsBrand) {
        MerchantId merchantId = buscarEntidadePorId(cdSeqId, dsBrand);
        merchantIdRepository.delete(merchantId);
    }

    private MerchantId buscarEntidadePorId(Long cdSeqId, String dsBrand) {
        MerchantIdPK id = new MerchantIdPK(cdSeqId, dsBrand);
        return merchantIdRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Merchant ID não encontrado para cdSeqId=" + cdSeqId + " e dsBrand=" + dsBrand));
    }

}
