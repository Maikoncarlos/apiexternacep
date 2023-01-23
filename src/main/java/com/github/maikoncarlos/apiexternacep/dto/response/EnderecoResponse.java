package com.github.maikoncarlos.apiexternacep.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EnderecoResponse {
    
    private String cep;
    @JsonProperty("logradouro")
    private String rua;
    private String bairro;
    private String localidade;
    private String uf;
}

