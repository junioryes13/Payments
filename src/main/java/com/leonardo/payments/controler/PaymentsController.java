package com.leonardo.payments.controler;

import com.leonardo.payments.model.DTO.PaymentRequest;
import com.leonardo.payments.model.DTO.PaymentResponse;
import com.leonardo.payments.model.Payment;
import com.leonardo.payments.model.PersonalReturn;
import com.leonardo.payments.security.service.PaymentsService;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/pagamento")
public class PaymentsController {

    @Autowired
    private PaymentsService paymentService;


    @PostMapping
    @Transactional
    public ResponseEntity<PaymentResponse> Salvar(@jakarta.validation.Valid @RequestBody PaymentRequest request) throws Exception {
        PersonalReturn retorno = paymentService.makePayment(request);

        if(retorno.getSucess()){
            return ResponseEntity.ok().body(new PaymentResponse((Payment) retorno.getObject().get()));
        }else{
            return ResponseEntity.badRequest().build();
        }

    }

    @GetMapping
    public ArrayList<Payment> listar() throws Exception {
       return paymentService.listPayments();

    }


}
