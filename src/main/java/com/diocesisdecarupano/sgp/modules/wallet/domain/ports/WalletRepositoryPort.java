package com.diocesisdecarupano.sgp.modules.wallet.domain.ports;

import com.diocesisdecarupano.sgp.modules.wallet.domain.model.Wallet;
import java.util.List;
import java.util.Optional;

public interface WalletRepositoryPort {
    /**
     * Crea o actualiza una Wallet.
     * 
     * @param wallet la wallet de dominio
     * @return la wallet persistida con su id
     */
    Wallet save(Wallet wallet);

    /**
     * Busca una wallet por su id.
     * 
     * @param id identificador de la wallet
     * @return Optional con la wallet si existe
     */
    Optional<Wallet> findById(Long id);

    /**
     * Lista todas las wallets de un usuario.
     * 
     * @param userId id del usuario dueño de las wallets
     * @return lista de wallets asociadas al usuario
     */
    List<Wallet> findAllByUserId(Long userId);

    /**
     * Elimina una wallet por su id.
     * 
     * @param id identificador de la wallet a eliminar
     */
    void deleteById(Long id);
}
