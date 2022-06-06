package com.github.maikoncarlos.apiexternacep.service;

import com.github.maikoncarlos.apiexternacep.client.ComunicacaoApiExterna;
import com.github.maikoncarlos.apiexternacep.dto.response.EnderecoResponse;
import com.github.maikoncarlos.apiexternacep.exception.CepNullException;
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
        boolean cepNull = (end.getLogradouro() == null);
        if (cepNull) {
            log.error("ERROR - CEP INVÁLIDO, RETORNO DO CEP COM VALORES NULOS {}", cepNull);
            throw new CepNullException("cep inválido, retorno nulo");
        } else {
            log.info("RETORNO {} -> SUCESSO : ", end);
            return end;
        }
    }
}


