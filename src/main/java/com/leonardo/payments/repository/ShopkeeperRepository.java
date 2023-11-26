package com.leonardo.payments.repository;

import com.leonardo.payments.model.Shopkeeper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShopkeeperRepository extends JpaRepository<Shopkeeper, Integer> {
    Optional<Shopkeeper> findByCnpj(Integer payee);
}
