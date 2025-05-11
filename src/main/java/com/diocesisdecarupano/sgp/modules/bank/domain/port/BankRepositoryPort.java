package com.diocesisdecarupano.sgp.modules.bank.domain.port;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.diocesisdecarupano.sgp.modules.bank.application.dto.BankSearchCriteriaDTO;
import com.diocesisdecarupano.sgp.modules.bank.domain.model.BankModel;

public interface BankRepositoryPort {

    BankModel save(BankModel model);

    Optional<BankModel> findById(Long id);

    List<BankModel> findAll();

    Page<BankModel> paginate(BankSearchCriteriaDTO searchCriteriaDTO, Pageable pageable);

    void deleteById(Long id);

    boolean existsByAccountNumber(String accountNumber);
}
