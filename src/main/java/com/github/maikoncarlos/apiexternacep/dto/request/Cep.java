package com.github.maikoncarlos.apiexternacep.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Cep {

    @NotBlank
    @Size(min = 8)
    private String cep;
}
