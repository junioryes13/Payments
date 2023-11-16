package com.leonardo.payments.security.service;

import com.leonardo.payments.model.DTO.UserRequest;
import com.leonardo.payments.model.DTO.UserResponse;
import com.leonardo.payments.model.PersonalReturn;
import com.leonardo.payments.model.User;
import com.leonardo.payments.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository UserRepository;

    public PersonalReturn salvar(UserRequest request){
        User User = new User( request);
        return new PersonalReturn(true, "Sucess", Optional.of(UserRepository.save(User)));
    }


    public List<UserResponse> listarTodos() {
        List<User> UserList = UserRepository.findAll();
        Iterator<User> iteratorDeNomes = UserList.iterator();
        List<UserResponse> listaConvertidaDoIterator = new ArrayList<>();
        iteratorDeNomes.forEachRemaining(n -> listaConvertidaDoIterator.add(new UserResponse(n)));
        return listaConvertidaDoIterator;
    }
}
