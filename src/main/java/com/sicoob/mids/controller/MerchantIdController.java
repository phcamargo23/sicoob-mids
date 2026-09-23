package com.sicoob.mids.controller;

import com.sicoob.mids.dto.MerchantIdRequest;
import com.sicoob.mids.dto.MerchantIdResponse;
import com.sicoob.mids.dto.MerchantIdStatusRequest;
import com.sicoob.mids.service.MerchantIdService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/mids")
public class MerchantIdController {

    private final MerchantIdService merchantIdService;

    public MerchantIdController(MerchantIdService merchantIdService) {
        this.merchantIdService = merchantIdService;
    }

    @GetMapping
    public ResponseEntity<List<MerchantIdResponse>> listarTudo() {
        return ResponseEntity.ok(merchantIdService.listarTudo());
    }

    @GetMapping("/{cdSeqId}/{dsBrand}")
    public ResponseEntity<MerchantIdResponse> buscarPorId(@PathVariable Long cdSeqId, @PathVariable String dsBrand) {
        return ResponseEntity.ok(merchantIdService.buscarPorId(cdSeqId, dsBrand));
    }

    @PostMapping
    public ResponseEntity<MerchantIdResponse> criar(@Valid @RequestBody MerchantIdRequest request) {
        MerchantIdResponse response = merchantIdService.criar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{cdSeqId}/{dsBrand}")
    public ResponseEntity<MerchantIdResponse> atualizar(@PathVariable Long cdSeqId, @PathVariable String dsBrand, @Valid @RequestBody MerchantIdRequest request) {
        return ResponseEntity.ok(merchantIdService.atualizar(cdSeqId, dsBrand, request));
    }

    @PatchMapping("/{cdSeqId}/{dsBrand}/status")
    public ResponseEntity<MerchantIdResponse> atualizarSituacaoAtivo(@PathVariable Long cdSeqId, @PathVariable String dsBrand, @Valid @RequestBody MerchantIdStatusRequest request) {
        return ResponseEntity.ok(merchantIdService.atualizarSituacaoAtivo(cdSeqId, dsBrand, request));
    }

    @DeleteMapping("/{cdSeqId}/{dsBrand}")
    public ResponseEntity<Void> deletar(@PathVariable Long cdSeqId, @PathVariable String dsBrand) {
        merchantIdService.deletar(cdSeqId, dsBrand);
        return ResponseEntity.noContent().build();
    }

}