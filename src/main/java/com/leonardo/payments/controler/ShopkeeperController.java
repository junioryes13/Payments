package com.leonardo.payments.controler;

import com.leonardo.payments.model.DTO.ShopkeeperRequest;
import com.leonardo.payments.model.DTO.ShopkeeperResponse;
import com.leonardo.payments.model.PersonalReturn;
import com.leonardo.payments.model.Shopkeeper;
import com.leonardo.payments.security.service.ShopkeeperService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
@RequestMapping("/lojista")
public class ShopkeeperController {


    @Autowired
    ShopkeeperService ShopkeeperService;


    @PostMapping
    @Transactional
    public ResponseEntity<ShopkeeperResponse> Salvar(@Valid @RequestBody ShopkeeperRequest request) throws Exception {
        PersonalReturn rtrm =  ShopkeeperService.salvar(request);
        if(rtrm.getSucess()){
            return ResponseEntity.ok().body(new ShopkeeperResponse((Shopkeeper) rtrm.getObject().get()));
        }else{
            return ResponseEntity.badRequest().build();
        }

    }


    @GetMapping
    public ArrayList<ShopkeeperResponse> listAll() throws Exception {
        return (ArrayList<ShopkeeperResponse>) ShopkeeperService.listarTodos();
    }
}
