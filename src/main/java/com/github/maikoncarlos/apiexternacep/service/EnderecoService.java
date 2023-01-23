package com.github.maikoncarlos.apiexternacep.service;

import com.github.maikoncarlos.apiexternacep.client.ComunicacaoApiExterna;
import com.github.maikoncarlos.apiexternacep.dto.response.EnderecoResponse;
import com.github.maikoncarlos.apiexternacep.exception.CepNullException;
import feign.FeignException;
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

        try {
            EnderecoResponse end = comunicacaoApiExterna.getEnderecoPorCep(cep);
            boolean cepNull = (end.getRua() == null);
            if (cepNull) {
                log.error("ERROR - CEP INVÁLIDO, O RETORNO DO CEP {} está {}", end.getCep(), end.getRua());
                throw new CepNullException("Cep incorreto, endereço nulo!");
            } else {
                log.info("SUCESSO - RETORNO {}  : ", end);
                return end;
            }
        }catch (FeignException ex){
            log.error("Cep inválido  : " + ex.getMessage());
            throw new CepNullException("Cep inválido  : " + ex.getMessage());
        }

    }
}


