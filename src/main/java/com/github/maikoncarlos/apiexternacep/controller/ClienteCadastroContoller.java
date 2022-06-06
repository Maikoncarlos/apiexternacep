package com.github.maikoncarlos.apiexternacep.controller;

import com.github.maikoncarlos.apiexternacep.dto.response.EnderecoResponse;
import com.github.maikoncarlos.apiexternacep.service.EnderecoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class ClienteCadastroContoller {

    private EnderecoService enderecoService;

    @GetMapping("/{cep}")
    public ResponseEntity<EnderecoResponse> getCep(@PathVariable("cep") String cep) {
        EnderecoResponse end = enderecoService.findByCep(cep);
        return ResponseEntity.ok().body(end);
    }
}
