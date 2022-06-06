package com.github.maikoncarlos.apiexternacep.service;

import com.github.maikoncarlos.apiexternacep.client.ComunicacaoApiExterna;
import com.github.maikoncarlos.apiexternacep.dto.response.EnderecoResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Slf4j
public class EnderecoService {

    private ComunicacaoApiExterna comunicacaoApiExterna;

    public EnderecoResponse findByCep(String cep) {
        log.info("COMUNICANDO COM API EXTERNA VIACEP");
        log.info("PESQUISA PELO CEP {} ", cep);
        EnderecoResponse end = comunicacaoApiExterna.getEnderecoPorCep(cep);
        log.info("RETORNO {} -> SUCESSO : ", end);
        return end;
    }
}


