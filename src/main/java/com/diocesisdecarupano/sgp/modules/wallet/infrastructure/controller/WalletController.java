package com.diocesisdecarupano.sgp.modules.wallet.infrastructure.controller;

import com.diocesisdecarupano.sgp.modules.wallet.application.dto.WalletRequestDTO;
import com.diocesisdecarupano.sgp.modules.wallet.application.dto.WalletResponseDTO;
import com.diocesisdecarupano.sgp.modules.wallet.application.usecase.CreateWalletUseCase;
import com.diocesisdecarupano.sgp.modules.wallet.application.usecase.ListWalletsUseCase;
import com.diocesisdecarupano.sgp.modules.wallet.application.usecase.GetWalletUseCase;
import com.diocesisdecarupano.sgp.modules.wallet.application.usecase.UpdateWalletUseCase;
import com.diocesisdecarupano.sgp.modules.wallet.application.usecase.DeleteWalletUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wallets")
public class WalletController {
    private final CreateWalletUseCase createUc;
    private final ListWalletsUseCase listUc;
    private final GetWalletUseCase getUc;
    private final UpdateWalletUseCase updateUc;
    private final DeleteWalletUseCase deleteUc;

    public WalletController(
            CreateWalletUseCase createUc,
            ListWalletsUseCase listUc,
            GetWalletUseCase getUc,
            UpdateWalletUseCase updateUc,
            DeleteWalletUseCase deleteUc) {
        this.createUc = createUc;
        this.listUc = listUc;
        this.getUc = getUc;
        this.updateUc = updateUc;
        this.deleteUc = deleteUc;
    }

    @PostMapping
    public ResponseEntity<WalletResponseDTO> create(
            @AuthenticationPrincipal User principal,
            @RequestBody @Validated WalletRequestDTO request) {
        // El email se obtiene de principal.getUsername()
        String email = principal.getUsername();
        WalletResponseDTO dto = createUc.execute(email, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @GetMapping
    public ResponseEntity<List<WalletResponseDTO>> list(
            @AuthenticationPrincipal User principal) {
        String email = principal.getUsername();
        List<WalletResponseDTO> list = listUc.execute(email);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WalletResponseDTO> get(
            @AuthenticationPrincipal User principal,
            @PathVariable Long id) {
        String email = principal.getUsername();
        WalletResponseDTO dto = getUc.execute(email, id);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WalletResponseDTO> update(
            @AuthenticationPrincipal User principal,
            @PathVariable Long id,
            @RequestBody @Validated WalletRequestDTO request) {
        String email = principal.getUsername();
        WalletResponseDTO dto = updateUc.execute(email, id, request);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @AuthenticationPrincipal User principal,
            @PathVariable Long id) {
        String email = principal.getUsername();
        deleteUc.execute(email, id);
        return ResponseEntity.noContent().build();
    }
}
