package com.leonardo.payments.repository;

import com.leonardo.payments.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    List<Payment> findByPayer(int id);
    List<Payment> findByPayee(int id);
    
}
