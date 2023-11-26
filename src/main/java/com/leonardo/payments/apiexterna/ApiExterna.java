package com.leonardo.payments.apiexterna;


import com.leonardo.payments.model.DTO.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

//Feing que simula uma API externa


@FeignClient(name = "sistema-externo", url = "https://run.mocky.io/v3/5794d450-d2e2-4412-8131-73d0293ac1cc")
//@FeignClient(name = "sistema-externo", url = "localhost:8080/api-externa") - não fuciona
public interface ApiExterna {

    @PostMapping
    ApiResponse comunicaSistemaRanking();
}