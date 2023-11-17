package com.leonardo.payments.controller;

import com.leonardo.payments.model.DTO.UserRequest;
import com.leonardo.payments.model.DTO.UserResponse;
import com.leonardo.payments.model.PersonalReturn;
import com.leonardo.payments.model.User;
import com.leonardo.payments.security.service.UserService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;


@RestController
@RequestMapping("/usuario")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    @Transactional
    public ResponseEntity<UserResponse> Salvar(@Valid @RequestBody UserRequest request) throws Exception {
        UserResponse rtrm = new UserResponse(userService.salvar(request));
       return ResponseEntity.status(HttpStatus.OK).body(rtrm);
    }


    @GetMapping
    public ArrayList<UserResponse> listAll() throws Exception {
        return (ArrayList<UserResponse>) userService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> detalhe(@PathVariable int id) {
        Optional<User> resultado = userService.findById(id);
        return resultado.isPresent() ? ResponseEntity.ok(new UserResponse(resultado.get()))
                : ResponseEntity.notFound().build();
    }
}
