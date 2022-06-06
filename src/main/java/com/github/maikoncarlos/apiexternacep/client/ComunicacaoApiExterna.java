package com.github.maikoncarlos.apiexternacep.client;

import com.github.maikoncarlos.apiexternacep.dto.response.EnderecoResponse;
import feign.FeignException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ComunicacaoApiExterna {

    @GetMapping("/{cep}/json")
    EnderecoResponse getEnderecoPorCep(@PathVariable("cep") String cep);
}
