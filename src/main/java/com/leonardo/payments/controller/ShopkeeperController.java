package com.leonardo.payments.controller;

import com.leonardo.payments.model.DTO.ShopkeeperRequest;
import com.leonardo.payments.model.DTO.ShopkeeperResponse;
import com.leonardo.payments.model.DTO.UserResponse;
import com.leonardo.payments.model.PersonalReturn;
import com.leonardo.payments.model.Shopkeeper;
import com.leonardo.payments.model.User;
import com.leonardo.payments.security.service.ShopkeeperService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/lojista")
public class ShopkeeperController {


    @Autowired
    ShopkeeperService shopkeeperService;


    @PostMapping
    @Transactional
    public ResponseEntity<ShopkeeperResponse> Salvar(@Valid @RequestBody ShopkeeperRequest request) throws Exception {
        ShopkeeperResponse rtrm = new ShopkeeperResponse(shopkeeperService.salvar(request));
        return ResponseEntity.status(HttpStatus.OK).body(rtrm);

    }


    @GetMapping
    public ArrayList<ShopkeeperResponse> listAll() throws Exception {
        return (ArrayList<ShopkeeperResponse>) shopkeeperService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShopkeeperResponse> detalhe(@PathVariable int id) {
        Optional<Shopkeeper> resultado = shopkeeperService.findById(id);
        return resultado.isPresent() ? ResponseEntity.ok(new ShopkeeperResponse(resultado.get()))
                : ResponseEntity.notFound().build();
    }

}
