package com.leonardo.payments.controller;

import com.leonardo.payments.model.DTO.PaymentRequest;
import com.leonardo.payments.model.DTO.PaymentResponse;
import com.leonardo.payments.model.Payment;
import com.leonardo.payments.model.PersonalReturn;
import com.leonardo.payments.security.service.PaymentsService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/pagamento")
public class PaymentsController {

    @Autowired
    private PaymentsService paymentService;


    @PostMapping
    @Transactional
    public ResponseEntity<PaymentResponse> Salvar(@Valid @RequestBody PaymentRequest request) throws Exception {
        PaymentResponse retorno =new PaymentResponse(paymentService.makePayment(request));
        return ResponseEntity.status(HttpStatus.OK).body(retorno);
    }

    @GetMapping
    public ArrayList<Payment> listar() throws Exception {
       return paymentService.listPayments();
    }
}
