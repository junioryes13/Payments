package com.leonardo.payments.apiexterna;

import com.leonardo.payments.model.DTO.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

//Feing que simula uma API externa

@FeignClient(name = "sistema-notificacao", url = "https://run.mocky.io/v3/54dc2cf1-3add-45b5-b5a9-6bf7e7f1f4a6")
public interface APINotification {

    @PostMapping
    ApiResponse sendNotification();
}