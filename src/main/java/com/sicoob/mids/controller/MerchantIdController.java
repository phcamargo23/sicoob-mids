package com.sicoob.mids.controller;

import com.sicoob.mids.dto.MerchantIdRequest;
import com.sicoob.mids.dto.MerchantIdResponse;
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
    public ResponseEntity<List<MerchantIdResponse>> listarTodos() {
        return ResponseEntity.ok(merchantIdService.listarTodos());
    }

    @GetMapping("/{cdSeqMerchantId}/{dsFlag}")
    public ResponseEntity<MerchantIdResponse> buscarPorId(@PathVariable Long cdSeqMerchantId, @PathVariable String dsFlag) {
        return ResponseEntity.ok(merchantIdService.buscarPorId(cdSeqMerchantId, dsFlag));
    }

    @PostMapping
    public ResponseEntity<MerchantIdResponse> criar(@Valid @RequestBody MerchantIdRequest request) {
        MerchantIdResponse response = merchantIdService.criar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{cdSeqMerchantId}/{dsFlag}")
    public ResponseEntity<MerchantIdResponse> atualizar(@PathVariable Long cdSeqMerchantId, @PathVariable String dsFlag,
                                                         @Valid @RequestBody MerchantIdRequest request) {
        return ResponseEntity.ok(merchantIdService.atualizar(cdSeqMerchantId, dsFlag, request));
    }

    @DeleteMapping("/{cdSeqMerchantId}/{dsFlag}")
    public ResponseEntity<Void> deletar(@PathVariable Long cdSeqMerchantId, @PathVariable String dsFlag) {
        merchantIdService.deletar(cdSeqMerchantId, dsFlag);
        return ResponseEntity.noContent().build();
    }

}
