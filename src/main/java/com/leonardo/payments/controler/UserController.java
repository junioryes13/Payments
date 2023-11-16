package com.leonardo.payments.controler;

import com.leonardo.payments.model.DTO.UserRequest;
import com.leonardo.payments.model.DTO.UserResponse;
import com.leonardo.payments.model.PersonalReturn;
import com.leonardo.payments.model.User;
import com.leonardo.payments.security.service.UserService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("/usuario")
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping
    @Transactional
    public ResponseEntity<UserResponse> Salvar(@RequestBody UserRequest request) throws Exception {
        PersonalReturn rtrm =  userService.salvar(request);
        if(rtrm.getSucess()){
            return ResponseEntity.ok().body(new UserResponse((User) rtrm.getObject().get()));
        }else{
            return ResponseEntity.badRequest().build();
        }

    }


    @GetMapping
    public ArrayList<UserResponse> listAll() throws Exception {
        return (ArrayList<UserResponse>) userService.listarTodos();
    }




}
