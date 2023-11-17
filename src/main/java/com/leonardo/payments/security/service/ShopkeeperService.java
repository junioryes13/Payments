package com.leonardo.payments.security.service;

import com.leonardo.payments.model.DTO.ShopkeeperRequest;
import com.leonardo.payments.model.DTO.ShopkeeperResponse;
import com.leonardo.payments.model.PersonalReturn;
import com.leonardo.payments.model.Shopkeeper;
import com.leonardo.payments.model.User;
import com.leonardo.payments.repository.ShopkeeperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class ShopkeeperService {

    @Autowired
    private ShopkeeperRepository shopkeeperRepository;

    public Shopkeeper salvar(ShopkeeperRequest request){
        Shopkeeper shopkeeper = new Shopkeeper( request);
        shopkeeperRepository.save(shopkeeper);
       return shopkeeper;
    }


    public List<ShopkeeperResponse> listarTodos() {
        List<Shopkeeper> shopkeeperList = shopkeeperRepository.findAll();
        Iterator<Shopkeeper> iteratorDeNomes = shopkeeperList.iterator();
        List<ShopkeeperResponse> listaConvertidaDoIterator = new ArrayList<>();
        iteratorDeNomes.forEachRemaining(n -> listaConvertidaDoIterator.add(new ShopkeeperResponse(n)));
        return listaConvertidaDoIterator;
    }

    public Optional<Shopkeeper> findById(int id) {
        Optional<Shopkeeper> resultado = shopkeeperRepository.findById(id);
        return  resultado;
    }
}
