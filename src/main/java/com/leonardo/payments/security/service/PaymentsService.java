package com.leonardo.payments.security.service;

import com.leonardo.payments.model.DTO.PaymentRequest;
import com.leonardo.payments.model.Payment;
import com.leonardo.payments.model.PersonalReturn;
import com.leonardo.payments.model.User;
import com.leonardo.payments.repository.PaymentRepository;
import com.leonardo.payments.repository.ShopkeeperRepository;
import com.leonardo.payments.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class PaymentsService {
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ShopkeeperRepository shopkeeperRepository;


    public PersonalReturn makePayment(PaymentRequest payment) {
        Optional<User> user = userRepository.findById(payment.getPayer());
        if (user.isPresent()) {
            if (balanceValidation(user.get(), payment.getValue())) {
                user.get().atualizarSaldo(payment.getValue());
                userRepository.save(user.get());
                Payment payment2 = new Payment(payment);
                paymentRepository.save(payment2);
                return new PersonalReturn(true, "sucesso", Optional.of(payment2));

            } else {
                return new PersonalReturn(false, "saldo da conta insuficiente");
            }
        } else {

            return new PersonalReturn(false, "Não foi encontrado nenhum usuario que possa realizar a transação com o ID informado ");
        }
    }

    public ArrayList<Payment> listPayments() {
       return (ArrayList<Payment>) paymentRepository.findAll();
    }

    public Boolean balanceValidation(User payer, Double payment) {
        if (payer.getSaldo() > payment) {
            return false;
        } else {
            return true;
        }
    }
}