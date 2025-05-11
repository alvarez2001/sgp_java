package com.diocesisdecarupano.sgp.modules.bank.infrastructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diocesisdecarupano.sgp.modules.bank.application.dto.BankRequestDTO;
import com.diocesisdecarupano.sgp.modules.bank.application.dto.BankResponseDTO;
import com.diocesisdecarupano.sgp.modules.bank.application.dto.BankSearchCriteriaDTO;
import com.diocesisdecarupano.sgp.modules.bank.application.dto.BankUpdateRequestDTO;
import com.diocesisdecarupano.sgp.modules.bank.application.usecase.CreateBankUseCase;
import com.diocesisdecarupano.sgp.modules.bank.application.usecase.DeleteBankUseCase;
import com.diocesisdecarupano.sgp.modules.bank.application.usecase.GetBankUseCase;
import com.diocesisdecarupano.sgp.modules.bank.application.usecase.PaginateBankUseCase;
import com.diocesisdecarupano.sgp.modules.bank.application.usecase.UpdateBankUseCase;

@RestController
@RequestMapping("/banks")
public class BankController {
    @Autowired
    private CreateBankUseCase createUseCase;

    @Autowired
    private PaginateBankUseCase paginateUseCase;

    @Autowired
    private GetBankUseCase getUseCase;

    @Autowired
    private UpdateBankUseCase updateUseCase;

    @Autowired
    private DeleteBankUseCase deleteUseCase;

    @PostMapping
    public ResponseEntity<BankResponseDTO> create(
            @RequestBody @Validated BankRequestDTO request) {
        BankResponseDTO dto = createUseCase.execute(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @GetMapping
    public ResponseEntity<Page<BankResponseDTO>> paginate(
            @Validated @ModelAttribute BankSearchCriteriaDTO criteria, Pageable pageable) {
        Page<BankResponseDTO> page = paginateUseCase.execute(criteria, pageable);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BankResponseDTO> get(@PathVariable Long id) {
        BankResponseDTO dto = getUseCase.execute(id);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BankResponseDTO> update(@PathVariable Long id,
            @RequestBody @Validated BankUpdateRequestDTO request) {
        BankResponseDTO dto = updateUseCase.execute(id, request);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {
        deleteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
