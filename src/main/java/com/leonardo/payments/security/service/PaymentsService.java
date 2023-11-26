package com.leonardo.payments.security.service;

import com.leonardo.payments.apiexterna.APINotification;
import com.leonardo.payments.apiexterna.ApiExterna;
import com.leonardo.payments.excecao.RegraNegocioException;
import com.leonardo.payments.model.DTO.ApiResponse;
import com.leonardo.payments.model.DTO.PaymentRequest;
import com.leonardo.payments.model.DTO.PaymentResponse;
import com.leonardo.payments.model.Payment;
import com.leonardo.payments.model.People;
import com.leonardo.payments.model.Shopkeeper;
import com.leonardo.payments.model.User;
import com.leonardo.payments.repository.PaymentRepository;
import com.leonardo.payments.repository.ShopkeeperRepository;
import com.leonardo.payments.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

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

    @Autowired
    private ApiExterna apiExterna;

    @Autowired
    private APINotification apiNotification;


    public Payment makePayment(PaymentRequest payment) {
        Optional<User> payer = userRepository.findByCpf(payment.getPayer());
        if (payer.isPresent()) {
            switch (payment.getPayee().toString().length()) {
                case 7:
                    Optional<User> payee = userRepository.findByCpf(payment.getPayee());
                    if (!payee.isPresent()) {
                        throw new RegraNegocioException("O CPF/CNPJ informado para o recebedor não existe no banco de dados");
                    } else {
                        if (balanceValidation(payer.get(), payment.getValue())) {
                            ApiResponse autorizado = apiExterna.comunicaSistemaRanking();
                            if (autorizado.getMessage().equals("Autorizado")) {
                                payer.get().atualizarSaldo(payment.getValue());
                                userRepository.save(payer.get());
                                User recebedor = payee.get();
                                recebedor.atualizarSaldo(recebedor.getSaldo() + payment.getValue());
                                userRepository.save(recebedor);
                                return null;
                            } else {
                                throw new RegraNegocioException("Saldo do pagador é insuficiente para realizar essa transação");
                            }
                        }
                    }
                case 16:
                    Optional<Shopkeeper> payee2 = shopkeeperRepository.findByCnpj(payment.getPayee());
                    if (!payee2.isPresent()) {
                        throw new RegraNegocioException("O CPF/CNPJ informado para o recebedor não existe no banco de dados");
                    } else {
                        if (balanceValidation(payer.get(), payment.getValue())) {
                            ApiResponse autorizado = apiExterna.comunicaSistemaRanking();
                            if (autorizado.getMessage().equals("Autorizado")) {
                                payer.get().atualizarSaldo( payer.get().getSaldo() - payment.getValue());
                                userRepository.save(payer.get());
                                Shopkeeper recebedor = payee2.get();
                                recebedor.atualizarSaldo(recebedor.getSaldo() + payment.getValue());
                                shopkeeperRepository.save(recebedor);
                                return null;
                            } else {
                                throw new RegraNegocioException("Saldo do pagador é insuficiente para realizar essa transação");
                            }
                        }
                    }

                default:
                    throw new RegraNegocioException("O CPF/CNPJ informado é invalido");
            }

        } else {
            throw new RegraNegocioException("O id informado para o pagador não existe no banco de dados ou não pode realizar ");
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


    public void sendNotification(People payee) {
        ApiResponse autorizado = apiNotification.sendNotification();
        if (!autorizado.getMessage().equals("true")) {
            throw new RegraNegocioException("Transação não autorizada");
        }
    }
}