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
    private UserRepository userRepository;

    public User salvar(UserRequest request){
        User user = new User( request);
        userRepository.save(user);
        return user;
    }


    public List<UserResponse> listarTodos() {
        List<User> UserList = userRepository.findAll();
        Iterator<User> iteratorDeNomes = UserList.iterator();
        List<UserResponse> listaConvertidaDoIterator = new ArrayList<>();
        iteratorDeNomes.forEachRemaining(n -> listaConvertidaDoIterator.add(new UserResponse(n)));
        return listaConvertidaDoIterator;
    }

    public Optional<User> findById(int id) {
            Optional<User> resultado = userRepository.findById(id);
            return  resultado;
    }
}
