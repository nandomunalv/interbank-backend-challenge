package com.interview.retobackendinterbank.app.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseCustomerDto {

    private Long id;

    private String codigoUnico;

    private String nombres;

    private String apellidos;

    private String tipoDocumento;

    private String numeroDocumento;
}
